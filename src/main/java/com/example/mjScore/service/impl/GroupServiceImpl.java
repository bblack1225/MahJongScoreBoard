package com.example.mjScore.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.mjScore.dao.GroupDao;
import com.example.mjScore.dao.GroupRepository;
import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;
import com.example.mjScore.service.GroupService;

@Transactional
@Service
@EnableTransactionManagement
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDao dao;
	
	@Autowired
	GroupRepository repo;
	
	@Override
	public void saveGroup(GroupBean gb) {
		dao.saveGroup(gb);
	}

	@Override
	public GroupBean checkLogin(String account, String password) {
		return dao.checkLogin(account, password);
	}

	@Override
	public boolean accountExists(String account) {
		return dao.accountExists(account);
	}

	@Override
	public List<MemberBean> getMembersByTeamId(int id) {
		return dao.getMembersByTeamId(id);
	}

	@Override
	public void updateMemberScore(int id, int score) {
		dao.updateMemberScore(id, score);
	}


	
}
