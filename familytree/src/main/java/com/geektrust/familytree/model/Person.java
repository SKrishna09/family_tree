package com.geektrust.familytree.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Person {
	private String personName;
	private Gender gender;
	private Person spouse;
	private Person father;
	private Person mother;
	private List<Person> children;

	public String getPersonName() {
		return personName;
	}

	public Gender getGender() {
		return gender;
	}

	public Person getSpouse() {
		return spouse;
	}

	public Person getFather() {
		return father;
	}

	public Person getMother() {
		return mother;
	}

	public List<Person> getChildren() {
		return children;
	}

	public Person(String personName, Gender gender) {
		this.personName = personName;
		this.gender = gender;
	}

	public Person(String personName, Gender gender, Person father, Person mother) {
		this.personName = personName;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
	}

	public void addChild(Person child) {
		if (CollectionUtils.isEmpty(children)) {
			children = new ArrayList<>();
		}
		children.add(child);
	}

	public void addSpouse(Person spouse) {
		this.spouse = spouse;
	}
}
