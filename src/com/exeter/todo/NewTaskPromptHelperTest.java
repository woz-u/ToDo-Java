package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewTaskPromptHelperTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	private NewTaskPromptHelper SUT;

	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	void testPromptTaskName() {
		String expected = "Please give this task a name:" + System.lineSeparator();
		String inputString = "Test Input";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		SUT.promptTaskName();
		
		String result = outContent.toString();
		assertEquals(expected, result);
	}

	@Test
	void testPromptTaskDescription() {
		String expected = "Please give the description of this task:" + System.lineSeparator();
		String inputString = "Test Input";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		SUT.promptTaskDescription();
		
		String result = outContent.toString();
		assertEquals(expected, result);
	}

	@Test
	void testPromptAssignPerson() {
		String expected = "Assign this task to:" + System.lineSeparator();
		String inputString = "Test Input";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		SUT.promptAssignPerson();
		
		String result = outContent.toString();
		assertEquals(expected, result);
	}
	
	@Test
	void testPromptTaskNameReturnString() {
		// Arrange
		String inputString = "My Task";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		// Act
		String result = SUT.promptTaskName();
		
		// Assert
		assertEquals(inputString, result);
	}
	
	@Test
	void testPromptTaskDescriptionReturnString() {
		// Arrange
		String inputString = "Task Description";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		// Act
		String result = SUT.promptTaskDescription();
		
		// Assert
		assertEquals(inputString, result);
	}
	
	@Test
	void testPromptAssignPersonReturnString() {
		// Arrange
		String inputString = "Steve";
		InputStream input = new ByteArrayInputStream(inputString.getBytes());
		this.SUT = new NewTaskPromptHelper(new Scanner(input));
		
		// Act
		String result = SUT.promptAssignPerson();
		
		// Assert
		assertEquals(inputString, result);
	}
}
