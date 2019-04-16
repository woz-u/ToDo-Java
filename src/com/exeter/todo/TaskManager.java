package com.exeter.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<Task> tasks;

	public TaskManager() {
		this.tasks = new ArrayList<Task>();
	}

	public void addTask(String taskName, String taskDescription, String assignedPerson) {
		Task newTask = new Task(taskName, taskDescription, assignedPerson);
		this.tasks.add(newTask);
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
}
