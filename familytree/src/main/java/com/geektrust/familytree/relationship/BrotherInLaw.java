package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class BrotherInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder brotherInLaw = new StringBuilder();

		// SPOUSE'S BROTHERS
		Person spouse = person.getSpouse();
		if (null != spouse) {
			String spousesBrothers = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(spouse,
					FamilyTreeConstants.MALE);
			brotherInLaw.append(spousesBrothers);
		}

		// HUSBAND OF SIBLINGS
		String spouseOfSiblings = FamilyTreeCommonBehaviour.getSpouseOfSiblings(person, FamilyTreeConstants.FEMALE);
		brotherInLaw.append(spouseOfSiblings);
		return brotherInLaw.toString();
	}
}
