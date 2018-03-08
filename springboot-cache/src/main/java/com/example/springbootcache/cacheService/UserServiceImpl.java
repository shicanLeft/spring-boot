package com.example.springbootcache.cacheService;

import com.example.springbootcache.mapper.UserMapper;
import com.example.springbootcache.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 测试cache缓存
 */
@Service("userServiceImpl")
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过ID  缓存当前User
     *
     * 如果缓存中存在  就不需要查询db
     *
     * 否则 查询db
     * @param id
     * @return
     */
    @Cacheable(value = "cache",key = "#id")
    public User findById(String id){
    	/**
    	 * 再次请求控制台不会打印
    	 * 
    	 * 说明已缓存
    	 * */
        System.out.println("cache查询 db");
        return userMapper.findById(id);
    }
    
    
    /**
     * 扩展  使用配置文件  增加谷歌的guava缓存
     * 测试同上
     */
    @Cacheable(value = "guava",key = "#id")
    public User findByIdTwo(String id){
    	/**
    	 * 再次请求控制台不会打印
    	 * 
    	 * 说明已缓存
    	 * */
        System.out.println("guava查询 db");
        return userMapper.findById(id);
    }
    
    
}
