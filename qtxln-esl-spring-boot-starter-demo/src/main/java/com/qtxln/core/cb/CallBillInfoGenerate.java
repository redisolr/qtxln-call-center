package com.qtxln.core.cb;

import com.qtxln.component.constants.FreeSwitchEventTypeEnum;
import com.qtxln.component.util.DateUtils;
import com.qtxln.component.util.ElasticSearchUtils;
import com.qtxln.model.core.cb.CallBillInfo;
import com.qtxln.model.handler.FsEvent;
import com.qtxln.service.es.ElasticSearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 话单详情生成
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-10 11:30
 * @since 1.0
 */
@Component
public class CallBillInfoGenerate {

  private final ElasticSearchService elasticSearchService;

  public CallBillInfoGenerate(ElasticSearchService elasticSearchService) {
    this.elasticSearchService = elasticSearchService;
  }

  public List<CallBillInfo> generateCallBillInfo(String uniqueId) {
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
        .must(QueryBuilders.matchQuery("Unique-ID", uniqueId))
        .mustNot(QueryBuilders.matchQuery("Event-Name", "CUSTOM"));
    SearchSourceBuilder searchSourceBuilder = ElasticSearchUtils.initSearchSourceBuilder(boolQueryBuilder);
    searchSourceBuilder.sort("Event-Date-Local.keyword", SortOrder.ASC);
    List<FsEvent> fsEventList = elasticSearchService.search("fs_event", searchSourceBuilder, FsEvent.class);
    // 不要使用HashMap,遍历会无序
    Map<String, FsEvent> fsEventMap = new LinkedHashMap<>(16);
    AtomicInteger count = new AtomicInteger(1);
    fsEventList.forEach(fsEvent -> {
      if (Objects.equals(fsEvent.getEventName(), FreeSwitchEventTypeEnum.CHANNEL_HOLD.toString())) {
        fsEventMap.put(fsEvent.getEventName() + "-" + count, fsEvent);
      } else if (Objects.equals(fsEvent.getEventName(), FreeSwitchEventTypeEnum.CHANNEL_UNHOLD.toString())) {
        fsEventMap.put(fsEvent.getEventName() + "-" + count.getAndIncrement(), fsEvent);
      } else {
        fsEventMap.put(fsEvent.getEventName(), fsEvent);
      }
    });
    List<CallBillInfo> callBillInfoList = new ArrayList<>();
    for (Map.Entry<String, FsEvent> entry : fsEventMap.entrySet()) {
      String eventName = entry.getKey();
      FsEvent fsEvent = entry.getValue();
      CallBillInfo callBillInfo = new CallBillInfo();
      callBillInfo.setEventName(fsEvent.getEventName());
      callBillInfo.setEventDateLocal(fsEvent.getEventDateLocal());
      if (Objects.equals(eventName, FreeSwitchEventTypeEnum.CHANNEL_CREATE.toString())) {
        callBillInfo.setDescribe("电话呼入");
      } else if (Objects.equals(eventName, FreeSwitchEventTypeEnum.CHANNEL_ANSWER.toString())) {
        callBillInfo.setDescribe("接听电话 振铃时长:" +
            DateUtils.betweenSecond(fsEventMap.get(FreeSwitchEventTypeEnum.CHANNEL_CREATE.toString()).getEventDateLocal(), fsEvent.getEventDateLocal()) + "s");
      } else if (Objects.equals(eventName, FreeSwitchEventTypeEnum.RECORD_START.toString())) {
        callBillInfo.setDescribe("录音开始");
      } else if (Objects.equals(eventName, FreeSwitchEventTypeEnum.RECORD_STOP.toString())) {
        if (!Objects.equals(fsEventMap.get(FreeSwitchEventTypeEnum.RECORD_START.toString()),  null)) {
          callBillInfo.setDescribe("录音结束 录音时长:" +
              DateUtils.betweenSecond(fsEventMap.get(FreeSwitchEventTypeEnum.RECORD_START.toString()).getEventDateLocal(), fsEvent.getEventDateLocal()) + "s");
        }
      } else if (Objects.equals(eventName, FreeSwitchEventTypeEnum.CHANNEL_BRIDGE.toString())) {
        callBillInfo.setDescribe("电话桥接");
      } else if (eventName.contains(FreeSwitchEventTypeEnum.DTMF.toString())) {
        callBillInfo.setDescribe("用户按键:'" + fsEvent.getDtmfDigit() + "'");
      } else if (eventName.contains(FreeSwitchEventTypeEnum.CHANNEL_HOLD.toString())) {
        callBillInfo.setDescribe("坐席点击了保持");
      } else if (eventName.contains(FreeSwitchEventTypeEnum.CHANNEL_UNHOLD.toString())) {
        String[] split = eventName.split("-");
        callBillInfo.setDescribe("坐席点击了取消保持 保持持续时间: " +
            DateUtils.betweenSecond(fsEventMap.get(FreeSwitchEventTypeEnum.CHANNEL_HOLD.toString() + "-" + split[1]).getEventDateLocal(), fsEvent.getEventDateLocal()) + "s");
      } else if (Objects.equals(eventName, FreeSwitchEventTypeEnum.CHANNEL_HANGUP_COMPLETE.toString())) {
        if (!Objects.equals(fsEventMap.get(FreeSwitchEventTypeEnum.CHANNEL_CREATE.toString()),  null)) {
          callBillInfo.setDescribe("电话挂断 通话时长:" +
              DateUtils.betweenSecond(fsEventMap.get(FreeSwitchEventTypeEnum.CHANNEL_CREATE.toString()).getEventDateLocal(), fsEvent.getEventDateLocal()) + "s");
        }
      }
      callBillInfoList.add(callBillInfo);
    }
    return callBillInfoList;
  }

}
