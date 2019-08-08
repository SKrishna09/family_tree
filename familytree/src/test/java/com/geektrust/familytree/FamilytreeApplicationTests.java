package com.geektrust.familytree;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.geektrust.familytree.service.CreateTheShanFamilyTree;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilytreeApplicationTests {

	@BeforeClass
	public static void setup() {
		CreateTheShanFamilyTree.createTheShanFamliyTree();
	}
	
	@Test
	public void contextLoads() {
		
	}
}
