package com.example.mjScore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.mjScore.model.Group;

//去首頁的控制器
@Controller
public class HomeController {
	
	//送一個空表單去前端，方便往後進行驗證
	@GetMapping("/")
	public String home(@ModelAttribute("group")Group group) {
		return "index";
	}
	
}
