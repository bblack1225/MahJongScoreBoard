package com.example.mjScore.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
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
@Table(name = "members")
public class MemberBean {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String memberName;
	
	@Column(name="joinDate")
	private Date joinDate;
	
	@Column(name="score")
	private int score;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="group")
//	private GroupBean groupBean;
//	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="type_id")
//	private Set<WinTypeBean> wintype = new LinkedHashSet<>();
	
}
