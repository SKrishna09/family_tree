package com.geektrust.familytree.service;

import java.util.List;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;

public class CreateChild {

	public static final String CHILD_ADDITION_SUCCEEDED = "CHILD_ADDITION_SUCCEEDED";
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
	public static final String CHILD_ADDITION_FAILED = "CHILD_ADDITION_FAILED";
	public static final String CHILD_ALREADY_PRESENT = "CHILD_ALREADY_PRESENT";
	public static final String INVALID_GENDER = "INVALID_GENDER";

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
		Person mother = CreateTheShanFamilyTree.familyTree.get(motherName);
		List<Person> children = CreateTheShanFamilyTree.createChildren(childName, gender(childGender),
				mother.getSpouse().getPersonName(), motherName);
		if (children.size() == 1) {
			response = CHILD_ADDITION_SUCCEEDED;
			return response;
		}
		return response;
	}

	public static String validateRequest(String motherName, String childName, String childGender) {
		String response = null;

		// CHECKING FOR EXISTENCE OF MOTHER(REQUESTED PERSON)
		Person mother = null;
		if (CreateTheShanFamilyTree.familyTree.containsKey(motherName)) {
			mother = CreateTheShanFamilyTree.familyTree.get(motherName);
		} else {
			response = PERSON_NOT_FOUND;
			return response;
		}

		// VALIDATING GENDER OF MOTHER(REQUESTED PERSON)
		String motherGender = gender(mother.getGender());
		if (null == motherGender || motherGender.equalsIgnoreCase("MALE")) {
			response = CHILD_ADDITION_FAILED;
			return response;
		}

		// VALIDATING SPOUSE RELATION
		if (null == mother.getSpouse()) {
			response = CHILD_ADDITION_FAILED;
			return response;
		}

		// VALIDATING CHILD ALREADY PRESENT OR NOT
		if (CreateTheShanFamilyTree.familyTree.containsKey(childName)) {
			response = CHILD_ALREADY_PRESENT;
			return response;
		}

		// VALIDATING GENDER OF CHILD
		Gender gender = gender(childGender);
		if (null == gender) {
			response = INVALID_GENDER;
			return response;
		}

		return response;
	}

	public static Gender gender(String gen) {
		Gender g = null;
		if (gen.equalsIgnoreCase("MALE")) {
			g = Gender.MALE;
		} else if (gen.equalsIgnoreCase("FEMALE")) {
			g = Gender.FEMALE;
		}
		return g;
	}

	public static String gender(Gender gen) {
		String g = null;
		if (gen.equals(Gender.MALE)) {
			g = "MALE";
		} else if (gen.equals(Gender.FEMALE)) {
			g = "FEMALE";
		}
		return g;
	}
}
