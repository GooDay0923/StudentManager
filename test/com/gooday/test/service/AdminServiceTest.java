package com.gooday.test.service;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gooday.model.admin.Admin;
import com.gooday.service.sys.IAdminService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class AdminServiceTest {

	@Autowired
	private IAdminService adminService;
	
	@Test
	public void getAdminByUsernameAndPassword() {
		
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("123456");
		admin.setSalt("e10e0ee1cf9098bf7c4e4535d492d076");
		
		Admin adminRecord = adminService.getAdminByUsernameAndPassword(admin);
		
	}
	
	@Test
	public void saveAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setUsername("nn");
		admin.setPassword("nn");
		admin.setEnable(true);
		admin.setGmtCreate(Math.toIntExact(System.currentTimeMillis() / 1000));
		admin.setGmtModified(Math.toIntExact(System.currentTimeMillis() / 1000));
		
		Integer id = adminService.saveAdmin(admin);
		System.out.println(id);
		System.out.println(admin.getId());
	}
	
	
	@Test
	public void getAdminPermissions() {
		String username = "admin";
		Set<String> permission = adminService.getAdminPermissions(username);
		System.out.println(permission.toString());
	}

	@Test
    public void listAdminByUserName(){
        String username = "a";
        List<Admin> adminList = adminService.listAdminByUserName(username, 1, 2);
        System.out.println(adminList);
    }
	
}
