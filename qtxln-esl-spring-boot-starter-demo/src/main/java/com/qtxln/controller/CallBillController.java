package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.CallBillBO;
import com.qtxln.model.bo.CallBillInfoBO;
import com.qtxln.model.vo.CallBillInfoVO;
import com.qtxln.model.vo.CallBillVO;
import com.qtxln.service.CallBillService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 通话清单(话单) 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-21
 */
@RestController
@RequestMapping("/api/v1/call_bill")
public class CallBillController extends BaseController {

  private final CallBillService callBillService;

  @Autowired
  public CallBillController(CallBillService callBillService) {
    this.callBillService = callBillService;
  }

  @GetMapping()
  public InvokerPageResult<List<CallBillVO>> listCallCenterExtension(@Validated(value = {CallBillVO.GroupQuery.class}) CallBillVO callBillVO) {
    CallBillBO callBillBO = new CallBillBO();
    BeanUtils.copyProperties(callBillVO, callBillBO);
    IPage<CallBillBO> page = callBillService.listCallBill(callBillBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<CallBillVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

  @GetMapping("/{id}")
  public InvokerResult<List<CallBillInfoVO>> getCallBill(@PathVariable Long id) {
    List<CallBillInfoBO> billInfoBOList = callBillService.getCallBill(id);
    return ResultExt.successWithData(JSON.parseObject(JSON.toJSONString(billInfoBOList), new TypeReference<List<CallBillInfoVO>>() {
    }));
  }


}

