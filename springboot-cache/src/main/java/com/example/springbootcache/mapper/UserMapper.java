package com.example.springbootcache.mapper;

import org.springframework.stereotype.Repository;
import com.example.springbootcache.pojo.User;

@Repository
public interface UserMapper {

	User findById(String id);
}
