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

class ContactServiceTest {
	@Test
	void testAdd() {
		ContactService service = new ContactService();
		// assert that .add doesn't throw exceptions
		for (int i = 0; i < 5; ++i) {
			Assertions.assertDoesNotThrow(() -> {
				service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
			});
		}
	}

	@Test
	void testDelete() {
		ContactService service = new ContactService();
		// add some contacts to remove later
		String[] IDs = {"", "", "", "", ""};
		for (int i = 0; i < IDs.length; ++i) {
			IDs[i] = service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
		}
		int[] delete = {0, 2, 4}; // indices to remove
		for (int i : delete) {
			// assert that deleted Contact is actually deleted
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// assert that .delete doesn't throw exceptions
				Assertions.assertDoesNotThrow(() -> {
					service.delete(IDs[i]);
				});
				service.get(IDs[i]);
			});
		}
		
		// assert that the other contacts remain
		Assertions.assertDoesNotThrow(() -> {
			service.get(IDs[1]);
			service.get(IDs[3]);
		});
	}

	@Test
	void testSetFirstName() {
		ContactService service = new ContactService();
		String id = service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
		service.setFirstName(id, this.setterVals[0]);
		// assert that first name was actually set
		assertTrue(service.get(id).getFirstName().equals(this.setterVals[0]));
	}

	@Test
	void testSetLastName() {
		ContactService service = new ContactService();
		String id = service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
		service.setLastName(id, this.setterVals[1]);
		// assert that last name was actually set
		assertTrue(service.get(id).getLastName().equals(this.setterVals[1]));
	}

	@Test
	void testSetPhone() {
		ContactService service = new ContactService();
		String id = service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
		service.setPhone(id, this.setterVals[2]);
		// assert that phone was actually set
		assertTrue(service.get(id).getPhone().equals(this.setterVals[2]));
	}

	@Test
	void testSetAddress() {
		ContactService service = new ContactService();
		String id = service.add(this.initVals[0], this.initVals[1], this.initVals[2], this.initVals[3]);
		service.setAddress(id, this.setterVals[3]);
		// assert that first name was actually set
		assertTrue(service.get(id).getAddress().equals(this.setterVals[3]));
	}

	private String[] initVals = {"abcdefghij", "ABCDEFGHIJ", "1234567890", "123456789012345678901234567890"};
	private String[] setterVals = {"jihgfedbca", "JIHGFEDCBA", "0987654321", "098765432109876543210987654321"};
}
