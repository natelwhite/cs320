/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: Contact allows the user to
 * store an ID, name, and description.
 * The latter two are both accessible and mutable, except
 * ID is accessible and immutable. 
 */

package com.snhu.GrandStrandSystems;

public class Task {
	Task(String ID, String name, String description) {
		setID(ID);
		setName(name);
		setDescription(description);
	}
	// accessors
	public String getID() {
		return m_ID;
	}
	public String getName() {
		return m_name;
	}
	public String getDescription() {
		return m_description;
	}
	// mutators
	public void setName(String t_name) {
		if (t_name == null) {
			throw new IllegalArgumentException("task name is null");
		} else if (t_name.length() > 20) {
			throw new IllegalArgumentException("task name exceeds maximum length");
		}
		m_name = t_name;
	}
	public void setDescription(String t_description) {
		if (t_description == null) {
			throw new IllegalArgumentException("task name is null");
		} else if (t_description.length() > 20) {
			throw new IllegalArgumentException("task name exceeds maximum length");
		}
		m_description = t_description;
	}
	// ID is immutable
	private void setID(String t_ID) {
		if (t_ID == null) {
			throw new IllegalArgumentException("task ID is null");
		} else if (t_ID.length() > 10) {
			throw new IllegalArgumentException("task ID exceeds maximum length");
		} 
		m_ID = t_ID;
	}
	private String m_ID, m_name, m_description;
}
