package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.IvrEntryBO;
import com.qtxln.model.vo.IvrEntryVO;
import com.qtxln.service.IvrEntryService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@RestController
@RequestMapping("api/v1/ivr_entry")
public class IvrEntryController extends BaseController {

  private final IvrEntryService ivrEntryService;

  public IvrEntryController(IvrEntryService ivrEntryService) {
    this.ivrEntryService = ivrEntryService;
  }

  @PostMapping()
  public InvokerResult<Long> insertIvrEntry(@Validated(value = {IvrEntryVO.GroupInsert.class})
                                               @RequestBody IvrEntryVO ivrEntryVO) {
    IvrEntryBO ivrEntryBO = new IvrEntryBO();
    BeanUtils.copyProperties(ivrEntryVO, ivrEntryBO);
    return ResultExt.successWithData(ivrEntryService.insertIvrEntry(ivrEntryBO));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateIvrEntry(@Validated(value = {IvrEntryVO.GroupInsert.class})
                                               @RequestBody IvrEntryVO ivrEntryVO) {
    IvrEntryBO ivrEntryBO = new IvrEntryBO();
    BeanUtils.copyProperties(ivrEntryVO, ivrEntryBO);
    return ResultExt.successWithData(ivrEntryService.updateIvrEntry(ivrEntryBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteIvrEntry(@PathVariable Long id) {
    return ResultExt.successWithData(ivrEntryService.deleteIvrEntry(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<IvrEntryVO> getIvrEntry(@PathVariable Long id) {
    IvrEntryBO ivrEntryBO = ivrEntryService.getIvrEntry(id);
    IvrEntryVO ivrEntryVO = new IvrEntryVO();
    BeanUtils.copyProperties(ivrEntryBO, ivrEntryVO);
    return ResultExt.successWithData(ivrEntryVO);
  }

  @GetMapping()
  public InvokerPageResult<List<IvrEntryVO>> listFs(@Validated(value = {IvrEntryVO.GroupQuery.class}) IvrEntryVO ivrEntryVO) {
    IvrEntryBO ivrEntryBO = new IvrEntryBO();
    BeanUtils.copyProperties(ivrEntryVO, ivrEntryBO);
    IPage<IvrEntryBO> page = ivrEntryService.listIvrEntry(ivrEntryBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<IvrEntryVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

