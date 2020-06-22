package com.example.mjScore.controller;

import java.util.ArrayList;
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
import com.example.mjScore.model.RecordData;
import com.example.mjScore.service.GroupService;
import com.example.mjScore.service.MemberService;
import com.example.mjScore.service.RecordService;

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
	
	
	@PostMapping("/addMembers")
	public List<MemberBean> addMembers(@RequestParam("memberName")String newMember,HttpServletResponse response,HttpSession session) {
//		response.setCharacterEncoding("UTF-8");
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
		MemberRecord record = new MemberRecord(id,type,new java.util.Date(),score);
		recordService.saveRecord(record);
		Integer memberScore = memberService.getMember(id).getScore();
		groupService.updateMemberScore(id, memberScore + score);
		List<MemberBean> members = groupService.getMembersByTeamId(groupId);
		return members;
	}
	
	@PostMapping("/showRecords")
	public List<Integer> showRecords(@RequestParam("memberId")int id){
//		public Map<String,Integer> showRecords(@RequestParam("memberId")int id){
//		Map<String,Integer> records = new LinkedHashMap<String, Integer>();
		List<Integer> records = new ArrayList<>();
		records = recordService.getMemberRecords(id);
		for(int a :records) {
			System.out.print(records.get(a) + " ");
		}
		return records;
	}
}
