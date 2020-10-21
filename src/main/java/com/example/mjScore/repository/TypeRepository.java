package com.example.mjScore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.WinType;

public interface TypeRepository extends JpaRepository<WinType, Integer>{

}
