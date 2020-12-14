package com.qtxln.controller;


import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.bo.FsExtendBO;
import com.qtxln.model.vo.FsExtendVO;
import com.qtxln.service.FsExtendService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * FS服务器扩展信息 前端控制器
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@RestController
@RequestMapping("api/v1/fs_extend")
public class FsExtendController extends BaseController {

  private final FsExtendService fsExtendService;

  @Autowired
  public FsExtendController(FsExtendService fsExtendService) {
    this.fsExtendService = fsExtendService;
  }

  @GetMapping("/{fsBasicId}")
  public InvokerResult<FsExtendVO> getExtendFs(@PathVariable Long fsBasicId) {
    FsExtendBO fsExtendBO = fsExtendService.getExtendFs(fsBasicId);
    FsExtendVO fsExtendVO = new FsExtendVO();
    BeanUtils.copyProperties(fsExtendBO, fsExtendVO);
    return ResultExt.successWithData(fsExtendVO);
  }

  @PutMapping()
  public InvokerResult<Object> updateExtendFs(@Validated(value = {FsExtendVO.GroupUpdate.class})
                                              @RequestBody FsExtendVO fsExtendVO) {
    FsExtendBO fsExtendBO = new FsExtendBO();
    BeanUtils.copyProperties(fsExtendVO, fsExtendBO);
    return ResultExt.successWithData(fsExtendService.updateFsExtend(fsExtendBO));
  }

}

