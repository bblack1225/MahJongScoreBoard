package com.example.mjScore.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;
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
	RecordService service;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	RecordService recordService;
	
	
	//新增隊伍的成員
	@PostMapping("/addMembers")
	public List<MemberBean> addMembers(@RequestParam("memberName")String newMember,HttpServletResponse response,HttpSession session) {
			GroupBean gb = (GroupBean)session.getAttribute("LoginOK");
			Integer groupId = gb.getGroupId();
			MemberBean mb = new MemberBean(newMember,new java.util.Date(),0,groupId);
			memberService.addMember(mb);
			List<MemberBean> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	//新增一筆紀錄
	@PostMapping("/addRecord")
	public List<MemberBean> saveRecord(@RequestParam("memberId")int id,
									   @RequestParam("score")int score,
									   @RequestParam("typeId")int type,
									   @RequestParam("groupId")int groupId){
		//存紀錄時給予日期方便以後進行月份或年份的統計
		MemberRecord record = new MemberRecord(id,type,new java.util.Date(),score);
		recordService.saveRecord(record);
		//取得會員原本的分數，並加(減)上新增的分數
		Integer memberScore = memberService.getMember(id).getScore();
		groupService.updateMemberScore(id, memberScore + score);
		List<MemberBean> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	//顯示該名成員的紀錄
	@PostMapping("/showRecords")
		public Map<String,Integer> showRecords(@RequestParam("memberId")int id){
		System.out.println("in");
		Map<String,Integer> records = new LinkedHashMap<String, Integer>();
		records = recordService.getMemberRecords(id);
		return records;
	}
}
