package com.example.mjScore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "members")
public class MemberBean {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memberId")
	private int memberId;
	
	@Column(name="name")
	private String memberName;
	
	@Column(name="joinDate")
	private Date joinDate;
	
	@Column(name="score")
	private int score;
	
	@Column(name="groupId")
	private int groupId;
	
//	@ManyToOne
//	@JoinColumn(name="groupId",nullable = false)
//	private GroupBean groupBean;
	
	

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="member_wintype")
//	@JoinColumn(name="typeId")
//	private Set<WinTypeBean> wintype = new HashSet<>();
	
	
	
	public MemberBean() {
		super();
	}

//	public MemberBean(int memberId, String memberName, Date joinDate, int score, GroupBean groupBean,
//			Set<WinTypeBean> wintype) {
//		super();
//		this.memberId = memberId;
//		this.memberName = memberName;
//		this.joinDate = joinDate;
//		this.score = score;
//		this.groupBean = groupBean;
//		this.wintype = wintype;
//	}

	
	
	public int getMemberId() {
		return memberId;
	}

	public MemberBean(String memberName, Date joinDate, int score, int groupId) {
		super();
		this.memberName = memberName;
		this.joinDate = joinDate;
		this.score = score;
		this.groupId = groupId;
	}

	public MemberBean(int memberId, String memberName, Date joinDate, int score, int groupId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.joinDate = joinDate;
		this.score = score;
		this.groupId = groupId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

//	public GroupBean getGroupBean() {
//		return groupBean;
//	}
//
//	public void setGroupBean(GroupBean groupBean) {
//		this.groupBean = groupBean;
//	}

//	public Set<WinTypeBean> getWintype() {
//		return wintype;
//	}
//
//	public void setWintype(Set<WinTypeBean> wintype) {
//		this.wintype = wintype;
//	}
	
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
