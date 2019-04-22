package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class LifecycleAnnotationsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Running BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Running AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Running AfterEach");
	}

	@Test
	void test() {
		System.out.println("Running test");
		assertTrue(true);
	}
	
	@Test
	void anotherTest() {
		System.out.println("Running another test");
		assertTrue(true);
	}
}
