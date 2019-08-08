package com.geektrust.familytree.service;

import java.util.List;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;

public class CreateChild {

	public static final String CHILD_ADDITION_SUCCEEDED = "CHILD_ADDITION_SUCCEEDED";
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
	public static final String CHILD_ADDITION_FAILED = "CHILD_ADDITION_FAILED";

	public static void createChild(String request) {
		String[] reqArray = request.split(" ");

		if (reqArray.length != 4) {
			System.out.println(CHILD_ADDITION_FAILED);
			return;
		}

		String motherName = reqArray[1];

		Person mother = null;
		if (CreateTheShanFamilyTree.familyTree.containsKey(motherName)) {
			mother = CreateTheShanFamilyTree.familyTree.get(motherName);
		} else {
			System.out.println(PERSON_NOT_FOUND);
			return;
		}

		if (gender(mother.getGender()).equalsIgnoreCase("MALE")) {
			System.out.println(CHILD_ADDITION_FAILED);
			return;
		}

		String childName = reqArray[2];
		String childGender = reqArray[3];

		if (CreateTheShanFamilyTree.familyTree.containsKey(childName)) {
			System.out.println(CHILD_ADDITION_FAILED);
			return;
		}

		List<Person> children = CreateTheShanFamilyTree.createChildren(childName, gender(childGender),
				mother.getSpouse().getPersonName(), motherName);
		if (children.size() == 1) {
			System.out.println(CHILD_ADDITION_SUCCEEDED);
			return;
		}
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
