package com.exeter.todo;

import java.util.List;

public class TaskReporter {
	void printTasks(List<Task> tasks) {
		System.out.println("Current list of tasks:");
		System.out.println("*******************");
		for (Task task : tasks) {
			System.out.println("Name: 		" + task.getTaskName());
			System.out.println("Description: 	" + task.getTaskDescription());
			System.out.println("Assigned: 	" + task.getAssignedPerson());
			System.out.println("-------------------");
		}
	}
}
