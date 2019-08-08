package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class BrotherInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder brotherInLaw = new StringBuilder();
		Person spouse = person.getSpouse();
		if (null != spouse) {
			Person spousesFather = spouse.getFather();
			List<Person> children = spousesFather.getChildren();
			if (!CollectionUtils.isEmpty(children)) {
				for (Person child : children) {
					if (child.getGender().getGender().equalsIgnoreCase("MALE")
							&& !child.getPersonName().equalsIgnoreCase(spouse.getPersonName())) {
						brotherInLaw.append(child.getPersonName());
						brotherInLaw.append(" ");
					}
				}
			}
		}
		return brotherInLaw.toString();
	}
}
