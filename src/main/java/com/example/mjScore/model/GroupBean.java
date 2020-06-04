package com.example.mjScore.model;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	
	@OneToMany(mappedBy = "groupBean",fetch = FetchType.EAGER)
	private Set<MemberBean> memberBean = new HashSet<>();
}
