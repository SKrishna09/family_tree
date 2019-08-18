package com.geektrust.familytree.relationship;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class MaternalAunt implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		String maternalAunt = null;
		Person mother = person.getMother();
		if (null != mother) {
			maternalAunt = FamilyTreeCommonBehaviour.getPersonsGenderSpecificSiblings(mother,
					FamilyTreeConstants.FEMALE);
		}
		return maternalAunt;
	}
}
