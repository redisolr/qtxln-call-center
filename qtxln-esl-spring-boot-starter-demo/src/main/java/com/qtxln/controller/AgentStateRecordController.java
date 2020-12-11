package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.AgentStateRecordBO;
import com.aegis.fs.model.vo.AgentStateRecordVO;
import com.aegis.fs.service.AgentStateRecordService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 坐席状态记录表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/api/v1/agent_state_record")
public class AgentStateRecordController extends BaseController {

  private final AgentStateRecordService agentStateRecordService;

  public AgentStateRecordController(AgentStateRecordService agentStateRecordService) {
    this.agentStateRecordService = agentStateRecordService;
  }

  @GetMapping()
  public InvokerPageResult<List<AgentStateRecordVO>> listAgentStateRecord(@Validated(value = {AgentStateRecordVO.GroupQuery.class}) AgentStateRecordVO agentStateRecordVO) {
    AgentStateRecordBO agentStateRecordBO = new AgentStateRecordBO();
    BeanUtils.copyProperties(agentStateRecordVO, agentStateRecordBO);
    IPage<AgentStateRecordBO> page = agentStateRecordService.listAgentStateRecord(agentStateRecordBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<AgentStateRecordVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

