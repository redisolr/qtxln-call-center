package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.CallCenterSkillGroupAgentBO;
import com.aegis.fs.model.vo.CallCenterSkillGroupAgentVO;
import com.aegis.fs.service.CallCenterSkillGroupAgentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 技能组坐席表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-03
 */
@RestController
@RequestMapping("api/v1/call_center_skill_group_agent")
public class CallCenterSkillGroupAgentController extends BaseController {

  private final CallCenterSkillGroupAgentService callCenterSkillGroupAgentService;

  @Autowired
  public CallCenterSkillGroupAgentController(CallCenterSkillGroupAgentService callCenterSkillGroupAgentService) {
    this.callCenterSkillGroupAgentService = callCenterSkillGroupAgentService;
  }

  @PostMapping()
  public InvokerResult<Boolean> insertCallCenterSkillGroupAgent(@Validated(value = {CallCenterSkillGroupAgentVO.GroupInsert.class})
                                                                @RequestBody CallCenterSkillGroupAgentVO callCenterSkillGroupAgentVO) {
    CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO = new CallCenterSkillGroupAgentBO();
    BeanUtils.copyProperties(callCenterSkillGroupAgentVO, callCenterSkillGroupAgentBO);
    return ResultExt.successWithData(callCenterSkillGroupAgentService.insertCallCenterSkillGroupAgent(callCenterSkillGroupAgentBO));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateCallCenterSkillGroupAgent(@Validated(value = {CallCenterSkillGroupAgentVO.GroupUpdate.class})
                                                                @RequestBody CallCenterSkillGroupAgentVO callCenterSkillGroupAgentVO) {
    CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO = new CallCenterSkillGroupAgentBO();
    BeanUtils.copyProperties(callCenterSkillGroupAgentVO, callCenterSkillGroupAgentBO);
    return ResultExt.successWithData(callCenterSkillGroupAgentService.updateCallCenterSkillGroupAgent(callCenterSkillGroupAgentBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteCallCenterSkillGroupAgent(@PathVariable Long id) {
    return ResultExt.successWithData(callCenterSkillGroupAgentService.deleteCallCenterSkillGroupAgent(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<CallCenterSkillGroupAgentVO> getCallCenterSkillGroupAgent(@PathVariable Long id) {
    CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO = callCenterSkillGroupAgentService.getCallCenterSkillGroupAgent(id);
    CallCenterSkillGroupAgentVO callCenterSkillGroupAgentVO = new CallCenterSkillGroupAgentVO();
    BeanUtils.copyProperties(callCenterSkillGroupAgentBO, callCenterSkillGroupAgentVO);
    return ResultExt.successWithData(callCenterSkillGroupAgentVO);
  }

  @GetMapping()
  public InvokerPageResult<List<CallCenterSkillGroupAgentVO>> listCallCenterSkillGroupAgent(@Validated(value = {CallCenterSkillGroupAgentVO.GroupQuery.class}) CallCenterSkillGroupAgentVO callCenterSkillGroupAgentVO) {
    CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO = new CallCenterSkillGroupAgentBO();
    BeanUtils.copyProperties(callCenterSkillGroupAgentVO, callCenterSkillGroupAgentBO);
    IPage<CallCenterSkillGroupAgentBO> page = callCenterSkillGroupAgentService.listCallCenterSkillGroupAgent(callCenterSkillGroupAgentBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<CallCenterSkillGroupAgentVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

