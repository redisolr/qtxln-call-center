package com.qtxln.core.cb;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.qtxln.component.constants.call.CallTypeEnum;
import com.qtxln.component.constants.call.HangupCauseEnum;
import com.qtxln.component.constants.call.SatisfactionEnum;
import com.qtxln.component.util.DateUtils;
import com.qtxln.component.util.ElasticSearchUtils;
import com.qtxln.model.entity.CallBill;
import com.qtxln.model.handler.FsEvent;
import com.qtxln.service.CallBillService;
import com.qtxln.service.es.ElasticSearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 话单生成
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 14:46
 * @since 1.0
 */
@Component
public class CallBillGenerate {

  private static final String SATISFACTION_NUMBER = "6666";

  private final CallBillService callBillService;
  private final ElasticSearchService elasticSearchService;

  public CallBillGenerate(CallBillService callBillService, ElasticSearchService elasticSearchService) {
    this.callBillService = callBillService;
    this.elasticSearchService = elasticSearchService;
  }

  public synchronized void assemblyObject(FsEvent fsEvent) {
    // 多注册处理
    if (multiRegister(fsEvent.getHangupCause())) {
      return;
    }
    // 满意度处理
    if (Objects.equals(fsEvent.getCallerDestinationNumber().replace(",", ""), SATISFACTION_NUMBER)) {
      List<CallBill> callBillList = callBillService.getByMemberSessionId(fsEvent.getUniqueId());
      if (CollUtil.isNotEmpty(callBillList)) {
        // 获取满意度按键信息
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
            .must(QueryBuilders.matchQuery("Unique-ID", fsEvent.getUniqueId()))
            .must(QueryBuilders.matchQuery("Caller-Destination-Number", SATISFACTION_NUMBER))
            .must(QueryBuilders.matchQuery("Event-Name", "DTMF"));
        SearchSourceBuilder searchSourceBuilder = ElasticSearchUtils.initSearchSourceBuilder(boolQueryBuilder);
        List<FsEvent> fsEventList = elasticSearchService.search("fs_event", searchSourceBuilder, FsEvent.class);
        CallBill callBill = new CallBill();
        callBill.setId(callBillList.get(0).getId());
        callBill.setSatisfaction(SatisfactionEnum.NOT_EVALUATED.getSf());
        if (CollUtil.isNotEmpty(fsEventList)) {
          String dtmfDigit = fsEventList.get(0).getDtmfDigit();
          callBill.setSatisfaction(getSatisfaction(dtmfDigit));
        }
        callBillService.updateById(callBill);
      }
      return;
    }

    CallBill callBill = new CallBill();
    // 如果电话已经路由到坐席,第一次电话(a-leg)的挂断不进行入库,只存储路由到坐席上的数据.
    boolean flag = StrUtil.isNotBlank(fsEvent.getUniqueId());
    if (flag) {
      int count = callBillService.countByMemberSessionId(fsEvent.getUniqueId());
      if (count > 0) {
        callBill.setEffective(Boolean.FALSE);
      }
    }
    callBill.setCallType(changeCallType(fsEvent));
    // fs挂断原因
    callBill.setHangupCause(fsEvent.getHangupCause());
    // 挂断原因业务含义
    callBill.setHangupCauseStr(changeHangupCase(fsEvent, callBill.getCallType()));
    // 主叫
    callBill.setCallerNumber(fsEvent.getCallerCallerIdNumber());
    // 被叫
    callBill.setCalledNumber(fsEvent.getCallerDestinationNumber().replace(",", ""));
    // 通道id
    callBill.setUniqueId(fsEvent.getUniqueId());
    LocalDateTime callTime = DateUtils.microsecondsToLocalDateTime(fsEvent.getCallerChannelCreatedTime());
    // 通话开始时间
    callBill.setCallTime(callTime);
    LocalDateTime hangUpTime = DateUtils.strToLocalDateTime(fsEvent.getEventDateLocal());
    // 挂断事件
    callBill.setHangUpTime(hangUpTime);
    // 通话总时长.从通道创建开始计算
    callBill.setTotalTime(fsEvent.getVariableDuration());
    if (StrUtil.isNotBlank(fsEvent.getVariableAnswerStamp())) {
      LocalDateTime answerTime = DateUtils.strToLocalDateTime(fsEvent.getVariableAnswerStamp());
      // 应答时间
      callBill.setAnswerTime(answerTime);
    }
    // 通话时长.从应答开始计算.可用于计费的时长
    callBill.setTalkTime(fsEvent.getVariableBillSec());
    if (StrUtil.isNotBlank(fsEvent.getVariableCcQueue())) {
      callBill.setSkillGroup(fsEvent.getVariableCcQueue());
    }
    if (StrUtil.isNotBlank(fsEvent.getVariableCcMemberSessionUuid())) {
      callBill.setMemberSessionId(fsEvent.getVariableCcMemberSessionUuid());
    } else {
      callBill.setMemberSessionId(fsEvent.getUniqueId());
    }
    if (StrUtil.isNotBlank(fsEvent.getVariableCcAgent())) {
      // 坐席名
      callBill.setAgent(fsEvent.getVariableCcAgent());
    }
    // 满意度 默认 未评价
    callBill.setSatisfaction(SatisfactionEnum.NOT_EVALUATED.getSf());
    // 是否转接
    boolean isTransfer = Objects.equals(callBill.getCallType(), CallTypeEnum.INBOUND.getCt()) &&
        (StrUtil.isNotBlank(fsEvent.getOtherLegRDNIS()) || StrUtil.isBlank(fsEvent.getOtherLegUniqueId()));
    callBill.setTransfer(isTransfer);
    // 如果是外呼做特殊处理
    if (Objects.equals(callBill.getCallType(), CallTypeEnum.OUTBOUND.getCt()) &&
        Objects.equals(callBill.getCallTime(), callBill.getAnswerTime())) {
      CallBill callBillOutBound = new CallBill();

      callBillOutBound.setUniqueId(fsEvent.getOtherLegUniqueId());
      callBillOutBound.setAgent(fsEvent.getCallerCallerIdNumber());
      callBillService.updateByUniqueId(callBillOutBound);
      return;
    }
    callBillService.save(callBill);
  }


