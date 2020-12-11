package com.qtxln.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PageController 页面前端控制器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/13 11:15 下午
 * @since 1.0
 */
@CrossOrigin
@Controller
@Slf4j
public class PageController {

  @GetMapping("/index")
  public String index() {
    return "index";
  }

  @GetMapping("/love")
  public String love() {
    return "love";
  }
}

