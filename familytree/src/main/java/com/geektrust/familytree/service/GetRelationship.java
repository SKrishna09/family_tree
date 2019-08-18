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
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class GetRelationship {

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
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap(personName);
		response = getRelation(relationshipType, person);
		if (null == response || response.isEmpty()) {
			response = FamilyTreeConstants.NONE;
		}
		return response;
	}

	public static String validateRequest(String personName) {
		String response = null;

		// CHECKING FOR EXISTENCE OF PERSON
		if (null == TheShanFamilyTree.getPersonFromFamilyTreeMap(personName)) {
			response = FamilyTreeConstants.PERSON_NOT_FOUND;
			return response;
		}

		return response;
	}

	public static String getRelation(String relationshipType, Person person) {
		RelationshipContext rsc = new RelationshipContext();
		relationshipType = relationshipType.toLowerCase();

		String response = null;
		switch (relationshipType) {
		case FamilyTreeConstants.PATERNAL_UNCLE:
			rsc.setRelation(new PaternalUncle());
			break;
		case FamilyTreeConstants.MATERNAL_UNCLE:
			rsc.setRelation(new MaternalUncle());
			break;
		case FamilyTreeConstants.PATERNAL_AUNT:
			rsc.setRelation(new PaternalAunt());
			break;
		case FamilyTreeConstants.MATERNAL_AUNT:
			rsc.setRelation(new MaternalAunt());
			break;
		case FamilyTreeConstants.SISTER_IN_LAW:
			rsc.setRelation(new SisterInLaw());
			break;
		case FamilyTreeConstants.BROTHER_IN_LAW:
			rsc.setRelation(new BrotherInLaw());
			break;
		case FamilyTreeConstants.SON:
			rsc.setRelation(new Son());
			break;
		case FamilyTreeConstants.DAUGHTER:
			rsc.setRelation(new Daughter());
			break;
		case FamilyTreeConstants.SIBLINGS:
			rsc.setRelation(new Siblings());
			break;
		default:
			response = FamilyTreeConstants.INVALID_RELATION;
			return response;
		}
		response = rsc.getRelation(person);
		return response;
	}
}
