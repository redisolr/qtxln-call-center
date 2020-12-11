package com.qtxln.controller;

import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.AgentInfoStatisticsBO;
import com.aegis.fs.model.vo.AgentInfoStatisticsVO;
import com.aegis.fs.service.CallStatisticsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通话统计前端控制器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/1 10:20 上午
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/call_statistics")
public class CallStatisticsController extends BaseController{

  private final CallStatisticsService callStatisticsService;

  @Autowired
  public CallStatisticsController(CallStatisticsService callStatisticsService) {
    this.callStatisticsService = callStatisticsService;
  }

  @GetMapping("agent_call_info/{agent}")
  public InvokerResult<AgentInfoStatisticsVO> getAgentCallInfo(@PathVariable String agent){
    AgentInfoStatisticsBO agentInfo = callStatisticsService.getAgentInfo(agent);
    AgentInfoStatisticsVO agentInfoStatisticsVO = new AgentInfoStatisticsVO();
    BeanUtils.copyProperties(agentInfo, agentInfoStatisticsVO);
    return ResultExt.successWithData(agentInfoStatisticsVO);
  }

}
