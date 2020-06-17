package com.example.mjScore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mjScore.dao.RecordRepository;
import com.example.mjScore.model.MemberRecord;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository repo;
	
	//儲存紀錄
	public void saveRecord(MemberRecord record) {
		 repo.save(record);
	}
	
	//找會員的紀錄
	public MemberRecord getRecordsbuMember(int id) {
		return repo.findById(id).get();
	}
}
