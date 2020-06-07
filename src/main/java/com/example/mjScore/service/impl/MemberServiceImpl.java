package com.example.mjScore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.mjScore.dao.MemberDao;
import com.example.mjScore.model.GroupBean;
import com.example.mjScore.service.MemberService;

@Transactional
@Service
@EnableTransactionManagement
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;
	
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

}
