package com.geektrust.familytree.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInputFile {

	public static void readFile(String filePath) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String request = br.readLine();
			while (null != request && !request.isEmpty()) {
				if (request.contains("ADD_CHILD"))
					CreateChild.createChild(request);
				else if (request.contains("GET_RELATIONSHIP")) {
					GetRelationship.getRelationship(request);
				} else {
					System.out.println("Invalid Request" + request);
				}
				request = br.readLine();
			}
		}
	}
}
