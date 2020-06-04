package com.example.mjScore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="winType")
public class WinTypeBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="typeId")
	private int typeId;
	@Column(name="typeName")
	private String typeName;
	@Column(name="typeNumber")
	private int typeNumber;
	
	@ManyToMany(mappedBy = "wintype")
	private Set<MemberBean> memerBean = new HashSet<>();
}
