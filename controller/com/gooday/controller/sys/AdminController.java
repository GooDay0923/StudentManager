package com.gooday.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;
import com.gooday.common.basic.JsonResult;
import com.gooday.model.admin.Admin;
import com.gooday.service.sys.IAdminService;

@Controller
@RequestMapping("sys/admin")
public class AdminController extends BaseController {

	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		logger.info("index");
		
		List<Admin> adminList = adminService.listAdmin();
		
		request.setAttribute("adminList", adminList);
		
		return "admin/list";
	}
	
	@RequestMapping(value = "/view")
	public String view(HttpServletRequest request, HttpServletResponse response){
		logger.info("view");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Admin admin = adminService.getAdminById(id);
		
		request.setAttribute("Admin", admin);
		
		return "admin/view";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response){
		logger.info("edit");
		
		
		
		return "admin/edit";
	}
	
	@RequestMapping(value = "/save")
	public JsonResult save(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("edit");
		
		Admin admin = new Admin();
		
		Integer result = adminService.saveAdmin(admin);
		
		JsonResult jsonResult = new JsonResult();
		
		return jsonResult;
	}
	
	@RequestMapping(value = "/delete")
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response){
		logger.info("delete");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		JsonResult jsonResult = new JsonResult();
		
		adminService.deleteAdmin(id);
		
		return jsonResult;
	}
	
}
