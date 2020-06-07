package com.example.mjScore.service;


import com.example.mjScore.model.GroupBean;

public interface MemberService {
	
	public void saveGroup(GroupBean gb);
	
	public GroupBean checkLogin(String account,String password);
	
	public boolean accountExists(String account);
}
