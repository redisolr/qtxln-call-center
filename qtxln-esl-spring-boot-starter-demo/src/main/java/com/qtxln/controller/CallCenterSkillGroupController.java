package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.CallCenterSkillGroupBO;
import com.qtxln.model.vo.CallCenterSkillGroupVO;
import com.qtxln.service.CallCenterSkillGroupService;
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
 * 技能组表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-02
 */
@RestController
@RequestMapping("api/v1/call_center_skill_group")
public class CallCenterSkillGroupController extends BaseController {

  private final CallCenterSkillGroupService callCenterSkillGroupService;

  @Autowired
  public CallCenterSkillGroupController(CallCenterSkillGroupService callCenterSkillGroupService) {
    this.callCenterSkillGroupService = callCenterSkillGroupService;
  }

  @PostMapping()
  public InvokerResult<Boolean> insertCallCenterSkillGroup(@Validated(value = {CallCenterSkillGroupVO.GroupInsert.class})
                                                           @RequestBody CallCenterSkillGroupVO callCenterSkillGroupVO) {
    CallCenterSkillGroupBO callCenterSkillGroupBO = new CallCenterSkillGroupBO();
    BeanUtils.copyProperties(callCenterSkillGroupVO, callCenterSkillGroupBO);
    return ResultExt.successWithData(callCenterSkillGroupService.insertCallCenterSkillGroup(callCenterSkillGroupBO));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateCallCenterSkillGroup(@Validated(value = {CallCenterSkillGroupVO.GroupUpdate.class})
                                                           @RequestBody CallCenterSkillGroupVO callCenterSkillGroupVO) {
    CallCenterSkillGroupBO callCenterSkillGroupBO = new CallCenterSkillGroupBO();
    BeanUtils.copyProperties(callCenterSkillGroupVO, callCenterSkillGroupBO);
    return ResultExt.successWithData(callCenterSkillGroupService.updateCallCenterSkillGroup(callCenterSkillGroupBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteCallCenterSkillGroup(@PathVariable Long id) {
    return ResultExt.successWithData(callCenterSkillGroupService.deleteCallCenterSkillGroup(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<CallCenterSkillGroupVO> getCallCenterSkillGroup(@PathVariable Long id) {
    CallCenterSkillGroupBO callCenterSkillGroupBO = callCenterSkillGroupService.getCallCenterSkillGroup(id);
    CallCenterSkillGroupVO callCenterSkillGroupVO = new CallCenterSkillGroupVO();
    BeanUtils.copyProperties(callCenterSkillGroupBO, callCenterSkillGroupVO);
    return ResultExt.successWithData(callCenterSkillGroupVO);
  }

  @GetMapping()
  public InvokerPageResult<List<CallCenterSkillGroupVO>> listCallCenterSkillGroup(@Validated(value = {CallCenterSkillGroupVO.GroupQuery.class}) CallCenterSkillGroupVO callCenterSkillGroupVO) {
    CallCenterSkillGroupBO callCenterSkillGroupBO = new CallCenterSkillGroupBO();
    BeanUtils.copyProperties(callCenterSkillGroupVO, callCenterSkillGroupBO);
    IPage<CallCenterSkillGroupBO> page = callCenterSkillGroupService.listCallCenterSkillGroup(callCenterSkillGroupBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<CallCenterSkillGroupVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

  @GetMapping("all")
  public InvokerResult<List<CallCenterSkillGroupVO>> queryAll() {
    List<CallCenterSkillGroupBO> callCenterSkillGroupBOList = callCenterSkillGroupService.queryAll();
    return ResultExt.successWithData(JSON.parseObject(JSON.toJSONString(callCenterSkillGroupBOList), new TypeReference<List<CallCenterSkillGroupVO>>() {
    }));
  }

}

