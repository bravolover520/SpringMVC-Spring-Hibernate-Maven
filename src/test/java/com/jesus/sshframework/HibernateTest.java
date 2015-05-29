package com.jesus.sshframework;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

public class HibernateTest {
	
	@SuppressWarnings("resource")
	@Test
	public void add() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		
		User user = new User();

		user.setUsername("O(∩_∩)O哈！粑粑");
		user.setPassword("1字");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		System.out.println(userService.save(user));
	}
	
	@SuppressWarnings("resource")
	@Test
	public void query() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		
		User user = userService.get("402881124d938727014d93872a050000");
		System.out.println(user.toString());
	}
	
	@SuppressWarnings("resource")
	@Test
	public void queryAll() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		
		List<User> users = userService.getAll();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void delete() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		userService.delete("402881124d938727014d93872a050000");
	}
	
	@SuppressWarnings("resource")
	@Test
	public void total() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-hibernate.xml" });
		
		IUserService userService = (IUserService) ac.getBean("userService");
		System.out.println(userService.getCount());
	}
}
