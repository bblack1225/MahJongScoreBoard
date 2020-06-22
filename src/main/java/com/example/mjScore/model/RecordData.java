package com.example.mjScore.model;

public class RecordData {
	
	private String typeName;
	private Integer count;
	
	
	
	public RecordData() {
	}

	public RecordData(String typeName, Integer count) {
		super();
		this.typeName = typeName;
		this.count = count;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
