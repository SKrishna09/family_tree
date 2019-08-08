package com.geektrust.familytree.service;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.relationship.BrotherInLaw;
import com.geektrust.familytree.relationship.Daughter;
import com.geektrust.familytree.relationship.MaternalAunt;
import com.geektrust.familytree.relationship.MaternalUncle;
import com.geektrust.familytree.relationship.PaternalAunt;
import com.geektrust.familytree.relationship.PaternalUncle;
import com.geektrust.familytree.relationship.RelationshipContext;
import com.geektrust.familytree.relationship.Siblings;
import com.geektrust.familytree.relationship.SisterInLaw;
import com.geektrust.familytree.relationship.Son;

public class GetRelationship {
	public static String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";

	public static void getRelationship(String request) {
		String[] reqArray = request.split(" ");

		if (reqArray.length != 3) {
			System.out.println(PERSON_NOT_FOUND);
			return;
		}

		String personName = reqArray[1];

		Person person = null;
		if (CreateTheShanFamilyTree.familyTree.containsKey(personName)) {
			person = CreateTheShanFamilyTree.familyTree.get(personName);
		} else {
			System.out.println(PERSON_NOT_FOUND);
			return;
		}

		String relationshipType = reqArray[2];

		RelationshipContext rsc = new RelationshipContext();
		relationshipType = relationshipType.toLowerCase();

		switch (relationshipType) {
		case "paternal-uncle":
			rsc.setRelation(new PaternalUncle());
			rsc.getRelation(person);
			break;
		case "maternal-uncle":
			rsc.setRelation(new MaternalUncle());
			rsc.getRelation(person);
			break;
		case "paternal-aunt":
			rsc.setRelation(new PaternalAunt());
			rsc.getRelation(person);
			break;
		case "maternal-aunt":
			rsc.setRelation(new MaternalAunt());
			rsc.getRelation(person);
			break;
		case "sister-in-law":
			rsc.setRelation(new SisterInLaw());
			rsc.getRelation(person);
			break;
		case "brother-in-law":
			rsc.setRelation(new BrotherInLaw());
			rsc.getRelation(person);
			break;
		case "son":
			rsc.setRelation(new Son());
			rsc.getRelation(person);
			break;
		case "daughter":
			rsc.setRelation(new Daughter());
			rsc.getRelation(person);
			break;
		case "siblings":
			rsc.setRelation(new Siblings());
			rsc.getRelation(person);
			break;
		default:
			System.out.println(PERSON_NOT_FOUND);
		}
	}
}
