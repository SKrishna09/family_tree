package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class PaternalAunt implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		String paternalAunt = null;
		Person father = person.getFather();
		if (null != father) {
			paternalAunt = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(father,
					FamilyTreeConstants.FEMALE);
		}
		return paternalAunt;
	}
}
