package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class PaternalUncle implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		String paternalUncle = null;
		Person father = person.getFather();
		if (null != father) {
			paternalUncle = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(father,
					FamilyTreeConstants.MALE);
		}
		return paternalUncle;
	}
}
