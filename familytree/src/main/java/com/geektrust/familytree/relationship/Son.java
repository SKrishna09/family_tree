package com.geektrust.familytree.relationship;

import org.springframework.beans.factory.annotation.Autowired;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class Son implements FamilyRelation {

	@Autowired
	FamilyTreeCommonBehaviour common;

	@Override
	public String getRelation(Person person) {
		return common.getPersonsGenderSpecificChildren(person, FamilyTreeConstants.MALE);
	}
}
