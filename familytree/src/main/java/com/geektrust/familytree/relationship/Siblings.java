package com.geektrust.familytree.relationship;

import java.util.List;

import com.geektrust.familytree.model.Person;

public class Siblings implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder siblings = new StringBuilder();
		Person mother = person.getMother();
		if (null != mother) {
			List<Person> children = mother.getChildren();
			for (Person child : children) {
				if (!child.getPersonName().equalsIgnoreCase(person.getPersonName())) {
					siblings.append(child.getPersonName());
					siblings.append(" ");
				}
			}
		}
		return siblings.toString();
	}
}
