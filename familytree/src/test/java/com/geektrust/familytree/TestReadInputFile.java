package com.geektrust.familytree;

import java.io.IOException;

import org.junit.Test;

import com.geektrust.familytree.service.ReadInputFile;

public class TestReadInputFile extends FamilytreeApplicationTests {

	@Test(expected = IOException.class)
	public void testInvalidPath() throws IOException {
		ReadInputFile.readFile("/src/main/resources/input.txt");
	}
	
	@Test
	public void testValidFilePath() throws IOException {
		ReadInputFile.readFile("../familytree/src/main/resources/Input.txt");
	}
}
