package com.example.mjScore.repository;


import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mjScore.model.MemberRecord;

public interface RecordRepository extends JpaRepository<MemberRecord, Integer>{
	
//	@Query("SELECT m.memberId sum(m.score) FROM MemberRecord m WHERE TO_DAYS(m.winTime) = TO_DAYS(NOW()) group by m.memberId")
}
