package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;

@Controller
@RequestMapping("sys/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		logger.info("index");
		
		
		return "sys/role/list";
	}
	
	@RequestMapping(value = "/view")
	public String view(HttpServletRequest request, HttpServletResponse response){
		logger.info("view");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Role role = roleService.getRoleById(id);
		
		request.setAttribute("role", role);
		
		return "sys/role/view";
	}
	
}
