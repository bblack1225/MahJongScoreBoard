package com.example.mjScore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mjScore.dao.TypeRepository;
import com.example.mjScore.model.WinTypeBean;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository repo;
	
	public List<WinTypeBean> getAllType(){
		return repo.findAll();
	}
}