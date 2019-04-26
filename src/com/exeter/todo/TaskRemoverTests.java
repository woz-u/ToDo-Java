package com.exeter.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskRemoverTests {

	private TaskRemover SUT;
	
	@BeforeEach
	void setUp() {
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("My Task", "Task Description", "Steve"));
		tasks.add(new Task("Another Task", "Another Task Description", "Me"));
		SUT = new TaskRemover(tasks);
	}
	
	@Test
	void WhenCreatingInstance_ShouldNotBeNull() {
		assertNotNull(SUT);
	}
	
	@Test
	void WhenGettingTaskList_ShouldNotBeNull() {
		List<Task> tasks = SUT.getTasks();
		assertNotNull(tasks);
	}
	
	@Test
	void WhenGettingTaskList_ShouldNotBeEmpty() {
		List<Task> tasks = SUT.getTasks();
		assertTrue(tasks.size() > 0, "No tasks found");
	}
	
	@Test
	void WhenInstanceWithTasksConstructor_ShouldReturnSameTaskListFromGetTasksMethod() {
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task("My Task", "Task Description", "Steve"));
		tasks.add(new Task("Another Task", "Another Task Description", "Me"));
		TaskRemover SUT = new TaskRemover(tasks);
		
		List<Task> result = SUT.getTasks();
		assertIterableEquals(tasks, result);
	}
	
	@Test
	void WhenRemovingTask_ShouldReturnNewTaskListMinusPassedTask() {
		Task taskToRemove = SUT.getTasks().get(1);
		String taskNameToRemove = taskToRemove.getTaskName();
		
		SUT.removeTask(taskNameToRemove);
		
		assertFalse(SUT.getTasks().contains(taskToRemove));
	}
	
	@Test
	void WhenPassingNullToRemoveTask_ShouldThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> SUT.removeTask(null));
	}
	
	@Test
	void WhenPassingNonExistentTaskNameToRemoveTask_ShouldThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> SUT.removeTask("Doesn't Exist"));
	}
}
