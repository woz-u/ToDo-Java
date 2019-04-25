package com.exeter.todo;

import java.util.Scanner;

public class NewTaskPromptHelper {
	private Scanner scanner;
	public NewTaskPromptHelper(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public String promptTaskName() {
		System.out.println("Please give this task a name:");
		return scanner.nextLine();
	}
	
	public String promptTaskDescription() {
		System.out.println("Please give the description of this task:");
		return scanner.nextLine();
	}
	
	public String promptAssignPerson() { 
		System.out.println("Assign this task to:");
		return scanner.nextLine();
	}
}
