package com.example.mjScore.model;

import java.util.Date;

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
	private Integer winType;
	private Date winTime;
	private Integer score;
	
	
	public MemberRecord() {
	}
	
	public MemberRecord(Integer id, Integer memberId, Integer winType, Date winTime, Integer score) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.winType = winType;
		this.winTime = winTime;
		this.score = score;
	}
	
	
	
	public MemberRecord(Integer memberId, Integer winType, Date winTime, Integer score) {
		super();
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
	public Integer getWinType() {
		return winType;
	}
	public void setWinType(Integer winType) {
		this.winType = winType;
	}
	public Date getWinTime() {
		return winTime;
	}
	public void setWinTime(Date winTime) {
		this.winTime = winTime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
