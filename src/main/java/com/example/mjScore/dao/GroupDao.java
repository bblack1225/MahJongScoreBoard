package com.example.mjScore.dao;

import java.util.List;

import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;

public interface GroupDao {
	
	public void saveGroup(GroupBean gb);
	
	public GroupBean checkLogin(String account,String password);
	
	public boolean accountExists(String account);
	
	public List<MemberBean> getMembersByTeamId(int id);
}
