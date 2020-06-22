package com.example.mjScore.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;
import com.example.mjScore.model.WinTypeBean;
import com.example.mjScore.service.GroupService;
import com.example.mjScore.service.MemberService;
import com.example.mjScore.service.RecordService;
import com.example.mjScore.service.TypeService;

@Controller
@RequestMapping("/member")
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	TypeService typeService;
	
	@Autowired
	MemberService memberService;
	
	//進入註冊頁面
	@GetMapping("/register")
	public String goToregister(@ModelAttribute("group") GroupBean group) {
		return "register";
	}
	
	//註冊
	@PostMapping("/register")
	public String register(@ModelAttribute("group") GroupBean group,RedirectAttributes ra,HttpSession session) {
		group.setCreateTime(new Timestamp(System.currentTimeMillis()));
		groupService.saveGroup(group);
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
							 Model model,HttpSession session) {
		GroupBean gb = groupService.checkLogin(account, password);
		if(gb == null) {
			model.addAttribute("loginError", "帳號或密碼錯誤");
			return "index";
		}else {
			List<MemberBean> members = groupService.getMembersByTeamId(gb.getGroupId());
			List<WinTypeBean> types = typeService.getAllType();
			session.setAttribute("LoginOK", gb);
			model.addAttribute("groupId", gb.getGroupId());
			model.addAttribute("groupMembers", members);
			model.addAttribute("type", types);
		}
		return "groupPage";
	}
	
	@PostMapping("/checkSameAccount")
	public void checkSameAccount(@RequestParam("account")String account,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		//利用ajax方式，取得前端送來的email 
		try (PrintWriter out = response.getWriter();) {
			if (account.trim().length() != 0) {
				//檢查資料庫內有沒有一樣的email 有的話就不能使用
				boolean exist = groupService.accountExists(account);
				if (!exist) {
					out.write("帳號沒有重複");
					out.flush();
				} else {
					out.write("帳號已重複");
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
		
		
	}
	
}
