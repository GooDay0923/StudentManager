package com.gooday.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gooday.common.basic.BaseController;
import com.gooday.common.basic.JsonResult;
import com.gooday.common.util.DateUtil;
import com.gooday.model.admin.Admin;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IAdminService;
import com.gooday.service.sys.IRoleService;

@Controller
@RequestMapping("sys/admin")
public class AdminController extends BaseController {

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response,
					   @RequestParam(required = false, defaultValue = "1") int page,
					   @RequestParam(required = false, defaultValue = "10") int rows){
		logger.info("index");

		String username = request.getParameter("username");

		List<Admin> adminList = adminService.listAdminByUserName(username, page, rows);

		request.setAttribute("pageInfo", new PageInfo<Admin>(adminList));
		request.setAttribute("username", username);
		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		
		return "sys/admin/list";
	}
	
	@RequestMapping(value = "/view")
	public String view(HttpServletRequest request, HttpServletResponse response){
		logger.info("view");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Admin admin = adminService.getAdminById(id);
		
		request.setAttribute("admin", admin);
		
		return "sys/admin/view";
	}
	
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response){
		logger.info("edit");
		
		
		return "sys/admin/edit";
	}
	
	@RequestMapping(value = "/addVM")
	public String addVM(HttpServletRequest request, HttpServletResponse response){
		logger.info("addVM");
		
		List<Role> roleList = roleService.listAllRole();
		
		request.setAttribute("roleList", roleList);
		
		return "sys/admin/add";
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public JsonResult add(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("add");
		
		JsonResult jsonResult = new JsonResult();
		
		try{
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Long roleId = Long.valueOf(request.getParameter("roleId"));
			
			Integer currentTime = DateUtil.getCurrentUnixTime();
			
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			admin.setEnable(true);
			admin.setRoleId(roleId);
			admin.setGmtCreate(currentTime);
			admin.setGmtModified(currentTime);
		
			Integer result = adminService.saveAdmin(admin);
			if(result.equals(1)){
				jsonResult.setCode(JsonResult.OP_SUCCESS);
			}

		} catch(Exception e) {
			jsonResult.setCode(JsonResult.OP_ERROR);
			jsonResult.setMessage(e.getMessage());
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value = "/remove")
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response){
		logger.info("remove");
		
		JsonResult jsonResult = new JsonResult();
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Admin admin = new Admin();
		admin.setId(id);
		admin.setEnable(false);
		
		Integer result = adminService.updateAdmin(admin);
		
		return jsonResult;
	}
	
}
