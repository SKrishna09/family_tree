package com.geektrust.familytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.geektrust.familytree.service.CreateTheShanFamilyTree;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilytreeApplicationTests {

/*	@Test
	public void contextLoads() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
*/
	@Test
	public static void main(String[] args) {
		CreateTheShanFamilyTree.createTheShanFamliyTree();
		Result result = JUnitCore.runClasses(TestRelationShip.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
