package com.example.mjScore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mjteam")
public class GroupBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groupId")
	private int groupId;
	@Column(name="groupAccount")
	private String  groupAccount;
	@Column(name="password")
	private String	password;
	@Column(name="groupName")
	private String 	groupName;
	@Column(name="createTime")
	private Date 	createTime;
	@Column(name="lastTimeToPlay")
	private Date 	lastTimeToPlay;
	
//	@OneToMany(mappedBy = "groupBean",fetch = FetchType.EAGER)
//	private Set<MemberBean> memberBean = new HashSet<>();
	
	
	
	public GroupBean() {
		super();
	}

//	public GroupBean(int groupId, String groupAccount, String password, String groupName, Date createTime,
//			Date lastTimeToPlay, Set<MemberBean> memberBean) {
//		super();
//		this.groupId = groupId;
//		this.groupAccount = groupAccount;
//		this.password = password;
//		this.groupName = groupName;
//		this.createTime = createTime;
//		this.lastTimeToPlay = lastTimeToPlay;
//		this.memberBean = memberBean;
//	}
	
	

	public int getGroupId() {
		return groupId;
	}

	
	
	public GroupBean(int groupId, String groupAccount, String password, String groupName, Date createTime,
			Date lastTimeToPlay) {
		super();
		this.groupId = groupId;
		this.groupAccount = groupAccount;
		this.password = password;
		this.groupName = groupName;
		this.createTime = createTime;
		this.lastTimeToPlay = lastTimeToPlay;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupAccount() {
		return groupAccount;
	}

	public void setGroupAccount(String groupAccount) {
		this.groupAccount = groupAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastTimeToPlay() {
		return lastTimeToPlay;
	}

	public void setLastTimeToPlay(Date lastTimeToPlay) {
		this.lastTimeToPlay = lastTimeToPlay;
	}

//	public Set<MemberBean> getMemberBean() {
//		return memberBean;
//	}
//
//	public void setMemberBean(Set<MemberBean> memberBean) {
//		this.memberBean = memberBean;
//	}
	
	
}
