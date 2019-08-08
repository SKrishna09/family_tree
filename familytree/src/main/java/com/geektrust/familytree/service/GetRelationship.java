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
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";

	public static String getRelationship(String request) {
		String response = null;
		String[] reqArray = request.split(" ");

		if (reqArray.length != 3) {
			response = PERSON_NOT_FOUND;
			return response;
		}

		String personName = reqArray[1];

		Person person = null;
		if (CreateTheShanFamilyTree.familyTree.containsKey(personName)) {
			person = CreateTheShanFamilyTree.familyTree.get(personName);
		} else {
			response = PERSON_NOT_FOUND;
			return response;
		}

		String relationshipType = reqArray[2];

		response = getRelation(relationshipType, person);
		if (null == response || response.isEmpty()) {
			response = "NONE";
		}
		return response;
	}

	public static String getRelation(String relationshipType, Person person) {
		RelationshipContext rsc = new RelationshipContext();
		relationshipType = relationshipType.toLowerCase();

		String response = null;
		switch (relationshipType) {
		case "paternal-uncle":
			rsc.setRelation(new PaternalUncle());
			response = rsc.getRelation(person);
			break;
		case "maternal-uncle":
			rsc.setRelation(new MaternalUncle());
			response = rsc.getRelation(person);
			break;
		case "paternal-aunt":
			rsc.setRelation(new PaternalAunt());
			response = rsc.getRelation(person);
			break;
		case "maternal-aunt":
			rsc.setRelation(new MaternalAunt());
			response = rsc.getRelation(person);
			break;
		case "sister-in-law":
			rsc.setRelation(new SisterInLaw());
			response = rsc.getRelation(person);
			break;
		case "brother-in-law":
			rsc.setRelation(new BrotherInLaw());
			response = rsc.getRelation(person);
			break;
		case "son":
			rsc.setRelation(new Son());
			response = rsc.getRelation(person);
			break;
		case "daughter":
			rsc.setRelation(new Daughter());
			response = rsc.getRelation(person);
			break;
		case "siblings":
			rsc.setRelation(new Siblings());
			response = rsc.getRelation(person);
			break;
		default:
			response = PERSON_NOT_FOUND;
		}
		return response;
	}
}
