package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.IvrBO;
import com.aegis.fs.model.vo.IvrVO;
import com.aegis.fs.service.IvrService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * IVR 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@RestController
@RequestMapping("api/v1/ivr")
public class IvrController extends BaseController {

  private final IvrService ivrService;

  public IvrController(IvrService ivrService) {
    this.ivrService = ivrService;
  }

  @PostMapping()
  public InvokerResult<Long> insertIvr(@Validated(value = {IvrVO.GroupInsert.class})
                                          @RequestBody IvrVO ivrVO) {
    IvrBO ivrBO = new IvrBO();
    BeanUtils.copyProperties(ivrVO, ivrBO);
    return ResultExt.successWithData(ivrService.insertIvr(ivrBO));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateIvr(@Validated(value = {IvrVO.GroupUpdate.class})
                                          @RequestBody IvrVO ivrVO) {
    IvrBO ivrBO = new IvrBO();
    BeanUtils.copyProperties(ivrVO, ivrBO);
    return ResultExt.successWithData(ivrService.updateIvr(ivrBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteIvr(@PathVariable Long id) {
    return ResultExt.successWithData(ivrService.deleteIvr(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<IvrVO> getIvr(@PathVariable Long id) {
    IvrBO ivrBO = ivrService.getIvr(id);
    IvrVO ivrVO = new IvrVO();
    BeanUtils.copyProperties(ivrBO, ivrVO);
    return ResultExt.successWithData(ivrVO);
  }

  @GetMapping()
  public InvokerPageResult<List<IvrVO>> listFs(@Validated(value = {IvrVO.GroupQuery.class}) IvrVO ivrVO) {
    IvrBO ivrBO = new IvrBO();
    BeanUtils.copyProperties(ivrVO, ivrBO);
    IPage<IvrBO> page = ivrService.listIvr(ivrBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<IvrVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

