package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;

public class RelationshipContext {

	private FamilyRelation familyRelation;

	public void setRelation(FamilyRelation familyRelation) {
		this.familyRelation = familyRelation;
	}

	public void getRelation(Person person) {
		String response = familyRelation.getRelation(person);
		if (null == response || response.isEmpty()) {
			System.out.println("NONE");
		} else {
			System.out.println(response);
		}
	}
}
