package com.example.mjScore.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer memberId;
	private String winType;
	private Timestamp winTime;
	private Integer score;
	
	
	public MemberRecord() {
	}
	
	public MemberRecord(Integer id, Integer memberId, String winType, Timestamp winTime, Integer score) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.winType = winType;
		this.winTime = winTime;
		this.score = score;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getWinType() {
		return winType;
	}
	public void setWinType(String winType) {
		this.winType = winType;
	}
	public Timestamp getWinTime() {
		return winTime;
	}
	public void setWinTime(Timestamp winTime) {
		this.winTime = winTime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
