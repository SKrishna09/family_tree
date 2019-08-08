package com.geektrust.familytree.service;

import java.util.List;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;

public class CreateChild {

	public static final String CHILD_ADDITION_SUCCEEDED = "CHILD_ADDITION_SUCCEEDED";
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
	public static final String CHILD_ADDITION_FAILED = "CHILD_ADDITION_FAILED";

	public static String createChild(String request) {
		String response = null;
		String[] reqArray = request.split(" ");

		if (reqArray.length != 4) {
			response = CHILD_ADDITION_FAILED;
			return response;
		}

		String motherName = reqArray[1];

		Person mother = null;
		if (CreateTheShanFamilyTree.familyTree.containsKey(motherName)) {
			mother = CreateTheShanFamilyTree.familyTree.get(motherName);
		} else {
			response = PERSON_NOT_FOUND;
			return response;
		}

		if (gender(mother.getGender()).equalsIgnoreCase("MALE")) {
			response = CHILD_ADDITION_FAILED;
			return response;
		}

		String childName = reqArray[2];
		String childGender = reqArray[3];

		if (CreateTheShanFamilyTree.familyTree.containsKey(childName)) {
			response = CHILD_ADDITION_FAILED;
			return response;
		}

		List<Person> children = CreateTheShanFamilyTree.createChildren(childName, gender(childGender),
				mother.getSpouse().getPersonName(), motherName);
		if (children.size() == 1) {
			response = CHILD_ADDITION_SUCCEEDED;
			return response;
		}
		return response;
	}

	public static Gender gender(String gen) {
		Gender g = null;
		if (gen.equalsIgnoreCase("MALE")) {
			g = Gender.MALE;
		} else {
			g = Gender.FEMALE;
		}
		return g;
	}

	public static String gender(Gender gen) {
		String g = null;
		if (gen.equals(Gender.MALE)) {
			g = "MALE";
		} else {
			g = "FEMALE";
		}
		return g;
	}
}
