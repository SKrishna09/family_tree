package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.geektrust.familytree.service.CreateChild;

public class TestCreateChild extends FamilytreeApplicationTests{

	@Test
	public void testCreateChilAdditionSuccess() {
		String createChild = CreateChild.createChild("ADD_CHILD Chitra Aria Female");
		assertEquals("Add Child", "CHILD_ADDITION_SUCCEEDED", createChild);
	}
	
	@Test
	public void testCreateChildPersonNotFound() {
		String createChild = CreateChild.createChild("ADD_CHILD Pjali Srutak Male");
		assertEquals("Add Child", "PERSON_NOT_FOUND", createChild);
	}
	
	@Test
	public void testCreateChildAdditionFailed() {
		String createChild = CreateChild.createChild("ADD_CHILD Asva Vani Female");
		assertEquals("Add Child", "CHILD_ADDITION_FAILED", createChild);
	}
	
	@Test
	public void testCreateChildInvalidGender() {
		String createChild = CreateChild.createChild("ADD_CHILD Chitra Aria Femalee");
		assertEquals("Add Child", "INVALID_GENDER", createChild);
	}
	
	@Test
	public void testCreateChildAlreadyPresent() {
		String createChild = CreateChild.createChild("ADD_CHILD Krpi Kriya Female");
		assertEquals("Add Child", "CHILD_ALREADY_PRESENT", createChild);
	}
	
	@Test
	public void testCreateChildFatherExistence() {
		String createChild = CreateChild.createChild("ADD_CHILD Tritha Kritha Female");
		assertEquals("Add Child", "CHILD_ADDITION_FAILED", createChild);
	}
}
