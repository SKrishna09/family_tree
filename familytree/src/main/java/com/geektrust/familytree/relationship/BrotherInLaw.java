package com.geektrust.familytree.relationship;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.geektrust.familytree.model.Person;

public class BrotherInLaw implements FamilyRelation {

	@Override
	public String getRelation(Person person) {
		StringBuilder brotherInLaw = new StringBuilder();

		// SPOUSE'S BROTHERS
		Person spouse = person.getSpouse();
		if (null != spouse) {
			Person spousesFather = spouse.getFather();
			if (null != spousesFather) {
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
		}

		// HUSBAND OF SIBLINGS
		Person personMother = person.getMother();
		if (null != personMother) {
			List<Person> siblings = personMother.getChildren();
			if (!CollectionUtils.isEmpty(siblings)) {
				for (Person sibling : siblings) {
					if (sibling.getGender().getGender().equalsIgnoreCase("FEMALE")
							&& !sibling.getPersonName().equalsIgnoreCase(person.getPersonName())) {
						Person siblingsSpouse = sibling.getSpouse();
						if (null != siblingsSpouse) {
							brotherInLaw.append(siblingsSpouse.getPersonName());
							brotherInLaw.append(" ");
						}
					}
				}
			}
		}
		return brotherInLaw.toString();
	}
}
