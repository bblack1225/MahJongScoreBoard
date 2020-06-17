package com.example.mjScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.WinTypeBean;

public interface TypeRepository extends JpaRepository<WinTypeBean, Integer>{

}
