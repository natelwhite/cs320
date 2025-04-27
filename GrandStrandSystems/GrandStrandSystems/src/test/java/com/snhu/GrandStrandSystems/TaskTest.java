/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: A JUnit 5 Test for testing the requirements of a Task.
 * Because the Task constructor simply passes arguments to it's methods,
 * only the constructor needs to be tested. In other words,
 * If the constructor passes the tests, so will the Task class methods
 */

package com.snhu.GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
	// a matrix of test cases for a valid task
	// each row is a test: { ID, name, description }
	private String[][] m_valid = {
		{"1234567890", "abcdefghijklmnopqrst", "ABCDEFGHIJKLMNOPQRST"},
		{"", "", ""},
	};
	// a matrix of test cases for an invalid task
	// each row is a test
	private String[][] m_invalid = {
		// invalid ID (too long)
		{"12345678901", "", ""},
		// invalid ID (null)
		{null, "", ""},
		// invalid name (too long)
		{"", "abcdefghijklmnopqrstu", ""},
		// invalid name (null)
		{"", null, ""},
		// invalid description (too long)
		{"", "", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXY"},
		// invalid description (null)
		{"", "", null},
	};
	@Test 
	void testInvalidTask() {
		for (String[] test : m_invalid) {
			// assert that invalid arguments throws an exception
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Task(test[0], test[1], test[2]);
			});
		}
	}
	@Test
	void testValidTask() {
		for (String[] test : m_valid) {
			// assert that valid arguments don't throw exceptions
			Assertions.assertDoesNotThrow(() -> {
				Task task = new Task(test[0], test[1], test[2]);
				// assert class members were successfully set
				assertTrue(task.getID().equals(test[0]));
				assertTrue(task.getName().equals(test[1]));
				assertTrue(task.getDescription().equals(test[2]));
			});	
		}
	}
}
