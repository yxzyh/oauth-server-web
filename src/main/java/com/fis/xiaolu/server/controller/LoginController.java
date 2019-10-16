package com.fis.xiaolu.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用一句话描述这个类的作用
 * @author XiaoLu.Su 
 * @Date Oct 15, 2019
 */
@Controller
public class LoginController {
  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }
}