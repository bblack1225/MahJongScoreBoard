package com.example.mjScore.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mjScore.model.MemberRecord;

public interface RecordRepository extends JpaRepository<MemberRecord, Integer>{
	
//	@Query("select r.wintype from MemberRecord r where r.memberId = :id group by r.wintype order by r.id having count(wintype) > 0")
//	public Map<Integer,Integer> getMemberRecords(int id);
}
