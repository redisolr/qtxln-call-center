package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.CallBillStatisticsBO;
import com.aegis.fs.model.bo.CallDistributionBO;
import com.aegis.fs.model.vo.CallBillStatisticsVO;
import com.aegis.fs.model.vo.CallDistributionVO;
import com.aegis.fs.service.CallBillStatisticsService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 话单统计 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
@RestController
@RequestMapping("/api/v1/call_bill_statistics")
public class CallBillStatisticsController extends BaseController {

  private final CallBillStatisticsService callBillStatisticsService;

  public CallBillStatisticsController(CallBillStatisticsService callBillStatisticsService) {
    this.callBillStatisticsService = callBillStatisticsService;
  }

  @GetMapping
  public InvokerResult<CallBillStatisticsVO> callBillStatisticsOneDay() {
    CallBillStatisticsVO callBillStatisticsVO = new CallBillStatisticsVO();
    CallBillStatisticsBO callBillStatisticsBO = callBillStatisticsService.callBillStatisticsOneDay();
    BeanUtils.copyProperties(callBillStatisticsBO, callBillStatisticsVO);
    return ResultExt.successWithData(callBillStatisticsVO);
  }

  @GetMapping("distribution")
  public InvokerResult<CallDistributionVO> callDistributionByDay() {
    CallDistributionVO callDistributionVO = new CallDistributionVO();
    CallDistributionBO callDistributionBO = callBillStatisticsService.callDistributionByDay(null, null);
    BeanUtils.copyProperties(callDistributionBO, callDistributionVO);
    return ResultExt.successWithData(callDistributionVO);
  }

}

