package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.DialplanApplicationBO;
import com.aegis.fs.model.vo.DialplanApplicationVO;
import com.aegis.fs.service.DialplanApplicationService;
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
 * 拨号计划-app表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-06
 */
@RestController
@RequestMapping("api/v1/dialplan_application")
public class DialplanApplicationController extends BaseController{

  private final DialplanApplicationService dialplanApplicationService;

  @Autowired
  public DialplanApplicationController(DialplanApplicationService dialplanApplicationService) {
    this.dialplanApplicationService = dialplanApplicationService;
  }

  @PostMapping
  public InvokerResult<Boolean> insertDialplanApp(@Validated(value = {DialplanApplicationVO.GroupInsert.class})
                                                          @RequestBody DialplanApplicationVO dialplanApplicationVO) {
    DialplanApplicationBO dialplanApplicationBO = new DialplanApplicationBO();
    BeanUtils.copyProperties(dialplanApplicationVO, dialplanApplicationBO);
    return ResultExt.successWithData(dialplanApplicationService.insertDialplanApp(dialplanApplicationBO));
  }

  @PutMapping
  public InvokerResult<Boolean> updateDialplanApp(@Validated(value = {DialplanApplicationVO.GroupUpdate.class})
                                                          @RequestBody DialplanApplicationVO dialplanApplicationVO) {
    DialplanApplicationBO dialplanApplicationBO = new DialplanApplicationBO();
    BeanUtils.copyProperties(dialplanApplicationVO, dialplanApplicationBO);
    return ResultExt.successWithData(dialplanApplicationService.updateDialplanApp(dialplanApplicationBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteDialplanApp(@PathVariable Long id) {
    return ResultExt.successWithData(dialplanApplicationService.deleteDialplanApp(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<DialplanApplicationVO> getDialplanApp(@PathVariable Long id) {
    DialplanApplicationBO dialplanApplicationBO = dialplanApplicationService.getDialplanApp(id);
    DialplanApplicationVO dialplanApplicationVO = new DialplanApplicationVO();
    BeanUtils.copyProperties(dialplanApplicationBO, dialplanApplicationVO);
    return ResultExt.successWithData(dialplanApplicationVO);
  }

  @GetMapping()
  public InvokerPageResult<List<DialplanApplicationVO>> listDialplanApp(@Validated(value = {DialplanApplicationVO.GroupQuery.class}) DialplanApplicationVO dialplanApplicationVO) {
    DialplanApplicationBO dialplanApplicationBO = new DialplanApplicationBO();
    BeanUtils.copyProperties(dialplanApplicationVO, dialplanApplicationBO);
    IPage<DialplanApplicationBO> page = dialplanApplicationService.listDialplanApp(dialplanApplicationBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<DialplanApplicationVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

