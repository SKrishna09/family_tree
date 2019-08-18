package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class Daughter implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		return FamilyTreeCommonBehaviour.getPersonsGenderSpecificChildren(person, FamilyTreeConstants.FEMALE);
	}
}
