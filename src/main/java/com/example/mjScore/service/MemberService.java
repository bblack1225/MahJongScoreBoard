package com.example.mjScore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mjScore.dao.GroupRepository;
import com.example.mjScore.model.GroupBean;

public interface MemberService {
	
	public void saveGroup(GroupBean gb);
	
	public GroupBean checkLogin(String account,String password);
}
