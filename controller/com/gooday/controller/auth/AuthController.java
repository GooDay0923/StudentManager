package com.gooday.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gooday.common.basic.JsonResult;
import com.gooday.service.auth.IAdminService;


@Controller
@RequestMapping("/auth")
public class AuthController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private IAdminService authService;
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, HttpServletResponse response){
		logger.info("auth");
		
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		logger.info("login");
		
		return "login";
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody 
	public JsonResult test(HttpServletRequest request, HttpServletResponse response){
		logger.info("test");
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setErrormsg("test");
		jsonResult.setErrorcode("123");
		jsonResult.setData(null);
		
		return jsonResult;
	}
	
}
