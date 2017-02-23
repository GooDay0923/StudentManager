package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, HttpServletResponse response){
		logger.info("index");
		
		return "index";
	}
	
}
