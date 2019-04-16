package com.exeter.todo;

public class Task {
	private String taskName;
	private String taskDescription;
	private String assignedPerson;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getAssignedPerson() {
		return assignedPerson;
	}
	public void setAssignedPerson(String assignedPerson) {
		this.assignedPerson = assignedPerson;
	}
	
	public Task() {}
	public Task(String taskName, String taskDescription, String assignedPerson) {
		this.setTaskName(taskName);
		this.setTaskDescription(taskDescription);
		this.setAssignedPerson(assignedPerson);
	}
}
