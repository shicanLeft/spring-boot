package com.example.springbootmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootmybatis.bean.User;
import com.example.springbootmybatis.service.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("findAll")
	@ResponseBody
	List<User> findAll(){
		List<User> userList =  userService.findAll();
		System.out.println(userList.toString());
		return userList;
	}
}
