package com.example.mjScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mjScore.service.RecordService;

@RestController
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	RecordService service;
	
	@PostMapping("addRecord")
	public void addRecord(@RequestParam("addMember")String member) {
		System.out.println(member);
	}
}