  private boolean multiRegister(String hangUpCase) {
    return Objects.equals(hangUpCase, HangupCauseEnum.LOSE_RACE.toString());
  }


  /**
   * 改变呼叫类型
   *
   * @param fsEvent 事件信息
   * @return 呼叫类型
   */
  private String changeCallType(FsEvent fsEvent) {
    boolean flag = Objects.equals(fsEvent.getCallDirection(), CallTypeEnum.INBOUND.toString().toLowerCase())
        || (StrUtil.isNotBlank(fsEvent.getVariableCcQueue()) && StrUtil.isNotBlank(fsEvent.getVariableCcAgent()));
    if (flag) {
      return CallTypeEnum.INBOUND.getCt();
    }
    return CallTypeEnum.OUTBOUND.getCt();
  }

  /**
   * 改变挂断原因
   *
   * @param fsEvent  事件信息
   * @param callType 呼叫类型
   * @return 挂断原因含义
   */
  private String changeHangupCase(FsEvent fsEvent, String callType) {
    if (Objects.equals(callType, CallTypeEnum.OUTBOUND.getCt())) {
      if (Objects.equals(fsEvent.getHangupCause(), HangupCauseEnum.ORIGINATOR_CANCEL.toString())) {
        return HangupCauseEnum.NOT_CONNECTED.getHc();
      }
    } else {
      if (StrUtil.isBlank(fsEvent.getVariableCcQueue())) {
        return HangupCauseEnum.IVR_GIVE_UP.getHc();
      } else if (StrUtil.isBlank(fsEvent.getVariableCcAgent())) {
        return HangupCauseEnum.QUEUE_UP_GIVE_UP.getHc();
      } else if (Objects.equals(fsEvent.getHangupCause(), HangupCauseEnum.NO_ANSWER.toString())) {
        return HangupCauseEnum.QUEUE_UP_TIMEOUT.getHc();
      } else if (StrUtil.isBlank(fsEvent.getVariableAnswerStamp())) {
        if (Objects.equals(fsEvent.getHangupCause(), HangupCauseEnum.NORMAL_CLEARING.toString())) {
          return HangupCauseEnum.AGENT_GIVE_UP.getHc();
        } else if (Objects.equals(fsEvent.getHangupCause(), HangupCauseEnum.ORIGINATOR_CANCEL.toString())) {
          return HangupCauseEnum.RING_GIVE_UP.getHc();
        }
      }
    }
    return HangupCauseEnum.NORMAL.getHc();
  }

  /**
   * 获取满意度
   *
   * @param dtmfDigit 按键内容
   * @return 满意度
   */
  private String getSatisfaction(String dtmfDigit) {
    String satisfaction;
    switch (dtmfDigit) {
      case "1":
        satisfaction = SatisfactionEnum.VERY_SATISFIED.getSf();
        break;
      case "2":
        satisfaction = SatisfactionEnum.SATISFIED.getSf();
        break;
      case "3":
        satisfaction = SatisfactionEnum.NOT_SATISFIED.getSf();
        break;
      default:
        satisfaction = SatisfactionEnum.NOT_EVALUATED.getSf();
    }
    return satisfaction;
  }

}
