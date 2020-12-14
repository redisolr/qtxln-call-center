package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.DialplanTemplateBO;
import com.qtxln.model.vo.DialplanTemplateVO;
import com.qtxln.service.DialplanTemplateService;
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
 * 拨号计划-模板表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-07
 */
@RestController
@RequestMapping("api/v1/dialplan_template")
public class DialplanTemplateController extends BaseController {

  private final DialplanTemplateService dialplanTemplateService;

  @Autowired
  public DialplanTemplateController(DialplanTemplateService dialplanTemplateService) {
    this.dialplanTemplateService = dialplanTemplateService;
  }


  @PostMapping
  public InvokerResult<Boolean> insertDialplanTemplate(@Validated(value = {DialplanTemplateVO.GroupInsert.class})
                                                       @RequestBody DialplanTemplateVO dialplanTemplateVO) {
    DialplanTemplateBO dialplanTemplateBO = new DialplanTemplateBO();
    BeanUtils.copyProperties(dialplanTemplateVO, dialplanTemplateBO);
    return ResultExt.successWithData(dialplanTemplateService.insertDailplanTemplate(dialplanTemplateBO));
  }

  @PutMapping
  public InvokerResult<Boolean> updateDialplanTemplate(@Validated(value = {DialplanTemplateVO.GroupUpdate.class})
                                                       @RequestBody DialplanTemplateVO dialplanTemplateVO) {
    DialplanTemplateBO dialplanTemplateBO = new DialplanTemplateBO();
    BeanUtils.copyProperties(dialplanTemplateVO, dialplanTemplateBO);
    return ResultExt.successWithData(dialplanTemplateService.updateDailplanTemplate(dialplanTemplateBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteDialplanTemplate(@PathVariable Long id) {
    return ResultExt.successWithData(dialplanTemplateService.deleteDailplanTemplate(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<DialplanTemplateVO> getDialplanTemplate(@PathVariable Long id) {
    DialplanTemplateBO dialplanTemplateBO = dialplanTemplateService.getDailplanTemplate(id);
    DialplanTemplateVO dialplanTemplateVO = new DialplanTemplateVO();
    BeanUtils.copyProperties(dialplanTemplateBO, dialplanTemplateVO);
    return ResultExt.successWithData(dialplanTemplateVO);
  }

  @GetMapping()
  public InvokerPageResult<List<DialplanTemplateVO>> listDialplanTemplate(@Validated(value = {DialplanTemplateVO.GroupQuery.class}) DialplanTemplateVO dialplanTemplateVO) {
    DialplanTemplateBO dialplanTemplateBO = new DialplanTemplateBO();
    BeanUtils.copyProperties(dialplanTemplateVO, dialplanTemplateBO);
    IPage<DialplanTemplateBO> page = dialplanTemplateService.listDailplanTemplate(dialplanTemplateBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<DialplanTemplateVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

