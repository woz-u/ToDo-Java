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
			List<Task> tasks = taskMan.getTasks();
			TaskReporter taskReporter = new TaskReporter();
			taskReporter.printTasks(tasks);
			
			// Menu
			ToDoMenu menu = new ToDoMenu();
			menu.displayMenu();
			selected = scanner.nextLine();
			switch (selected) {
			case "1":
				NewTaskPromptHelper promptHelper = new NewTaskPromptHelper(scanner);
				String taskName = promptHelper.promptTaskName();
				String taskDescription = promptHelper.promptTaskDescription();
				String assignTo = promptHelper.promptAssignPerson();
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
