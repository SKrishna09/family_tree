package com.geektrust.familytree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class FamilyTreeCommonBehaviour {

	public static List<Person> personsGenderSpecificSiblings(Person person, String gender) {
		List<Person> siblings = new ArrayList<>();
		Person personsFather = person.getFather();
		if (null != personsFather) {
			List<Person> children = personsFather.getChildren();
			if (!CollectionUtils.isEmpty(children)) {
				for (Person child : children) {
					if (child.getGender().getGender().equalsIgnoreCase(gender)
							&& !child.getPersonName().equalsIgnoreCase(person.getPersonName())) {
						siblings.add(child);
					}
				}
			}
		}
		return siblings;
	}

	public static String getPersonsGenderSpecificSiblings(Person person, String gender) {
		return personName(personsGenderSpecificSiblings(person, gender));
	}

	public static List<Person> personsGenderSpecificChildren(Person person, String gender) {
		List<Person> childrens = new ArrayList<>();
		List<Person> children = person.getChildren();
		if (!CollectionUtils.isEmpty(children)) {
			for (Person child : children) {
				if (child.getGender().getGender().equalsIgnoreCase(gender)) {
					childrens.add(child);
				}
			}
		}
		return childrens;
	}

	public static String getPersonsGenderSpecificChildren(Person person, String gender) {
		return personName(personsGenderSpecificChildren(person, gender));
	}

	public static List<Person> spouseOfSiblings(Person person, String gender) {
		List<Person> spouse = new ArrayList<>();
		List<Person> siblings = personsGenderSpecificSiblings(person, gender);
		if (!CollectionUtils.isEmpty(siblings)) {
			for (Person sibling : siblings) {
				Person siblingsSpouse = sibling.getSpouse();
				if (null != siblingsSpouse) {
					spouse.add(siblingsSpouse);
				}
			}
		}
		return spouse;
	}

	public static String getSpouseOfSiblings(Person person, String gender) {
		return personName(spouseOfSiblings(person, gender));
	}

	public static String personName(List<Person> personList) {
		StringBuilder person = new StringBuilder();
		for (Person p : personList) {
			person.append(p.getPersonName());
			person.append(" ");
		}
		return person.toString();
	}

	public static Gender gender(String gen) {
		Gender g = null;
		if (gen.equalsIgnoreCase(FamilyTreeConstants.MALE)) {
			g = Gender.MALE;
		} else if (gen.equalsIgnoreCase(FamilyTreeConstants.FEMALE)) {
			g = Gender.FEMALE;
		}
		return g;
	}

	public static String gender(Gender gen) {
		String g = null;
		if (gen.equals(Gender.MALE)) {
			g = FamilyTreeConstants.MALE;
		} else if (gen.equals(Gender.FEMALE)) {
			g = FamilyTreeConstants.FEMALE;
		}
		return g;
	}

	public static Gender invertedGender(String gender) {
		Gender invertedGender = null;
		if (gender.equalsIgnoreCase(FamilyTreeConstants.MALE)) {
			invertedGender = Gender.FEMALE;
		} else if (gender.equalsIgnoreCase(FamilyTreeConstants.FEMALE)) {
			invertedGender = Gender.MALE;
		}
		return invertedGender;
	}

	public static Gender invertedGender(Gender gender) {
		Gender invertedGender = null;
		if (gender.equals(Gender.MALE)) {
			invertedGender = Gender.FEMALE;
		} else if (gender.equals(Gender.FEMALE)) {
			invertedGender = Gender.MALE;
		}
		return invertedGender;
	}
}
