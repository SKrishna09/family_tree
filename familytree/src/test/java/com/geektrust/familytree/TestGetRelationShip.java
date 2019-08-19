package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.geektrust.familytree.service.GetRelationship;

public class TestGetRelationShip extends FamilytreeApplicationTests {

	@Test
	public void testGetRelationshipPaternalUncle() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Kriya Paternal-Uncle");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Asva"));
	}

	@Test
	public void testGetRelationshipMaternalUncle() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Laki Maternal-Uncle");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Ahit"));
	}

	@Test
	public void testGetRelationshipPaternalAunt() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Kriya Paternal-Aunt");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Atya"));
	}

	@Test
	public void testGetRelationshipMaternalAunt() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Yodhan Maternal-Aunt");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Tritha"));
	}

	@Test
	public void testGetRelationshipSisterInLaw() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Atya Sister-In-Law");
		assertTrue("Get Relationship",
				relation.equalsIgnoreCase("Krpi Satvy") || relation.equalsIgnoreCase("Satvy Krpi"));
	}

	@Test
	public void testGetRelationshipBrotherInLaw() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Satvy Brother-In-Law");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Vyas"));
	}

	@Test
	public void testGetRelationshipSon() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Dritha Son");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Yodhan"));
	}

	@Test
	public void testGetRelationshipDaughter() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Krpi Daughter");
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Krithi"));
	}

	@Test
	public void testGetRelationshipSiblings() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Dritha Siblings");
		assertTrue("Get Relationship",
				relation.equalsIgnoreCase("Tritha Vritha") || relation.equalsIgnoreCase("Vritha Tritha"));
	}

	@Test
	public void testGetNoRelationship() {
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
