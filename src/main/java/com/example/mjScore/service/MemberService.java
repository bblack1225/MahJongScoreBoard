package com.example.mjScore.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.mjScore.model.Member;
import com.example.mjScore.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	EntityManager em;
	
	//新增隊員
	public void addMember(Member memberBean) {
		repo.save(memberBean);
	}
	
	//找隊員
	public Member getMember(int id) {
		return repo.findById(id).get();
	}
	

	
}
