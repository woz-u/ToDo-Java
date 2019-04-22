package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {

	private static TaskManager SUT;
	
	@BeforeEach
	void SUT_Created(){
		SUT = new TaskManager();
	}

	
	@Test
	void Using_AddTask_Will_MakeTaskListNotEmpty() {
		SUT.addTask("My Task", "Some description", "Steve");
		assertTrue(!SUT.getTasks().isEmpty());
	}
	
	@Test
	void Using_AddTask_ToAddTwoTasks_Will_MakeTaskListSizeEqual_2() {
		SUT.addTask("My Task", "Some description", "Steve");
		SUT.addTask("Other Task", "Another description", "Me");
		assertTrue(SUT.getTasks().size() == 2);
	}
	
	@Test
	void Using_AddTaskToAddOneTask_Will_MakeFirstTaskListItemEqual_ToTask() {
		Task expected = new Task("My Task", "Some description", "Steve");
		Task actual;
		
		SUT.addTask("My Task", "Some description", "Steve");
		actual = SUT.getTasks().get(0);
		
		assertTrue(
			actual.getTaskName() == expected.getTaskName() &&
			actual.getTaskDescription() == expected.getTaskDescription() &&
			actual.getAssignedPerson() == expected.getAssignedPerson()
		);
	}
}
