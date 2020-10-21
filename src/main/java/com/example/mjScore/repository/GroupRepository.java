package com.example.mjScore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;


public interface GroupRepository extends JpaRepository<Group, Integer> {
	
	public Group findByGroupAccountAndPassword(String account,String password);
	
//	public GroupBean checkLogin(String account,String password);
	
//	public boolean accountExists(String account);
	
//	public List<MemberBean> getMembersByTeamId(int id);
	
//	public void updateMemberScore(int id,int score);

//	public void updateLastTimePlay(GroupBean gb);
	
//	public void updateMemberName(MemberBean mb);
}
