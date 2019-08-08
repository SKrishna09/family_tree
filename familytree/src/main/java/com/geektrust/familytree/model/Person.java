package com.geektrust.familytree.model;

import java.util.List;

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

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", gender=" + gender + ", spouse=" + spouse + ", father=" + father
				+ ", mother=" + mother + ", children=" + children + ", getPersonName()=" + getPersonName()
				+ ", getGender()=" + getGender() + ", getSpouse()=" + getSpouse() + ", getFather()=" + getFather()
				+ ", getMother()=" + getMother() + ", getChildren()=" + getChildren() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
