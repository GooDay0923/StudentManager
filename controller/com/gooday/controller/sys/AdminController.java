package com.gooday.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	@RequiresPermissions("sys:admin:list")
	public String list(HttpServletRequest request, HttpServletResponse response,
					   @RequestParam(required = false, defaultValue = "1") String page,
					   @RequestParam(required = false, defaultValue = "10") String rows){
		logger.info("list");

		int sqlPage = 1;
		int sqlRows = 10;

		String username = request.getParameter("username");

		if(StringUtils.isNumeric(page)){
			sqlPage =  Integer.parseInt(page);
		}

		if(StringUtils.isNumeric(page)){
			sqlRows =  Integer.parseInt(rows);
		}

		List<Admin> adminList = adminService.listAdminByUserName(username, sqlPage, sqlRows);

		request.setAttribute("pageInfo", new PageInfo<Admin>(adminList));
		request.setAttribute("username", username);
		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		
		return "sys/admin/list";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	//	@RequiresPermissions("sys:admin:view")
	public String view(HttpServletRequest request, HttpServletResponse response){
		logger.info("view");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Admin admin = adminService.getAdminById(id);
		
		request.setAttribute("admin", admin);
		
		return "sys/admin/view";
	}
	
	@RequestMapping(value = "/editVM", method = RequestMethod.GET)
	public String editVM(HttpServletRequest request, HttpServletResponse response){
		logger.info("edit");

		Long id = Long.valueOf(request.getParameter("id"));

		Admin admin = adminService.getAdminById(id);

		List<Role> roleList = roleService.listAllRole();

		request.setAttribute("roleList", roleList);
		request.setAttribute("admin", admin);

		return "sys/admin/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(HttpServletRequest request, HttpServletResponse response){
		logger.info("edit");

		JsonResult jsonResult = new JsonResult();

		Long id = Long.valueOf(request.getParameter("id"));
		String password = request.getParameter("password");
		Long roleId = Long.valueOf(request.getParameter("role_id"));

		Admin admin = new Admin();
		admin.setId(id);
		admin.setPassword(password);
		admin.setRoleId(roleId);

		request.setAttribute("admin", admin);

		return jsonResult;
	}
	
	@RequestMapping(value = "/addVM", method = RequestMethod.GET)
	public String addVM(HttpServletRequest request, HttpServletResponse response){
		logger.info("addVM");
		
		List<Role> roleList = roleService.listAllRole();
		
		request.setAttribute("roleList", roleList);
		
		return "sys/admin/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
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
