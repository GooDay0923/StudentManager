package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.gooday.common.basic.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("sys/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(required = false, defaultValue = "1") String page,
                       @RequestParam(required = false, defaultValue = "10") String rows){
		logger.info("list");

        int sqlPage = 1;
        int sqlRows = 10;

        String name = request.getParameter("name");

        if(StringUtils.isNumeric(page)){
            sqlPage =  Integer.parseInt(page);
        }

        if(StringUtils.isNumeric(page)){
            sqlRows =  Integer.parseInt(rows);
        }

        List<Role> roleList = roleService.listRoleByName(name, sqlPage,sqlRows);

        request.setAttribute("pageInfo", new PageInfo<Role>(roleList));
        request.setAttribute("name", name);
        request.setAttribute("page", page);
        request.setAttribute("rows", rows);

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

	@RequestMapping(value = "/addVM")
	public String addVM(HttpServletRequest request, HttpServletResponse response){
		logger.info("addVM");

		return "sys/role/add";
	}

	@RequestMapping(value = "/add")
	public JsonResult add(HttpServletRequest request, HttpServletResponse response){
		logger.info("add");


		return JsonResult.success(null, null);
	}

    @RequestMapping(value = "/editVM")
    public String editVM(HttpServletRequest request, HttpServletResponse response){
        logger.info("editVM");

        return "sys/role/add";
    }

    @RequestMapping(value = "/edit")
    public JsonResult edit(HttpServletRequest request, HttpServletResponse response){
        logger.info("edit");


        return JsonResult.success(null, null);
    }

    @RequestMapping(value = "/remove")
    public JsonResult remove(HttpServletRequest request, HttpServletResponse response){
        logger.info("remove");



        return JsonResult.success(null, null);
    }


}
