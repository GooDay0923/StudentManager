package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.gooday.common.basic.JsonResult;
import com.gooday.common.model.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		logger.info("list");

		return "sys/resource/list";
	}

	@RequestMapping(value = "/getAllResource")
	@ResponseBody
	public List<TreeNode> getAllResource(HttpServletRequest request, HttpServletResponse response){
		logger.info("getAllResource");

		List<TreeNode> treeNodeList = resourceService.listAllResource();

		return treeNodeList;
	}

	@RequestMapping(value = "/getResourceById")
	@ResponseBody
	public JsonResult getResourceById(HttpServletRequest request, HttpServletResponse response){
		logger.info("getResourceById");

		JsonResult jsonResult = new JsonResult();

		try{
			Long id = Long.valueOf(request.getParameter("id"));

			Resource resource = resourceService.getResourceById(id);

			jsonResult.setCode(JsonResult.OP_SUCCESS);
			jsonResult.setData(resource);
		} catch (Exception e){
			jsonResult.setCode(JsonResult.OP_ERROR);
			jsonResult.setMessage(e.getMessage());
		}

		return jsonResult;
	}


	
}
