package com.gooday.controller.sys.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooday.service.sys.IAdminService;
import com.gooday.service.sys.IResourceService;

public class SysAdminFilter extends PathMatchingFilter {

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IResourceService resourceService;
	
	
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	
    	String username = (String)SecurityUtils.getSubject().getPrincipal();
    	
    	request.setAttribute("menus", "test");
    	
		return true;
    }
	
	
}
