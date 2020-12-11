package com.qtxln.controller;

import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.vo.AgentOperationVO;
import com.aegis.fs.service.AgentOperationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分机常用操作前端控制器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-07 16:08
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1/agent_operation")
public class AgentOperationController extends BaseController {

  private final AgentOperationService agentOperationService;

  public AgentOperationController(AgentOperationService agentOperationService) {
    this.agentOperationService = agentOperationService;
  }

  @PostMapping("login")
  public InvokerResult<Boolean> extensionLogin(@RequestBody AgentOperationVO agentOperationVO) {
    return ResultExt.successWithData(agentOperationService.extensionLogin(agentOperationVO.getAddr(),
        agentOperationVO.getExtensionNumber(), agentOperationVO.getPassword()));
  }

  @PostMapping("logout")
  public InvokerResult<Boolean> extensionLogout(@RequestBody AgentOperationVO agentOperationVO) {
    return ResultExt.successWithData(agentOperationService.extensionLogout(agentOperationVO.getAddr(),
        agentOperationVO.getExtensionNumber()));
  }

  @PostMapping("ready")
  public InvokerResult<Boolean> extensionReady(@RequestBody AgentOperationVO agentOperationVO) {
    return ResultExt.successWithData(agentOperationService.extensionReady(agentOperationVO.getAddr(),
        agentOperationVO.getExtensionNumber()));
  }

  @PostMapping("no_ready")
  public InvokerResult<Boolean> extensionNoReady(@RequestBody AgentOperationVO agentOperationVO) {
    return ResultExt.successWithData(agentOperationService.extensionNoReady(agentOperationVO.getAddr(),
        agentOperationVO.getExtensionNumber()));
  }

}
