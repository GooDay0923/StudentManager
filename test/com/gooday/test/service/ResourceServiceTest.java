package com.gooday.test.service;

import com.gooday.common.model.TreeNode;
import com.gooday.model.resource.Resource;
import com.gooday.service.sys.IAdminService;
import com.gooday.service.sys.IResourceService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huangyuheng on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class ResourceServiceTest {

    @Autowired
    private IResourceService resourceService;

    @Test
    public void listAdminResource(){
    	Set<String> permissions = new HashSet<String>();
    	List<TreeNode> treeNodeList = resourceService.listAdminResource(permissions);
    	System.out.println(treeNodeList.toString());   	
    }
    
    @Test
    public void getResourceById(){
    	Resource resource = resourceService.getResourceById(2L);
    	System.out.println(resource.getUrl());
    	System.out.println(resource.getName());
    }
    
}
