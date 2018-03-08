package com.example.springbootcache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * cache配置
 */

@Configuration  //配置类
@EnableCaching  //开启缓存
public class CacheConfiguration {


   
	/**#########################以下俩个bean都是属于缓存bean的注入配置测试时任选其一(注释一个)################*/
	
	/**
     * CacheMananger
     * @return
     */
    @Bean
    public CacheManager simpleCacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache"); //定义一个容器
        
        ConcurrentMapCache guava = new ConcurrentMapCache("guava"); //定义另一個容器

        ArrayList<ConcurrentMapCache> cacheList =   new ArrayList<>();
        cacheList.add(cache);
        cacheList.add(guava);
        simpleCacheManager.setCaches(cacheList);
        //simpleCacheManager.setCaches(Arrays.asList(cache));

        return simpleCacheManager;

    }
    
    /**
     * 配置Guava CacheManager
     * @return
     */
	@Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        
        cacheManager.setCacheBuilder(
            CacheBuilder.newBuilder().
            expireAfterWrite(10, TimeUnit.SECONDS).
            maximumSize(1000));
        
        return cacheManager;
    }

}

