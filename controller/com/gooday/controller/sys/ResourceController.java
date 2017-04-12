package com.gooday.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooday.common.basic.BaseController;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IResourceService;

@Controller
@RequestMapping("sys/resource")
public class ResourceController extends BaseController {

	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response){
		logger.info("index");
		
		
		
		return "sys/resource/list";
	}
	
	@RequestMapping(value = "/view")
	public String view(HttpServletRequest request, HttpServletResponse response){
		logger.info("view");
		
		Long id = Long.valueOf(request.getParameter("id"));
		
		Resource resource = resourceService.getResourceById(id);
		
		request.setAttribute("resource", resource);
		
		return "sys/resource/view";
	}
	
}
