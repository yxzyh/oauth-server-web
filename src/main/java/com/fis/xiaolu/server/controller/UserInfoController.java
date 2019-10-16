package com.fis.xiaolu.server.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用一句话描述这个类的作用
 * @author XiaoLu.Su 
 * @Date Oct 16, 2019
 */
@Controller
public class UserInfoController {
	  private Logger logger = LoggerFactory.getLogger(this.getClass());
//	  @RequestMapping("/user")
	  @GetMapping("/user")
	  public ResponseEntity<Object> getUser(Principal principal) {
	    logger.info("principal:" + principal);
	    return new ResponseEntity<Object>(principal, HttpStatus.OK);
	  }
}
