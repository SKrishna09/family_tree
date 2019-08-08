package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class MaternalAunt implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder maternalAunt = new StringBuilder();
		Person mother = person.getMother();
		if (null != mother) {
			Person mothersFather = mother.getFather();
			if (null != mothersFather) {
				List<Person> children = mothersFather.getChildren();
				if (!CollectionUtils.isEmpty(children)) {
					for (Person child : children) {
						if (child.getGender().getGender().equalsIgnoreCase("FEMALE")
								&& !child.getPersonName().equalsIgnoreCase(mother.getPersonName())) {
							maternalAunt.append(child.getPersonName());
							maternalAunt.append(" ");
						}
					}
				}
			}
		}
		return maternalAunt.toString();
	}
}
