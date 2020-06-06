package com.example.mjScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.GroupBean;


public interface GroupRepository extends JpaRepository<GroupBean, Integer> {
	
//	public GroupBean checkLogin(String account,String password);
}
