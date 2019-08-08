package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.geektrust.familytree.service.GetRelationship;

public class TestRelationShip extends FamilytreeApplicationTests {

	@Test
	public void testGetRelationshipResult() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Atya Sister-In-Law");
		assertTrue("Get Relationship",
				relation.equalsIgnoreCase("Krpi Satvy") || relation.equalsIgnoreCase("Satvy Krpi"));
	}

	@Test
	public void testGetRelationshipNone() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Vasa Siblings");
		assertEquals("Get Relationship", "NONE", relation);
	}
	
	@Test
	public void testGetRelationshipPersonNotFound() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Pjali Son");
		assertEquals("Get Relationship", "PERSON_NOT_FOUND", relation);
	}
	
	@Test
	public void testGetRelationshipInvalidRelation() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Vasa Sons");
		assertEquals("Get Relationship", "INVALID_RELATION", relation);
	}
}
