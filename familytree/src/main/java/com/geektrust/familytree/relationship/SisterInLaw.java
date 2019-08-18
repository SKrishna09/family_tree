package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class SisterInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder sisterInLaw = new StringBuilder();

		// SPOUSE'S SISTERS
		Person spouse = person.getSpouse();
		if (null != spouse) {
			String spousesSisters = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(spouse,
					FamilyTreeConstants.FEMALE);
			sisterInLaw.append(spousesSisters);
		}

		// WIVES OF SIBLINGS
		String spouseOfSiblings = FamilyTreeCommonBehaviour.getSpouseOfSiblings(person, FamilyTreeConstants.MALE);
		sisterInLaw.append(spouseOfSiblings);
		return sisterInLaw.toString();
	}
}
