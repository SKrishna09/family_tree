package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class SisterInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder sisterInLaw = new StringBuilder();
		Person spouse = person.getSpouse();
		if (null != spouse) {
			Person spousesFather = spouse.getFather();
			List<Person> children = spousesFather.getChildren();
			if (!CollectionUtils.isEmpty(children)) {
				for (Person child : children) {
					if (child.getGender().getGender().equalsIgnoreCase("FEMALE")
							&& !child.getPersonName().equalsIgnoreCase(spouse.getPersonName())) {
						sisterInLaw.append(child.getPersonName());
						sisterInLaw.append(" ");
					}
				}
			}
		}
		return sisterInLaw.toString();
	}
}
