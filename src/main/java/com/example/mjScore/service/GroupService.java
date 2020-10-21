package com.example.mjScore.service;

import java.util.List;

import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;

public interface GroupService {
	
	//存隊伍
	public void saveGroup(Group gb);
	
	//檢查登入
	public Group checkLogin(String account,String password);
	
	//檢查帳號是否存在
	public boolean accountExists(String account);
	
	//透過隊伍ID找到該隊伍中的所有成員
	public List<Member> getMembersByTeamId(int id);
	
	//更新成員的分數
	public void updateMemberScore(int id,int score);
	
	public void updateLastTimePlay(Group gb);
	
	public void updateMemberName(Member mb);
}
