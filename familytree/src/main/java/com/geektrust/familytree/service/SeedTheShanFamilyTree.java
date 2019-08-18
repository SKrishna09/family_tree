package com.geektrust.familytree.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.geektrust.familytree.model.Person;

public class SeedTheShanFamilyTree {

	public static void seedTheShanFamilyTree() {
		try (BufferedReader br = new BufferedReader(
				new FileReader("../familytree/src/main/resources/familyTreeSeedScript.txt"))) {
			String seedRequest = br.readLine();
			Person response = null;

			while (null != seedRequest && !seedRequest.isEmpty()) {
				System.out.println(seedRequest);
				String[] request = seedRequest.split(",");
				
				if (seedRequest.contains("ADD_MEMBER")) {
					response = addMember(request);
				} else if (seedRequest.contains("ADD_CHILD")) {
					response = addChild(request);
				} else if (seedRequest.contains("ADD_SPOUSE")) {
					response = addSpouse(request);
				} else {
					System.out.println("INVALID_REQUEST " + request);
				}
				seedRequest = br.readLine();
			}
			TheShanFamilyTree.familyTree();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}

	private static Person addMember(String[] request) {
		return TheShanFamilyTree.addMemberToFamily(request[1], request[2]);
	}

	private static Person addChild(String[] request) {
		return TheShanFamilyTree.createChildren(request[2], request[3], request[1]);
	}

	private static Person addSpouse(String[] request) {
		return TheShanFamilyTree.createSpouse(request[1], request[2]);
	}

}
