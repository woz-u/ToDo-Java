package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskReporterTest {
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
	void testPrintTasks() {
		// Arrange
		Task task1 = new Task("My Task", "Task Description", "Steve");
		Task task2 = new Task("Another Task", "Another Task Description", "Me");
		List<Task> mockTasks = Arrays.asList(task1, task2);
		TaskReporter SUT = new TaskReporter();
		
		// Act
		SUT.printTasks(mockTasks);
		
		// Assert
		String expected = "Current list of tasks:" + System.lineSeparator() + 
				"*******************"+ System.lineSeparator() + 
				"Name: 		My Task" + System.lineSeparator() + 
				"Description: 	Task Description" + System.lineSeparator() + 
				"Assigned: 	Steve" + System.lineSeparator() + 
				"-------------------" + System.lineSeparator() + 
				"Name: 		Another Task" + System.lineSeparator() + 
				"Description: 	Another Task Description" + System.lineSeparator() + 
				"Assigned: 	Me" + System.lineSeparator() + 
				"-------------------" + System.lineSeparator();
		String result = outContent.toString();
		assertEquals(expected, result);
	}
}
