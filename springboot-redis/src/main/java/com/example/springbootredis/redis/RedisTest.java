package com.example.springbootredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.pojo.User;

@Repository("redisTest")
public class RedisTest {
	
	@Autowired
	private RedisTemplate redisTemplate; 
	
	/**
	 * 
	 *  向 redis 0db 缓存 k v 的user信息 
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User save(User user){
		System.out.println("redis 缓存数据库 0db中 缓存数据key = "+user.getUserId()+"&&& value="+user.toString());
		redisTemplate.opsForValue().set(user.getUserId(), user);
		return user;
	}
	
	
	/**
	 * 通过ID 向redis 0db缓存中 取出数据
	 * 
	 */
	public User findById(String id){
		User user = (User)redisTemplate.opsForValue().get(Integer.parseInt(id));
		System.out.println("从redis缓存中读取数据=="+user.toString());
		return user;
	}
	
}
