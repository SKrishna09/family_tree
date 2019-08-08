package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.geektrust.familytree.service.CreateChild;

public class TestCreateChild {

	@Test
	public void testCreateChild() {
		String createChild = CreateChild.createChild("ADD_CHILD Chitra Aria Female");
		assertEquals("Add Child", "CHILD_ADDITION_SUCCEEDED", createChild);
	}
}
