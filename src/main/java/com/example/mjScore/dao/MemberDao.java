package com.example.mjScore.dao;

import com.example.mjScore.model.GroupBean;

public interface MemberDao {
	
	public void saveGroup(GroupBean gb);
	
	public GroupBean checkLogin(String account,String password);
}
