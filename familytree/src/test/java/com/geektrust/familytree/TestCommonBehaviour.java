package com.geektrust.familytree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.geektrust.familytree.model.Gender;
import com.geektrust.familytree.service.FamilyTreeCommonBehaviour;
import com.geektrust.familytree.utility.FamilyTreeConstants;

public class TestCommonBehaviour extends FamilytreeApplicationTests {

	@Test
	public void testInvertedGenderMale() {
		Gender gender = FamilyTreeCommonBehaviour.invertedGender(Gender.MALE);
		assertTrue("Gender", gender.getGender().equalsIgnoreCase(FamilyTreeConstants.FEMALE));
	}

	@Test
	public void testInvertedGenderStringTypeMale() {
		Gender gender = FamilyTreeCommonBehaviour.invertedGender(FamilyTreeConstants.MALE);
		assertTrue("Gender", gender.getGender().equalsIgnoreCase(FamilyTreeConstants.FEMALE));
	}
	
	@Test
	public void testInvertedGenderFemale() {
		Gender gender = FamilyTreeCommonBehaviour.invertedGender(Gender.FEMALE);
		assertTrue("Gender", gender.getGender().equalsIgnoreCase(FamilyTreeConstants.MALE));
	}

	@Test
	public void testInvertedGenderStringTypeFemale() {
		Gender gender = FamilyTreeCommonBehaviour.invertedGender(FamilyTreeConstants.FEMALE);
		assertTrue("Gender", gender.getGender().equalsIgnoreCase(FamilyTreeConstants.MALE));
	}

}
