package com.geektrust.familytree;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.geektrust.familytree.service.CreateTheShanFamilyTree;

public class TestRunner {
	public static void main(String[] args) {
		CreateTheShanFamilyTree.createTheShanFamliyTree();

		Result result = JUnitCore.runClasses(TestCreateChild.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());

		Result result1 = JUnitCore.runClasses(TestRelationShip.class);

		for (Failure failure : result1.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result1.wasSuccessful());
	}
}
