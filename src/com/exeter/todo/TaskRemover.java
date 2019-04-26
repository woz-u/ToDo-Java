package com.exeter.todo;

import java.util.List;

public class TaskRemover {
	
	private List<Task> tasks;
	
	public TaskRemover(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void removeTask(String taskNameToRemove) {
		if (taskNameToRemove == null) {
			throw new IllegalArgumentException();
		} else if (!tasks.removeIf(task -> task.getTaskName() == taskNameToRemove)) {
			throw new IllegalArgumentException();
		};
	}
}
