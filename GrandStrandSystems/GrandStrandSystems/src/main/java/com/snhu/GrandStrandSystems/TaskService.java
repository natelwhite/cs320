/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: TaskService allows the user to
 * manage tasks using CRUD operations.
 */
package com.snhu.GrandStrandSystems;

import java.util.HashMap;

public class TaskService {
	// retrieve a Task from the service
	public Task get(String taskID) {
		if (!m_tasks.containsKey(taskID)) { // Task does not exist
			throw new IllegalArgumentException("Task DNE");
		}
		return m_tasks.get(taskID);
	}
	// add a Task to the service
	public String add(String name, String description) {
		// get unique id and increment to keep it unique
		String id = Integer.toString(this.m_nextTaskID++);
		m_tasks.put(id, new Task(id, name, description));
		return id;
	}
	// remove a Task from the service
	public void delete(String taskID) {
		if (!m_tasks.containsKey(taskID)) { // Task does not exist
			throw new IllegalArgumentException("Task DNE");
		}
		m_tasks.remove(taskID);
	}
	// set name of task
	public void setName(String taskID, String name) {
		if (!m_tasks.containsKey(taskID)) { // Task does not exist
			throw new IllegalArgumentException("Task DNE");
		}
		m_tasks.get(taskID).setName(name);
	}
	// set description of task
	public void setDescription(String taskID, String description) {
		if (!m_tasks.containsKey(taskID)) { // Task does not exist
			throw new IllegalArgumentException("Task DNE");
		}
		m_tasks.get(taskID).setDescription(description);
	}
	private HashMap<String, Task> m_tasks = new HashMap<String, Task>();
	private int m_nextTaskID = 0;
}
