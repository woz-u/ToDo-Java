package com.exeter.todo;

import java.util.List;
import java.util.Scanner;

public class ToDo {

	private static TaskManager taskMan;

	public static void main(String[] args) {
		taskMan = new TaskManager();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the ToDo List App!\n");

		for (String selected = ""; !selected.equalsIgnoreCase("x");) {
			// Task List
			System.out.println("Current list of tasks:");
			System.out.println("*******************");
			List<Task> tasks = taskMan.getTasks();
			for (Task task : tasks) {
				System.out.println("Name: 		" + task.getTaskName());
				System.out.println("Description: 	" + task.getTaskDescription());
				System.out.println("Assigned: 	" + task.getAssignedPerson());
				System.out.println("-------------------");
			}
			
			// Menu
			ToDoMenu menu = new ToDoMenu();
			menu.displayMenu();
			selected = scanner.nextLine();
			switch (selected) {
			case "1":
				System.out.println("Please give this task a name:");
				String taskName = scanner.nextLine();
				System.out.println("Please give the description of this task:");
				String taskDescription = scanner.nextLine();
				System.out.println("Assign this task to:");
				String assignTo = scanner.nextLine();
				taskMan.addTask(taskName, taskDescription, assignTo);
				break;
			case "x":
				break;
			default:
				System.out.println("Item not found.");
				break;
			}
		}

		System.out.println("Closing app");
		scanner.close();
	}
}
