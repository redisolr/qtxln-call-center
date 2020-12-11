package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.SysDictionaryBO;
import com.aegis.fs.model.vo.SysDictionaryVO;
import com.aegis.fs.service.SysDictionaryService;
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
 * 字典表 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-14
 */
@RestController
@RequestMapping("api/v1/sys_dictionary")
public class SysDictionaryController extends BaseController{

  private final SysDictionaryService sysDictionaryService;

  @Autowired
  public SysDictionaryController(SysDictionaryService sysDictionaryService) {
    this.sysDictionaryService = sysDictionaryService;
  }

  @PostMapping()
  public InvokerResult<Boolean> insertSysDictionary(@Validated(value = {SysDictionaryVO.GroupInsert.class})
                                         @RequestBody SysDictionaryVO sysDictionaryVO) {
    SysDictionaryBO sysDictionaryBO = new SysDictionaryBO();
    BeanUtils.copyProperties(sysDictionaryVO, sysDictionaryBO);
    return ResultExt.successWithData(sysDictionaryService.insertSysDictionary(sysDictionaryBO));
  }

  @PutMapping()
  public InvokerResult<Object> updateSysDictionary(@Validated(value = {SysDictionaryVO.GroupUpdate.class})
                                        @RequestBody SysDictionaryVO sysDictionaryVO) {
    SysDictionaryBO sysDictionaryBO = new SysDictionaryBO();
    BeanUtils.copyProperties(sysDictionaryVO, sysDictionaryBO);
    return ResultExt.successWithData(sysDictionaryService.updateSysDictionary(sysDictionaryBO));
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteSysDictionary(@PathVariable Long id) {
    return ResultExt.successWithData(sysDictionaryService.deleteSysDictionary(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<SysDictionaryVO> getSysDictionary(@PathVariable Long id) {
    SysDictionaryBO sysDictionaryBO = sysDictionaryService.getSysDictionary(id);
    SysDictionaryVO sysDictionaryVO = new SysDictionaryVO();
    BeanUtils.copyProperties(sysDictionaryBO, sysDictionaryVO);
    return ResultExt.successWithData(sysDictionaryVO);
  }

  @GetMapping()
  public InvokerPageResult<List<SysDictionaryVO>> listSysDictionary(@Validated(value = {SysDictionaryVO.GroupQuery.class}) SysDictionaryVO sysDictionaryVO) {
    SysDictionaryBO sysDictionaryBO = new SysDictionaryBO();
    BeanUtils.copyProperties(sysDictionaryVO, sysDictionaryBO);
    IPage<SysDictionaryBO> page = sysDictionaryService.listSysDictionary(sysDictionaryBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<SysDictionaryVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

  @GetMapping("/code")
  public InvokerResult<List<SysDictionaryVO>> listSysDictionaryByCode(@RequestParam String code) {
    List<SysDictionaryBO> dictionaryBOList = sysDictionaryService.listSysDictionaryByCode(code);
    return ResultExt.successWithData(JSON.parseObject(JSON.toJSONString(dictionaryBOList), new TypeReference<List<SysDictionaryVO>>() {}));
  }

}

