package com.geektrust.familytree.model;

import com.geektrust.familytree.utility.FamilyTreeConstants;

public enum Gender {
	MALE(FamilyTreeConstants.MALE), FEMALE(FamilyTreeConstants.FEMALE);

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
}
