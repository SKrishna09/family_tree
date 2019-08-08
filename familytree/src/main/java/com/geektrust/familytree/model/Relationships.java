package com.geektrust.familytree.model;

public enum Relationships {
	PATERNAL_UNCLE("Paternal-Uncle"),
	MATERNAL_UNCLE("Maternal-Uncle");

	private String relation;

	Relationships(String relation) {
		this.relation = relation;
	}

	public String getRelation() {
		return relation;
	}

}
