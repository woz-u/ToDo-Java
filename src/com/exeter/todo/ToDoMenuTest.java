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
		String expected = "Please select a menu item:\r\n";
		expected += "1. Enter a new task.\r\n";
		expected += "X. Exit applicaiton\r\n";
		
		originalOut.println(outContent.toString());
		
		assertEquals(expected, outContent.toString());
	}
}
