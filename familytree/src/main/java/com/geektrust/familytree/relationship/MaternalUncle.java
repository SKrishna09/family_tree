package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class MaternalUncle implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		String maternalUncle = null;
		Person mother = person.getMother();
		if (null != mother) {
			maternalUncle = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(mother,
					FamilyTreeConstants.MALE);
		}
		return maternalUncle;
	}
}
