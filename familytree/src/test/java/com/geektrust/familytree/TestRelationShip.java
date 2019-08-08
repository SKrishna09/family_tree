package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.geektrust.familytree.service.GetRelationship;

public class TestRelationShip {

	@Test
	public void testGetRelationship() {
		String relation = GetRelationship.getRelationship("GET_RELATIONSHIP Aria Siblings");
		assertEquals("Get Relationship", "Ahit Janki", relation);
	}
}
