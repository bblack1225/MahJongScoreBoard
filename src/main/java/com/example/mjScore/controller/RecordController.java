package com.example.mjScore.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;
import com.example.mjScore.model.MemberRecord;
import com.example.mjScore.service.GroupService;
import com.example.mjScore.service.MemberService;
import com.example.mjScore.service.RecordService;

/*
 此控制器的方法使用rest風格來撰寫，皆傳回物件給前端進行處理，有
 	1.新增隊伍的成員
 	2.新增一筆紀錄
 	3.顯示該名成員的紀錄
 */
@RestController
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	RecordService recordService;
	
	
	//新增隊伍的成員
	@PostMapping("/addMembers")
	public List<Member> addMembers(@RequestParam("memberName")String newMember,HttpServletResponse response,HttpSession session) {
			Group gb = (Group)session.getAttribute("LoginOK");
			Integer groupId = gb.getGroupId();
			Member mb = new Member(newMember,new java.util.Date(),0,groupId);
			memberService.addMember(mb);
			List<Member> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	//呈現排行榜紀錄
	@PostMapping("/showGroupRecord/{groupId}")
	public List<Member> showGroupRecord(@PathVariable int groupId) {
		List<Member> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	
	//新增一筆紀錄
	@PostMapping("/addRecord")
	public List<Member> saveRecord(@RequestParam("memberId")int id,
									   @RequestParam("score")int score,
									   @RequestParam(value="typeId")int type,
									   @RequestParam("groupId")int groupId,
									   Model model){
		//存紀錄時給予日期方便以後進行月份或年份的統計
		MemberRecord record = new MemberRecord(id,type,new java.util.Date(),score);
		recordService.saveRecord(record);
		//取得會員原本的分數，並加(減)上新增的分數
		Integer memberScore = memberService.getMember(id).getScore();
		groupService.updateMemberScore(id, memberScore + score);
		List<Member> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	//顯示該名成員的紀錄
	@PostMapping("/showRecords")
		public Map<String,Integer> showRecords(@RequestParam("memberId")int id){
		Map<String,Integer> records = new LinkedHashMap<String, Integer>();
		records = recordService.getMemberRecords(id);
		return records;
	}
	
	@PostMapping("/showRecordByDate/{dateSelect}")
	public Map<Integer,Integer> showRecordByDate(@PathVariable String dateSelect,Model model,HttpSession session){
//		public List<Integer> showRecordByDate(@PathVariable String dateSelect,Model model,HttpSession session){
		List<Integer> list = new ArrayList<Integer>();
//		GroupBean gb = (GroupBean) session.getAttribute("LoginOK");
		Map<Integer,Integer> map = new LinkedHashMap<>();
//		if(!dateSelect.equals("total")) {
//			List<MemberBean> members = groupService.getMembersByTeamId(gb.getGroupId());
//			model.addAttribute("groupMembers", members);
//		}
		System.out.println(dateSelect);
		
//		list = recordService.showSelectRecord(dateSelect);
		map = recordService.showSelectRecord(dateSelect);
		return map;
//		return list;
	}
	
}
