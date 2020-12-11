package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.AgentBasicsDataBO;
import com.aegis.fs.model.vo.AgentBasicsDataVO;
import com.aegis.fs.service.AgentBasicsDataService;
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
 * 坐席数据 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/api/v1/agent_basics_data")
public class AgentBasicsDataController extends BaseController {

  private final AgentBasicsDataService agentBasicsDataService;

  public AgentBasicsDataController(AgentBasicsDataService agentBasicsDataService) {
    this.agentBasicsDataService = agentBasicsDataService;
  }

  @GetMapping()
  public InvokerPageResult<List<AgentBasicsDataVO>> listPageAgentBasicsDataOneDay(
      @Validated(value = {AgentBasicsDataVO.GroupQuery.class}) AgentBasicsDataVO agentBasicsDataVO) {
    AgentBasicsDataBO agentBasicsDataBO = new AgentBasicsDataBO();
    BeanUtils.copyProperties(agentBasicsDataVO, agentBasicsDataBO);
    IPage<AgentBasicsDataBO> page = agentBasicsDataService.listPageAgentBasicsDataOneDay(agentBasicsDataBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<AgentBasicsDataVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

