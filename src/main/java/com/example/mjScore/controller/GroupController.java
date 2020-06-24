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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;
import com.example.mjScore.model.WinTypeBean;
import com.example.mjScore.service.GroupService;
import com.example.mjScore.service.MemberService;
import com.example.mjScore.service.TypeService;

/*裡面含有的方法有 
  1.登入與註冊(這兩個功能在同一個頁面)
  2.檢查帳號有沒有重複
*/
@Controller
@RequestMapping("/member")
public class GroupController {

	@Autowired
	GroupService groupService;

	@Autowired
	TypeService typeService;

	@Autowired
	MemberService memberService;

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		GroupBean gb = (GroupBean) session.getAttribute("LoginOK");
		gb.setLastTimeToPlay(new java.util.Date());
		groupService.updateLastTimePlay(gb);
		session.invalidate();
		return "redirect:/";
	}

	// 註冊
	@PostMapping("/register")
	public String register(@ModelAttribute("group") GroupBean group, RedirectAttributes ra, HttpSession session) {
		group.setCreateTime(new Timestamp(System.currentTimeMillis()));
		groupService.saveGroup(group);
		ra.addFlashAttribute("saveTeam", group);
		return "redirect:/member/saveSuccess";
	}

	// 轉跳登入成功
	@GetMapping("/saveSuccess")
	public String saveSuccess() {
		return "groupPage";
	}

	// 登入
	@PostMapping("/checkLogin")
	public String checkLogin(@ModelAttribute("group") GroupBean group, Model model, HttpSession session) {
		// 登入的資料利用 綁定表單的方式取得 在thymeleaf中利用(th:field)
		String account = group.getGroupAccount();
		String password = group.getPassword();
		GroupBean gb = groupService.checkLogin(account, password);
		if (gb == null) {
			model.addAttribute("loginError", "帳號或密碼錯誤");
			return "index";
		} else {
			// 取得該隊伍的每個成員
			List<MemberBean> members = groupService.getMembersByTeamId(gb.getGroupId());
			// 取得所有的牌種(要顯示在option內)
			List<WinTypeBean> types = typeService.getAllType();
			session.setAttribute("LoginOK", gb);
			model.addAttribute("groupId", gb.getGroupId());
			model.addAttribute("groupMembers", members);
			model.addAttribute("type", types);
		}
		return "groupPage";
	}

	@PostMapping("/checkSameAccount")
	public void checkSameAccount(@RequestParam("account") String account, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		// 利用ajax方式，取得前端送來的email
		try (PrintWriter out = response.getWriter();) {
			if (account.trim().length() != 0) {
				// 檢查資料庫內有沒有一樣的email 有的話就不能使用
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

	//更改隊員的名稱
	@PostMapping("/editMemberName/{name}/{id}")
	public void editMemberName(@PathVariable String name, @PathVariable int id,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
			System.out.println("name=" + name);
			System.out.println("id=" + id);
			MemberBean mb = memberService.getMember(id);
			mb.setMemberName(name);
			groupService.updateMemberName(mb);
			try {
				PrintWriter out = response.getWriter();
				out.print("");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
	}
}
