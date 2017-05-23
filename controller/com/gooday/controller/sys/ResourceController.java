package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.gooday.common.basic.JsonResult;
import com.gooday.common.model.TreeNode;
import com.gooday.model.role.Role;
import com.gooday.service.sys.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IResourceService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/resource")
public class ResourceController extends BaseController {

	@Autowired
	private IResourceService resourceService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		logger.info("list");

        List<Role> roleList = roleService.listAllRole();

        request.setAttribute("roleList", roleList);

		return "sys/resource/list";
	}

	@RequestMapping(value = "/getAllResource")
	@ResponseBody
	public List<TreeNode> getAllResource(HttpServletRequest request, HttpServletResponse response){
		logger.info("getAllResource");

		List<TreeNode> treeNodeList = resourceService.listAllResource();

		return treeNodeList;
	}

	@RequestMapping(value = "/get/{id}")
	@ResponseBody
	public JsonResult get(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
		logger.info("get");

		Long resourceId = Long.valueOf(id);

		Resource resource = resourceService.getResourceById(resourceId);

		return JsonResult.success(resource, "");
	}


	
}
