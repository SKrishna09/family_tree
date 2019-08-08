package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class Son implements FamilyRelation{

	@Override
	public String getRelation(Person person) {
		StringBuilder son = new StringBuilder();
		List<Person> children = person.getChildren();
		if(!CollectionUtils.isEmpty(children)) {
			for(Person child : children) {
				if(child.getGender().getGender().equalsIgnoreCase("MALE")) {
					son.append(child.getPersonName());
					son.append(" ");
				}
			}
		}
		return son.toString();
	}
}
