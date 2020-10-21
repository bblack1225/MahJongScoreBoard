package com.example.mjScore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mjScore.model.WinType;
import com.example.mjScore.repository.TypeRepository;


//顯示牌型的種類
@Service
public class TypeService {
	
	@Autowired
	TypeRepository repo;
	
	public List<WinType> getAllType(){
		return repo.findAll();
	}
}
