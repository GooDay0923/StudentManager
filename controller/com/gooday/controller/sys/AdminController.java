package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, HttpServletResponse response){
		logger.info("index");
		
		return "index";
	}
	
	
	
}
