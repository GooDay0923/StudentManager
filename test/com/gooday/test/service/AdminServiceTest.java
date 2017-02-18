package com.gooday.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gooday.model.admin.Admin;
import com.gooday.service.auth.IAdminService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class AdminServiceTest {

	@Autowired
	private IAdminService adminService;
	
	@Test
	public void getAdminByUsernameAndPassword() {
		String username = "admin";
		String password = "admin";
		
		Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
		
	}
	
}
