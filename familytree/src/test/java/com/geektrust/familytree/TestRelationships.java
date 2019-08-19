package com.geektrust.familytree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.geektrust.familytree.model.Person;
import com.geektrust.familytree.service.GetRelationship;
import com.geektrust.familytree.service.TheShanFamilyTree;

public class TestRelationships extends FamilytreeApplicationTests {

	@Test
	public void relationshipPaternalUncle() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Kriya");
		String relation = GetRelationship.getRelation("Paternal-Uncle", person);
		assertTrue("Relationship", relation.equalsIgnoreCase("Asva"));
	}

	@Test
	public void relationshipMaternalUncle() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Laki");
		String relation = GetRelationship.getRelation("Maternal-Uncle", person);
		assertTrue("Relationship", relation.equalsIgnoreCase("Ahit"));
	}

	@Test
	public void relationshipPaternalAunt() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Kriya");
		String relation = GetRelationship.getRelation("Paternal-Aunt", person);
		assertTrue("Relationship", relation.equalsIgnoreCase("Atya"));
	}

	@Test
	public void relationshipMaternalAunt() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Yodhan");
		String relation = GetRelationship.getRelation("Maternal-Aunt", person);
		assertTrue("Relationship", relation.equalsIgnoreCase("Tritha"));
	}

	@Test
	public void relationshipSisterInLaw() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Atya");
		String relation = GetRelationship.getRelation("Sister-In-Law", person);
		assertTrue("Get Relationship",
				relation.equalsIgnoreCase("Krpi Satvy") || relation.equalsIgnoreCase("Satvy Krpi"));
	}

	@Test
	public void relationshipBrotherInLaw() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Satvy");
		String relation = GetRelationship.getRelation("Brother-In-Law", person);
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Vyas"));
	}

	@Test
	public void relationshipSon() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Dritha");
		String relation = GetRelationship.getRelation("Son", person);
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Yodhan"));
	}

	@Test
	public void relationshipDaughter() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Krpi");
		String relation = GetRelationship.getRelation("Daughter", person);
		assertTrue("Get Relationship", relation.equalsIgnoreCase("Krithi"));
	}

	@Test
	public void relationshipSiblings() {
		Person person = TheShanFamilyTree.getPersonFromFamilyTreeMap("Dritha");
		String relation = GetRelationship.getRelation("Siblings", person);
		assertTrue("Get Relationship",
				relation.equalsIgnoreCase("Tritha Vritha") || relation.equalsIgnoreCase("Vritha Tritha"));
	}
}
