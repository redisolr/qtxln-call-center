package com.qtxln.controller;

import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultExt;
import com.aegis.fs.model.bo.FileBO;
import com.aegis.fs.model.vo.FileVO;
import com.aegis.fs.service.CommonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共前端控制器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/5 17:08 下午
 * @since 1.0
 */
@RestController
@RequestMapping("api/v1/common")
public class CommonController extends BaseController {
  private final CommonService commonService;

  @Autowired
  public CommonController(CommonService commonService) {
    this.commonService = commonService;
  }

  @PostMapping("upload")
  public InvokerResult<FileVO> uploadFile(@Validated(value = {FileVO.GroupInsert.class})
                                          @ModelAttribute FileVO fileVO) {
    FileBO fileBO = commonService.uploadFile(fileVO.getFile());
    FileVO responseFileVO = new FileVO();
    BeanUtils.copyProperties(fileBO, responseFileVO);
    return ResultExt.successWithData(responseFileVO);
  }


}

