package com.jesus.sshframework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Resource
	private IUserService userService;

	// @RequestMapping(value = "/add" ,method=RequestMethod.POST)
	@RequestMapping("/add")
	public void add() {
		User user = new User("我是新加" + System.currentTimeMillis(),
				"Maven整合Spring+SpringMVC+Hibernate+FreeMarker框架");
		userService.save(user);
	}
}
