package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class PaternalUncle implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder paternalUncle = new StringBuilder();
		Person father = person.getFather();
		if (null != father) {
			Person fathersFather = father.getFather();
			if (null != fathersFather) {
				List<Person> children = fathersFather.getChildren();
				if (!CollectionUtils.isEmpty(children)) {
					for (Person child : children) {
						if (child.getGender().getGender().equalsIgnoreCase("MALE")
								&& !child.getPersonName().equalsIgnoreCase(father.getPersonName())) {
							paternalUncle.append(child.getPersonName());
							paternalUncle.append(" ");
						}
					}
				}
			}
		}
		return paternalUncle.toString();
	}

}
