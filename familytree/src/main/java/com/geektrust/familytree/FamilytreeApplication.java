package com.geektrust.familytree;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geektrust.familytree.service.CreateChild;
import com.geektrust.familytree.service.CreateTheShanFamilyTree;
import com.geektrust.familytree.service.ReadInputFile;

@SpringBootApplication
public class FamilytreeApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(FamilytreeApplication.class, args);
		
		CreateTheShanFamilyTree.createTheShanFamliyTree();
		
		System.out.println("Please Input File Location::");
		
		Scanner sc = new Scanner(System.in);
		String filePath = sc.next();
		try {
			ReadInputFile.readFile(filePath);
		} catch (IOException e) {
			System.out.println("Issue With File Location, Please Provide Full/Correct Path - Retry");
		}
	}
}
