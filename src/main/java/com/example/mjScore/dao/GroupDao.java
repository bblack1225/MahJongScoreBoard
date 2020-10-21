package com.example.mjScore.dao;

import java.util.List;

import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;

public interface GroupDao {
	
	public void saveGroup(Group gb);
	
	public Group checkLogin(String account,String password);
	
	public boolean accountExists(String account);
	
	public List<Member> getMembersByTeamId(int id);
	
	public void updateMemberScore(int id,int score);

	public void updateLastTimePlay(Group gb);
	
	public void updateMemberName(Member mb);
}
