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
	
	@Test
	public void saveAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("123456");
		admin.setEnable(true);
		admin.setGmtCreate((int)System.currentTimeMillis() / 1000);
		admin.setGmtModified((int)System.currentTimeMillis() / 1000);
		
		Integer id = adminService.saveAdmin(admin);
		System.out.println(id.toString());
	}
	
}
