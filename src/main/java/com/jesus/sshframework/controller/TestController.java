package com.jesus.sshframework.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Resource
	private IUserService userService;

	// @RequestMapping(value = "/add" ,method=RequestMethod.POST)
	@RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String add() {
		User user = new User("我是新加" + System.currentTimeMillis(),
				"Maven整合Spring+SpringMVC+Hibernate+FreeMarker框架");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		userService.save(user);	
		return JSON.toJSONString(user);
	}
	
	@RequestMapping(value = "/queryAll", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryAll() {
		List<User> users = userService.getAll();
		return JSON.toJSONString(users, true);
	}

	@RequestMapping("/index")
	public String index() {
		return "views/hello";
//		return "ftls/index";
	}
}
