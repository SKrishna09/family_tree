package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class SisterInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder sisterInLaw = new StringBuilder();

		// SPOUSE'S SISTERS
		Person spouse = person.getSpouse();
		if (null != spouse) {
			Person spousesFather = spouse.getFather();
			if (null != spousesFather) {
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
		}

		// WIVES OF SIBLINGS
		Person personMother = person.getMother();
		if (null != personMother) {
			List<Person> siblings = personMother.getChildren();
			if (!CollectionUtils.isEmpty(siblings)) {
				for (Person sibling : siblings) {
					if (sibling.getGender().getGender().equalsIgnoreCase("MALE")
							&& !sibling.getPersonName().equalsIgnoreCase(person.getPersonName())) {
						Person siblingsSpouse = sibling.getSpouse();
						if (null != siblingsSpouse) {
							sisterInLaw.append(siblingsSpouse.getPersonName());
							sisterInLaw.append(" ");
						}
					}
				}
			}
		}
		return sisterInLaw.toString();
	}
}
