package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class PaternalAunt implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder paternalAunt = new StringBuilder();
		Person father = person.getFather();
		if (null != father) {
			Person fathersFather = father.getFather();
			if (null != fathersFather) {
				List<Person> children = fathersFather.getChildren();
				if (!CollectionUtils.isEmpty(children)) {
					for (Person child : children) {
						if (child.getGender().getGender().equalsIgnoreCase("FEMALE")) {
							paternalAunt.append(child.getPersonName());
							paternalAunt.append(" ");
						}
					}
				}
			}
		}
		return paternalAunt.toString();
	}
}
