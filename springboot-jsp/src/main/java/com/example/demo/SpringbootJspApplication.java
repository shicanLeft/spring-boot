package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringbootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJspApplication.class, args);
	}
	
	@RequestMapping("index")
	@ResponseBody   /***以json形式返回*/
	public String index(HttpServletRequest request,HttpServletResponse response){
		return "hello world"; 
	}
	
}
