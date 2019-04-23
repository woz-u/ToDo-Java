package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("Task Manager Should")
class TaskManagerTest {

	private static TaskManager SUT;
	
	@BeforeEach
	void SUT_Created(){
		SUT = new TaskManager();
	}

	@Test
	@DisplayName("Make Task List Not Empty When Adding A Task")
	void Using_AddTask_Will_MakeTaskListNotEmpty() {
		SUT.addTask("My Task", "Some description", "Steve");
		assertTrue(!SUT.getTasks().isEmpty(), "Tasks are empty.");
	}
	
	@Test
	@DisplayName("Make Task List Size Equal 2 When Adding Two Tasks")
	void Using_AddTask_ToAddTwoTasks_Will_MakeTaskListSizeEqual_2() {
		SUT.addTask("My Task", "Some description", "Steve");
		SUT.addTask("Other Task", "Another description", "Me");
		assertEquals(2, SUT.getTasks().size(), "Incorrect number of tasks.");
	}
	
	@Test
	@DisplayName("Make First Task List Item Equal To First Added Task When Adding 1 Task")
	void Using_AddTaskToAddOneTask_Will_MakeFirstTaskListItemEqual_ToTask() {
		Task expected = new Task("My Task", "Some description", "Steve");
		Task actual;
		
		SUT.addTask("My Task", "Some description", "Steve");
		actual = SUT.getTasks().get(0);
		
		assertAll("Task Values", 
			() -> assertEquals(expected.getTaskName(), actual.getTaskName(), "Task name incorrect"),
			() -> assertEquals(expected.getTaskDescription(), actual.getTaskDescription(), "Task description incorrect"),
			() -> assertEquals(expected.getAssignedPerson(), actual.getAssignedPerson(), "Assigned person incorrect")
		);
	}
	
	@Test
	@DisplayName("Make First Task Have Not Null Properties When Adding A Task")
	void Using_AddTaskToAddOneTask_Will_MakeFirstTaskHaveNotNullProperties() {
		SUT.addTask("My Task", "Some description", "Steve");
		Task actual = SUT.getTasks().get(0);
		
		assertAll("Not Null", 
			() -> assertNotNull(actual.getTaskName(), "Task name null"),
			() -> assertNotNull(actual.getTaskDescription(), "Task description null"),
			() -> assertNotNull(actual.getAssignedPerson(), "Assigned person null")
		);
	}
	
	@Test
	@DisplayName("Throw IllegalArgumentException When Passing Null, Empty, Or Whitespace Task Name")
	void Using_AddTaskWithEmptyNullOrWhitespaceTaskName_Will_ThrowIllegalArgumentException() {
		assertAll("Task Name Empty",
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask(null, "Some Description", "Steve")),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("", "Some Description", "Steve")),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("     ", "Some Description", "Steve"))
		);
	}
	
	@Test
	@DisplayName("Throw IllegalArgumentException When Passing Null, Empty, Or Whitespace Task Description")
	void Using_AddTaskWithEmptyNullOrWhitespaceTaskDescription_Will_ThrowIllegalArgumentException() {
		assertAll("Task Description Empty",
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", null, "Steve")),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", "", "Steve")),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", "     ", "Steve"))
		);
	}
	
	@Test
	@DisplayName("Throw IllegalArgumentException When Passing Null, Empty, Or Whitespace Assigned Person")
	void Using_AddTaskWithEmptyNullOrWhitespaceAssignedPerson_Will_ThrowIllegalArgumentException() {
		assertAll("Task Description Empty",
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", "Some Description", null)),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", "Some Description", "")),
			() -> assertThrows(IllegalArgumentException.class, 
				() -> SUT.addTask("My task", "Some Description", "     "))
		);
	}
}
