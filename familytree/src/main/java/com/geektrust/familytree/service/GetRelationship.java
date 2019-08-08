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
	public static final String INVALID_RELATION = "INVALID_RELATION";

	public static String getRelationship(String request) {
		String response = null;

		// ONLY ACCEPTING FIRST 2 PARAMETERS TO GET RELATIONSHIP
		String[] reqArray = request.split(" ");
		String personName = reqArray[1];
		String relationshipType = reqArray[2];

		response = validateRequest(personName);
		if (null != response) {
			return response;
		}

		// GET RELATION
		Person person = CreateTheShanFamilyTree.familyTree.get(personName);
		response = getRelation(relationshipType, person);
		if (null == response || response.isEmpty()) {
			response = "NONE";
		}
		return response;
	}

	public static String validateRequest(String personName) {
		String response = null;

		// CHECKING FOR EXISTENCE OF PERSON
		if (!CreateTheShanFamilyTree.familyTree.containsKey(personName)) {
			response = PERSON_NOT_FOUND;
			return response;
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
			break;
		case "maternal-uncle":
			rsc.setRelation(new MaternalUncle());
			break;
		case "paternal-aunt":
			rsc.setRelation(new PaternalAunt());
			break;
		case "maternal-aunt":
			rsc.setRelation(new MaternalAunt());
			break;
		case "sister-in-law":
			rsc.setRelation(new SisterInLaw());
			break;
		case "brother-in-law":
			rsc.setRelation(new BrotherInLaw());
			break;
		case "son":
			rsc.setRelation(new Son());
			break;
		case "daughter":
			rsc.setRelation(new Daughter());
			break;
		case "siblings":
			rsc.setRelation(new Siblings());
			break;
		default:
			response = INVALID_RELATION;
			return response;
		}
		response = rsc.getRelation(person);
		return response;
	}
}
