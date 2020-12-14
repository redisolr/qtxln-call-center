package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.CallCenterExtensionBO;
import com.qtxln.model.vo.CallCenterExtensionVO;
import com.qtxln.service.CallCenterExtensionService;
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
 * 分机表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-31
 */
@RestController
@RequestMapping("api/v1/call_center_extension")
public class CallCenterExtensionController extends BaseController {

  private final CallCenterExtensionService callCenterExtensionService;

  @Autowired
  public CallCenterExtensionController(CallCenterExtensionService callCenterExtensionService) {
    this.callCenterExtensionService = callCenterExtensionService;
  }

  @PostMapping
  public InvokerResult<Boolean> insertCallCenterExtension(@Validated(value = {CallCenterExtensionVO.GroupInsert.class})
                                                          @RequestBody CallCenterExtensionVO callCenterExtensionVO) {
    CallCenterExtensionBO callCenterExtensionBO = new CallCenterExtensionBO();
    BeanUtils.copyProperties(callCenterExtensionVO, callCenterExtensionBO);
    return ResultExt.successWithData(callCenterExtensionService.insertCallCenterExtension(callCenterExtensionBO));
  }

  @PutMapping
  public InvokerResult<Boolean> updateCallCenterExtension(@Validated(value = {CallCenterExtensionVO.GroupUpdate.class})
                                                          @RequestBody CallCenterExtensionVO callCenterExtensionVO) {
    CallCenterExtensionBO callCenterExtensionBO = new CallCenterExtensionBO();
    BeanUtils.copyProperties(callCenterExtensionVO, callCenterExtensionBO);
    return ResultExt.successWithData(callCenterExtensionService.updateCallCenterExtension(callCenterExtensionBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteCallCenterExtension(@PathVariable Long id) {
    return ResultExt.successWithData(callCenterExtensionService.deleteCallCenterExtension(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<CallCenterExtensionVO> getCallCenterExtension(@PathVariable Long id) {
    CallCenterExtensionBO callCenterExtensionBO = callCenterExtensionService.getCallCenterExtension(id);
    CallCenterExtensionVO callCenterExtensionVO = new CallCenterExtensionVO();
    BeanUtils.copyProperties(callCenterExtensionBO, callCenterExtensionVO);
    return ResultExt.successWithData(callCenterExtensionVO);
  }

  @GetMapping()
  public InvokerPageResult<List<CallCenterExtensionVO>> listCallCenterExtension(@Validated(value = {CallCenterExtensionVO.GroupQuery.class}) CallCenterExtensionVO callCenterExtensionVO) {
    CallCenterExtensionBO callCenterExtensionBO = new CallCenterExtensionBO();
    BeanUtils.copyProperties(callCenterExtensionVO, callCenterExtensionBO);
    IPage<CallCenterExtensionBO> page = callCenterExtensionService.listCallCenterExtension(callCenterExtensionBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<CallCenterExtensionVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

  @GetMapping("all")
  public InvokerResult<List<CallCenterExtensionVO>> queryAll() {
    List<CallCenterExtensionBO> callCenterExtensionBOList = callCenterExtensionService.queryAll();
    return ResultExt.successWithData(JSON.parseObject(JSON.toJSONString(callCenterExtensionBOList), new TypeReference<List<CallCenterExtensionVO>>() {
    }));
  }

}

