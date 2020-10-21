package com.example.mjScore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
}
