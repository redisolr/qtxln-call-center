package com.qtxln.controller;


import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.ResultExt;
import com.qtxln.model.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 用户controller
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/8 17:24 下午
 * @since 1.0
 */
@RestController
@RequestMapping("/vue-element-admin/user")
@CrossOrigin
public class UserController {

  @PostMapping("/login")
  public InvokerResult<UserVO> login(@RequestBody UserVO userVO) {
    userVO.setToken("admin-token");
    return ResultExt.successWithData(userVO);
  }

  @GetMapping("/info/{token}")
  public InvokerResult<UserVO> login(@PathVariable String token) {
    UserVO userVO = new UserVO();
    ArrayList<String> roles = new ArrayList<>();
    roles.add("admin");
    userVO.setRoles(roles);
    userVO.setIntroduction("I am a super administrator");
    userVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    userVO.setName("Super Admin");
    return ResultExt.successWithData(userVO);
  }

}

