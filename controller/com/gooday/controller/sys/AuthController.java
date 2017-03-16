package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gooday.common.basic.BaseController;
import com.gooday.common.basic.JsonResult;
import com.gooday.service.sys.IAdminService;


@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		logger.info("login");
		
		String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误";
        } else if(AuthenticationException.class.getName().equals(exceptionClassName)){     
        	error = "用户名或密码错误";
        } else if(LockedAccountException.class.getName().equals(exceptionClassName)) {
            error = "该账户不可用";
        } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "该账户已被锁定, 10分钟后再次尝试";
        } else if(exceptionClassName != null) {
            error = "登录错误：" + exceptionClassName;
        }
        request.setAttribute("error", error);
		
		return "login";
	}
	
}
