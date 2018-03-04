package com.example.springbootmybatis.mapper;

import java.util.List;

import com.example.springbootmybatis.bean.User;

public interface UserMapper {
	List<User> findAll();
}
