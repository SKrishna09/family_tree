package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class MaternalUncle implements FamilyRelation{

	@Override
	public String getRelation(Person person) {
		StringBuilder maternalUncle = new StringBuilder();
		Person mother = person.getMother();
		if (null != mother) {
			Person mothersFather = mother.getFather();
			if (null != mothersFather) {
				List<Person> children = mothersFather.getChildren();
				if (!CollectionUtils.isEmpty(children)) {
					for (Person child : children) {
						if (child.getGender().getGender().equalsIgnoreCase("MALE")) {
							maternalUncle.append(child.getPersonName());
							maternalUncle.append(" ");
						}
					}
				}
			}
		}
		return maternalUncle.toString();
	}

}
