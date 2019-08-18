package com.geektrust.familytree.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.geektrust.familytree.model.Person;

public class TheShanFamilyTree {

	protected static Map<String, Person> familyTree = new LinkedHashMap<>();

	public static Person addMemberToFamily(String personName, String gender) {
		Person member = null;
		if (familyTree.containsKey(personName)) {
			member = familyTree.get(personName);
		} else {
			member = new Person(personName, FamilyTreeCommonBehaviour.gender(gender));
			familyTree.put(personName, member);
		}
		return member;
	}

	public static Person createChildren(String children, String gender, String mother) {
		Person child = null;
		Person pMother = getPersonFromFamilyTreeMap(mother);
		if (null != pMother) {
			Person pFather = pMother.getSpouse();
			if (familyTree.containsKey(children)) {
				child = familyTree.get(children);
			} else {
				child = new Person(children, FamilyTreeCommonBehaviour.gender(gender), pFather, pMother);
				familyTree.put(children, child);
			}
			pMother.addChild(child);
			if (null != pFather)
				pFather.addChild(child);
		}
		return child;
	}

	public static Person createSpouse(String personName, String spouseName) {
		Person spouse = null;
		Person person = getPersonFromFamilyTreeMap(personName);
		if (null != person) {
			spouse = getPersonFromFamilyTreeMap(spouseName);
			if (null == spouse) {
				spouse = addMemberToFamily(spouseName,
						FamilyTreeCommonBehaviour.gender(FamilyTreeCommonBehaviour.invertedGender(person.getGender())));
			}
			spouse.addSpouse(person);
			person.addSpouse(spouse);
		}
		return spouse;
	}

	public static Person getPersonFromFamilyTreeMap(String person) {
		Person pPerson = null;
		if (familyTree.containsKey(person))
			pPerson = familyTree.get(person);
		return pPerson;
	}

	public static void familyTree() {
		System.out.println(familyTree.keySet());
	}
}
