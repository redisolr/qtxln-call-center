package com.qtxln.controller;


import com.aegis.fs.component.result.InvokerPageResult;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.Pager;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.FsBasicBO;
import com.aegis.fs.model.vo.FsBasicVO;
import com.aegis.fs.service.FsBasicService;
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
 * FS基本信息 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@RestController
@RequestMapping("api/v1/fs_basic")
public class FsBasicController extends BaseController {

  private final FsBasicService fsBasicService;

  @Autowired
  public FsBasicController(FsBasicService fsBasicService) {
    this.fsBasicService = fsBasicService;
  }

  @DeleteMapping("/{id}")
  public InvokerResult<Boolean> deleteFs(@PathVariable Long id) {
    return ResultExt.successWithData(fsBasicService.deleteFs(id));
  }

  @GetMapping("/{id}")
  public InvokerResult<FsBasicVO> getFs(@PathVariable Long id) {
    FsBasicBO fsBasicBO = fsBasicService.getFs(id);
    FsBasicVO fsBasicVO = new FsBasicVO();
    BeanUtils.copyProperties(fsBasicBO, fsBasicVO);
    return ResultExt.successWithData(fsBasicVO);
  }

  @PostMapping()
  public InvokerResult<Boolean> insertFs(@Validated(value = {FsBasicVO.GroupInsert.class})
                                         @RequestBody FsBasicVO fsBasicVO) {
    FsBasicBO fsBasicBO = new FsBasicBO();
    BeanUtils.copyProperties(fsBasicVO, fsBasicBO);
    return ResultExt.successWithData(fsBasicService.insertFs(fsBasicBO));
  }

  @GetMapping()
  public InvokerPageResult<List<FsBasicVO>> listFs(@Validated(value = {FsBasicVO.GroupQuery.class}) FsBasicVO fsBasicVO) {
    FsBasicBO fsBasicBO = new FsBasicBO();
    BeanUtils.copyProperties(fsBasicVO, fsBasicBO);
    IPage<FsBasicBO> page = fsBasicService.listFs(fsBasicBO);
    return ResultExt.successWithPageData(JSON.parseObject(JSON.toJSONString(page.getRecords()), new TypeReference<List<FsBasicVO>>() {
    }), Pager.setPager(page.getCurrent(), page.getSize(), page.getTotal()));
  }

  @PutMapping()
  public InvokerResult<Boolean> updateFs(@Validated(value = {FsBasicVO.GroupUpdate.class})
                                        @RequestBody FsBasicVO fsBasicVO) {
    FsBasicBO fsBasicBO = new FsBasicBO();
    BeanUtils.copyProperties(fsBasicVO, fsBasicBO);
    return ResultExt.successWithData(fsBasicService.updateFs(fsBasicBO));
  }

  @PostMapping("/connection/{id}")
  public InvokerResult<Boolean> connectionServer(@PathVariable Long id) {
    return ResultExt.successWithData(fsBasicService.connectionServer(id));
  }

  @PostMapping("/disConnection/{id}")
  public InvokerResult<Boolean> disConnectionServer(@PathVariable Long id) {
    return ResultExt.successWithData(fsBasicService.disConnectionServer(id));
  }

}

