package com.example.mjScore.controller;


import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mjScore.model.GroupBean;
import com.example.mjScore.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//進入註冊頁面
	@GetMapping("/register")
	public String goToregister(@ModelAttribute("group") GroupBean group) {
		return "register";
	}
	
	//註冊
	@PostMapping("/register")
	public String register(@ModelAttribute("group") GroupBean group,RedirectAttributes ra) {
		group.setCreateTime(new Timestamp(System.currentTimeMillis()));
		memberService.saveGroup(group);
		ra.addFlashAttribute("saveTeam", group);
		return "redirect:/member/saveSuccess";
	}
	
	
	//轉跳登入成功
	@GetMapping("/saveSuccess")
	public String saveSuccess() {
		
		return "groupPage";
	} 
	
	//登入
	@PostMapping("/checkLogin")
	public String checkLogin(@RequestParam("account") String account,
							 @RequestParam("password")String password,
							 Model model,HttpSession session,RedirectAttributes ra) {
		GroupBean gb = memberService.checkLogin(account, password);
		if(gb == null) {
			System.out.println("帳密錯誤");
			model.addAttribute("loginError", "帳號或密碼錯誤");
		}else {
			System.out.println("帳號:" + gb.getGroupAccount());
			System.out.println("密碼:" + gb.getPassword());
			session.setAttribute("LoginOK", gb);
		}
		return "loginOK";
	}
}
