package com.example.mjScore.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.mjScore.dao.GroupDao;
import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;
import com.example.mjScore.repository.GroupRepository;
import com.example.mjScore.service.GroupService;

@Transactional
@Service
@EnableTransactionManagement
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDao dao;
	
	@Autowired
	GroupRepository groupRepository;
	
	@Override
	public void saveGroup(Group gb) {
		dao.saveGroup(gb);
	}

	@Override
	public Group checkLogin(String account, String password) {
		return groupRepository.findByGroupAccountAndPassword(account, password);
	}

	@Override
	public boolean accountExists(String account) {
		return dao.accountExists(account);
	}

	@Override
	public List<Member> getMembersByTeamId(int id) {
		return dao.getMembersByTeamId(id);
	}

	@Override
	public void updateMemberScore(int id, int score) {
		dao.updateMemberScore(id, score);
	}

	@Override
	public void updateLastTimePlay(Group gb) {
		dao.updateLastTimePlay(gb);
	}

	public void updateMemberName(Member mb) {
		dao.updateMemberName(mb);
	}
	
}
