package com.example.springbootredis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootredis.pojo.User;
import com.example.springbootredis.redis.RedisTest;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private RedisTest redisTest;
	
	@RequestMapping("save")
	@ResponseBody
	public User save(@RequestBody User user){
		return  redisTest.save(user);
	}
	
	@RequestMapping("findById")
	@ResponseBody
	public User findById(HttpServletRequest request){
		return  redisTest.findById(request.getParameter("id"));
	}
	
}
