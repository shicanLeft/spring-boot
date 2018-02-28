package com.example.springboot_jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_jdbc.pojo.User;
import com.example.springboot_jdbc.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("user/getAll")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/**
	 * @RequestBody 表示请求参数接受json形式（映射到user对象） ==>可使用postman测试
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="user/add",method=RequestMethod.POST)
	public Boolean addUser(@RequestBody User user){
		return userRepository.addUser(user);
	}

}
