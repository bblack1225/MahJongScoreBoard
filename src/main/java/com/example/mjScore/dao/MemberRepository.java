package com.example.mjScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.MemberBean;

public interface MemberRepository extends JpaRepository<MemberBean, Integer>{

}
