package com.example.demo.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspDemoController {
	
	@RequestMapping("index")
	public String index(Model model){
		String message = "jsp";
		model.addAttribute("message", message);
		return "index";
	}
}
