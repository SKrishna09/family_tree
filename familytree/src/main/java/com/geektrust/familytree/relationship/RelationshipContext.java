package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;

public class RelationshipContext {

	private FamilyRelation familyRelation;

	public void setRelation(FamilyRelation familyRelation) {
		this.familyRelation = familyRelation;
	}

	public String getRelation(Person person) {
		return familyRelation.getRelation(person).trim();
	}
}
