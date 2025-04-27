/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: A JUnit 5 Test for testing the requirements of a ContactService.
 */

package com.snhu.GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	@Test
	void testAdd() {
		TaskService service = new TaskService();
		// assert that .add doesn't throw exceptions
		for (int i = 0; i < 5; ++i) {
			Assertions.assertDoesNotThrow(() -> {
				service.add(m_initVals[0], m_initVals[1]);
			});
		}
	}

	@Test
	void testDelete() {
		TaskService service = new TaskService();
		// add some tasks to remove later
		String[] IDs = {"", "", "", "", ""};
		for (int i = 0; i < IDs.length; ++i) {
			IDs[i] = service.add(m_initVals[0], m_initVals[1]);
		}
		int[] delete = {0, 2, 4}; // indices to remove
		for (int i : delete) {
			// assert that deleted Task is actually deleted
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// assert that .delete doesn't throw exceptions
				Assertions.assertDoesNotThrow(() -> {
					service.delete(IDs[i]);
				});
				service.get(IDs[i]);
			});
		}
		
		// assert that the other tasks remain
		Assertions.assertDoesNotThrow(() -> {
			service.get(IDs[1]);
			service.get(IDs[3]);
		});
	}

	@Test
	void testSetName() {
		TaskService service = new TaskService();
		String id = service.add(m_initVals[0], m_initVals[1]);
		service.setName(id, m_setterVals[0]);
		// assert that first name was actually set
		assertTrue(service.get(id).getName().equals(m_setterVals[0]));
	}

	@Test
	void testSetDescription() {
		TaskService service = new TaskService();
		String id = service.add(m_initVals[0], m_initVals[1]);
		service.setDescription(id, m_setterVals[1]);
		// assert that last name was actually set
		assertTrue(service.get(id).getDescription().equals(m_setterVals[1]));
	}

	private String[] m_initVals = {"abcdefghijklmnopqrst", "ABCDEFGHIJKLMNOPQRST"};
	private String[] m_setterVals = {"tsrqponmlkjihgfedbca", "TSRQPONMLKJIHGFEDCBA"};
}
