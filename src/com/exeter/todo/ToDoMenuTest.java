package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoMenuTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
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
	void testDisplayMenu() {
		ToDoMenu SUT = new ToDoMenu();
		SUT.displayMenu();
		String expected = "Please select a menu item:" + System.lineSeparator();
		expected += "1. Enter a new task." + System.lineSeparator();
		expected += "X. Exit applicaiton" + System.lineSeparator();
		
		originalOut.println(outContent.toString());
		
		assertEquals(expected, outContent.toString());
	}
}
