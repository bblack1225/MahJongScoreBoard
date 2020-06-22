package com.example.mjScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mjScore.dao.MemberRepository;
import com.example.mjScore.model.MemberBean;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository repo;
	
//	//找所有隊員
//	public List<MemberBean> findAllMembersByTeam(int id){
//		return repo.findById(id).get()
//	}
//	
	//新增隊員
	public void addMember(MemberBean memberBean) {
		repo.save(memberBean);
	}
	
	//找隊員
	public MemberBean getMember(int id) {
		return repo.findById(id).get();
	}
	
	
}
