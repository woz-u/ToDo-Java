package com.exeter.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<Task> tasks;

	public TaskManager() {
		this.tasks = new ArrayList<Task>();
	}

	public void addTask(String taskName, String taskDescription, String assignedPerson) throws IllegalArgumentException {
		if (taskName == null || taskName.isBlank()) {
			throw new IllegalArgumentException("Missing value for Task Name.");
		}
		if (taskDescription == null || taskDescription.isBlank()) {
			throw new IllegalArgumentException("Missing value for Task Description.");
		}
		if (assignedPerson == null || assignedPerson.isBlank()) {
			throw new IllegalArgumentException("Missing value for Assigned Person.");
		}
		Task newTask = new Task(taskName, taskDescription, assignedPerson);
		this.tasks.add(newTask);
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
}
