package com.example.mjScore.model;


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
@Table(name="winType")
public class WinType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="typeId")
	private int typeId;
	@Column(name="typeName")
	private String typeName;
	@Column(name="typeNumber")
	private int typeNumber;
	
//	@ManyToMany(mappedBy = "wintype")
//	private Set<MemberBean> memerBean = new HashSet<>();
	
	
	
	public WinType() {
		super();
		// TODO Auto-generated constructor stub
	}



	public WinType(int typeId, String typeName, int typeNumber) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeNumber = typeNumber;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public int getTypeNumber() {
		return typeNumber;
	}



	public void setTypeNumber(int typeNumber) {
		this.typeNumber = typeNumber;
	}


//
//	public Set<MemberBean> getMemerBean() {
//		return memerBean;
//	}
//
//
//
//	public void setMemerBean(Set<MemberBean> memerBean) {
//		this.memerBean = memerBean;
//	}
	
	
	
}
