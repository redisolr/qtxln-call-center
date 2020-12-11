package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.CallCenterMediaBO;
import com.aegis.fs.model.vo.CallCenterMediaVO;
import com.aegis.fs.service.CallCenterMediaService;
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
 * 呼叫中心-媒体资源表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-30
 */
@RestController
@RequestMapping("api/v1/call_center_media")
public class CallCenterMediaController extends BaseController{

  private final CallCenterMediaService callCenterMediaService;

  @Autowired
  public CallCenterMediaController(CallCenterMediaService callCenterMediaService) {
    this.callCenterMediaService = callCenterMediaService;
  }

  @PostMapping()
  public InvokerResult<Boolean> insertCallCenterMedia(@Validated(value = {CallCenterMediaVO.GroupInsert.class})
                                                      @RequestBody CallCenterMediaVO callCenterMediaVO) {
    CallCenterMediaBO callCenterMediaBO = new CallCenterMediaBO();
    BeanUtils.copyProperties(callCenterMediaVO, callCenterMediaBO);
    return ResultExt.successWithData(callCenterMediaService.insertCallCenterMedia(callCenterMediaBO));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateCallCenterMedia(@Validated(value = {CallCenterMediaVO.GroupUpdate.class})
                                        @RequestBody CallCenterMediaVO callCenterMediaVO) {
    CallCenterMediaBO callCenterMediaBO = new CallCenterMediaBO();
    BeanUtils.copyProperties(callCenterMediaVO, callCenterMediaBO);
    return ResultExt.successWithData(callCenterMediaService.updateCallCenterMedia(callCenterMediaBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteCallCenterMedia(@PathVariable Long id) {
    return ResultExt.successWithData(callCenterMediaService.deleteCallCenterMedia(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<CallCenterMediaVO> getCallCenterMedia(@PathVariable Long id) {
    CallCenterMediaBO callCenterMediaBO = callCenterMediaService.getCallCenterMedia(id);
    CallCenterMediaVO callCenterMediaVO = new CallCenterMediaVO();
    BeanUtils.copyProperties(callCenterMediaBO, callCenterMediaVO);
    return ResultExt.successWithData(callCenterMediaVO);
  }

  @GetMapping()
  public InvokerPageResult<List<CallCenterMediaVO>> listCallCenterMedia(@Validated(value = {CallCenterMediaVO.GroupQuery.class}) CallCenterMediaVO callCenterMediaVO) {
    CallCenterMediaBO callCenterMediaBO = new CallCenterMediaBO();
    BeanUtils.copyProperties(callCenterMediaVO, callCenterMediaBO);
    IPage<CallCenterMediaBO> page = callCenterMediaService.listCallCenterMedia(callCenterMediaBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<CallCenterMediaVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

