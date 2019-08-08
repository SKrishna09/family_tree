package com.geektrust.familytree.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.model.Person;

public class CreateTheShanFamilyTree {

	public static Map<String, Person> familyTree = new LinkedHashMap<>();

	public static void createTheShanFamliyTree() {
		List<String> mc = new ArrayList<>();
		mc.add("Chit");
		mc.add("Ish");
		mc.add("Vich");
		mc.add("Aras");
		List<String> fc = new ArrayList<>();
		fc.add("Satya");
		addMember("King Shan", Gender.MALE, "Queen Anga", null, null, mc, fc);
		mc.clear();
		fc.clear();
		mc.add("Vritha");
		fc.add("Dritha");
		fc.add("Tritha");
		addMember("Chit", Gender.MALE, "Amba", "King Shan", "Queen Anga", mc, fc);
		mc.clear();
		fc.clear();
		mc.add("Yodhan");
		addMember("Dritha", Gender.FEMALE, "Jaya", "Chit", "Amba", mc, fc);
		mc.clear();
		fc.add("Vila");
		fc.add("Chika");
		addMember("Vich", Gender.MALE, "Lika", "King Shan", "Queen Anga", mc, fc);
		fc.clear();
		mc.add("Ahit");
		fc.add("Jnki");
		addMember("Aras", Gender.MALE, "Chitra", "King Shan", "Queen Anga", mc, fc);
		mc.clear();
		fc.clear();
		mc.add("Laki");
		fc.add("Lavnya");
		addMember("Jnki", Gender.FEMALE, "Arit", "Aras", "Chitra", mc, fc);
		mc.clear();
		fc.clear();
		mc.add("Asva");
		mc.add("Vyas");
		fc.add("Atya");
		addMember("Satya", Gender.FEMALE, "Vyan", "King Shan", "Queen Anga", mc, fc);
		mc.clear();
		fc.clear();
		mc.add("Vasa");
		addMember("Asva", Gender.MALE, "Satvy", "Satya", "Vyan", mc, fc);
		mc.clear();
		mc.add("Kriya");
		fc.add("Krithi");
		addMember("Vyas", Gender.MALE, "Krpi", "Satya", "Vyan", mc, fc);
		mc.clear();
		fc.clear();
		System.out.println(familyTree.keySet());
	}

	public static void addMember(String personName, Gender gender, String spouseName, String father, String mother,
			List<String> maleChildren, List<String> femaleChildren) {
		Person person = null;
		if (familyTree.containsKey(personName)) {
			person = familyTree.get(personName);
		} else {
			person = new Person();
			person.setPersonName(personName);
			familyTree.put(personName, person);
			if (null != father) {
				person.setFather(familyTree.get(father));
			}
			if (null != mother) {
				person.setMother(familyTree.get(mother));
			}
		}
		if (null != spouseName && null == person.getSpouse()) {
			String personGender = gender.getGender();
			person.setSpouse(createSpouse(personName, spouseName, invertedGender(personGender)));
		}
		if (null != maleChildren || null != femaleChildren) {
			String childsFather;
			String childsMother;
			if (gender.getGender().equalsIgnoreCase("MALE")) {
				childsFather = personName;
				childsMother = spouseName;
			} else {
				childsFather = spouseName;
				childsMother = personName;
			}
			if (null != maleChildren) {
				createChildren(maleChildren, Gender.MALE, childsFather, childsMother);
			}
			if (null != femaleChildren) {
				createChildren(femaleChildren, Gender.FEMALE, childsFather, childsMother);
			}
		}

	}

	public static Person createSpouse(String personName, String spouseName, Gender spouseGender) {
		Person spouse = null;
		if (familyTree.containsKey(personName)) {
			spouse = new Person();
			Person person = familyTree.get(personName);
			spouse.setPersonName(spouseName);
			spouse.setGender(spouseGender);

			person.setSpouse(spouse);
			spouse.setSpouse(person);
			familyTree.put(spouseName, spouse);
		}
		return spouse;
	}

	public static List<Person> createChildren(String children, Gender gender, String father, String mother) {
		List<String> childrenList = new ArrayList<>();
		childrenList.add(children);
		return createChildren(childrenList, gender, father, mother);
	}

	public static List<Person> createChildren(List<String> children, Gender gender, String father, String mother) {
		List<Person> childrenList = new ArrayList<>();
		for (String childName : children) {
			Person child = null;
			if (familyTree.containsKey(childName)) {
				child = familyTree.get(childName);
			} else {
				child = new Person();
				child.setPersonName(childName);
			}
			child.setGender(gender);
			if (null != father) {
				child.setFather(familyTree.get(father));
			}
			if (null != mother) {
				child.setMother(familyTree.get(mother));
			}
			childrenList.add(child);
			familyTree.put(childName, child);
			if (null != mother && null != father) {
				addChildToParent(father, mother, child);
			}
		}
		return childrenList;
	}

	public static void addChildToParent(String fatherName, String motherName, Person child) {
		Person father = null;
		if (familyTree.containsKey(fatherName)) {
			father = familyTree.get(fatherName);
			List<Person> childrens = father.getChildren();
			if (CollectionUtils.isEmpty(childrens)) {
				childrens = new ArrayList<>();
			}
			childrens.add(child);
			father.setChildren(childrens);
		}
		Person mother = null;
		if (familyTree.containsKey(motherName)) {
			mother = familyTree.get(motherName);
			List<Person> childrens = mother.getChildren();
			if (CollectionUtils.isEmpty(childrens)) {
				childrens = new ArrayList<>();
			}
			childrens.add(child);
			mother.setChildren(childrens);
		}
	}

	private static Gender invertedGender(String gender) {
		Gender invertedGender = null;
		if (gender.equalsIgnoreCase("MALE")) {
			invertedGender = Gender.FEMALE;
		} else if (gender.equalsIgnoreCase("FEMALE")) {
			invertedGender = Gender.MALE;
		}
		return invertedGender;
	}
}
