package com.geektrust.familytree.service;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class CreateChild {

	public static String createChild(String request) {
		String response = null;

		// ONLY ACCEPTING FIRST 3 PARAMETERS TO CREATE CHILD
		String[] reqArray = request.split(" ");
		String motherName = reqArray[1];
		String childName = reqArray[2];
		String childGender = reqArray[3];

		response = validateRequest(motherName, childName, childGender);
		if (null != response) {
			return response;
		}

		// CREATE CHILD
		Person children = TheShanFamilyTree.createChildren(childName, childGender, motherName);
		if (null == children) {
			response = FamilyTreeConstants.CHILD_ADDITION_FAILED;
		} else {
			response = FamilyTreeConstants.CHILD_ADDITION_SUCCEEDED;
		}
		return response;
	}

	public static String validateRequest(String motherName, String childName, String childGender) {
		String response = null;

		// CHECKING FOR EXISTENCE OF MOTHER(REQUESTED PERSON)
		Person mother = TheShanFamilyTree.getPersonFromFamilyTreeMap(motherName);
		if (null == mother) {
			response = FamilyTreeConstants.PERSON_NOT_FOUND;
			return response;
		}

		// VALIDATING GENDER OF MOTHER(REQUESTED PERSON)
		String motherGender = FamilyTreeCommonBehaviour.gender(mother.getGender());
		if (null == motherGender || motherGender.equalsIgnoreCase(FamilyTreeConstants.MALE)) {
			response = FamilyTreeConstants.CHILD_ADDITION_FAILED;
			return response;
		}

		// VALIDATING SPOUSE RELATION
		if (null == mother.getSpouse()) {
			response = FamilyTreeConstants.CHILD_ADDITION_FAILED;
			return response;
		}

		// VALIDATING CHILD ALREADY PRESENT OR NOT
		Person child = TheShanFamilyTree.getPersonFromFamilyTreeMap(childName);
		if (null != child) {
			response = FamilyTreeConstants.CHILD_ALREADY_PRESENT;
			return response;
		}

		// VALIDATING GENDER OF CHILD
		Gender gender = FamilyTreeCommonBehaviour.gender(childGender);
		if (null == gender) {
			response = FamilyTreeConstants.INVALID_GENDER;
			return response;
		}
		return response;
	}
}
