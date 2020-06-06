package com.example.mjScore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.mjScore.model.GroupBean;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(@ModelAttribute("group")GroupBean group) {
		return "index";
	}
	

}
