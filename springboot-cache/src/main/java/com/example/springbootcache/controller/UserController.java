package com.example.springbootcache.controller;

import com.example.springbootcache.cacheService.UserServiceImpl;
import com.example.springbootcache.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping("findById")
    @ResponseBody
    public User findById(HttpServletRequest request){

        String id = request.getParameter("id");

        return userServiceImpl.findById(id);
    }
    
    @RequestMapping("findByIdTwo")
    @ResponseBody
    public User findByIdTwo(HttpServletRequest request){

        String id = request.getParameter("id");

        return userServiceImpl.findByIdTwo(id);
    }
}
