package com.example.mjScore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mjScore.model.MemberRecord;

public interface RecordRepository extends JpaRepository<MemberRecord, Integer>{
}
