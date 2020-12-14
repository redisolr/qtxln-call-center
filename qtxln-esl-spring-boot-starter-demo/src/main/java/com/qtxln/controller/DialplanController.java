package com.qtxln.controller;


import com.qtxln.component.result.InvokerPageResult;
import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.Pager;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.DialplanBO;
import com.qtxln.model.vo.DialplanVO;
import com.qtxln.service.DialplanService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 拨号计划表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-08
 */
@RestController
@RequestMapping("/api/v1/dialplan")
public class DialplanController extends BaseController {

  private final DialplanService dialplanService;

  public DialplanController(DialplanService dialplanService) {
    this.dialplanService = dialplanService;
  }

  @PostMapping
  public InvokerResult<Boolean> insertDialplan(@RequestBody DialplanVO dialplanVO) {
    DialplanBO dialplanBO = new DialplanBO();
    BeanUtils.copyProperties(dialplanVO, dialplanBO);
    return ResultExt.successWithData(dialplanService.insertDialplan(dialplanBO));
  }

  @PutMapping
  public InvokerResult<Boolean> updateDialplan(@RequestBody DialplanVO dialplanVO) {
    DialplanBO dialplanBO = new DialplanBO();
    BeanUtils.copyProperties(dialplanVO, dialplanBO);
    return ResultExt.successWithData(dialplanService.updateDialplan(dialplanBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteDialplan(@PathVariable Long id) {
    return ResultExt.successWithData(dialplanService.deleteDialplan(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<DialplanVO> getDialplan(@PathVariable Long id) {
    DialplanBO dialplanBO = dialplanService.getDialplan(id);
    DialplanVO dialplanVO = new DialplanVO();
    BeanUtils.copyProperties(dialplanBO, dialplanVO);
    return ResultExt.successWithData(dialplanVO);
  }

  @GetMapping()
  public InvokerPageResult<List<DialplanVO>> listDialplan(@Validated(value = {DialplanVO.GroupQuery.class}) DialplanVO dialplanVO) {
    DialplanBO dialplanBO = new DialplanBO();
    BeanUtils.copyProperties(dialplanVO, dialplanBO);
    IPage<DialplanBO> page = dialplanService.listDialplan(dialplanBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<DialplanVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

}

