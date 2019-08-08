package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class Daughter implements FamilyRelation{

	@Override
	public String getRelation(Person person) {
		StringBuilder daughter = new StringBuilder();
		List<Person> children = person.getChildren();
		if(!CollectionUtils.isEmpty(children)) {
			for(Person child : children) {
				if(child.getGender().getGender().equalsIgnoreCase("FEMALE")) {
					daughter.append(child.getPersonName());
					daughter.append(" ");
				}
			}
		}
		return daughter.toString();
	}
}
