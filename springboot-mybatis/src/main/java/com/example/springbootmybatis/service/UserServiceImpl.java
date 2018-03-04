package com.example.springbootmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.example.springbootmybatis.bean.User;
import com.example.springbootmybatis.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(2, 2);  //test    设定为第一页  && 分页大小为2 
		return userMapper.findAll();
	}

}
