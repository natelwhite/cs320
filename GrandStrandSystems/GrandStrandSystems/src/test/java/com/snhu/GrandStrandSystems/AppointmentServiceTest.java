/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: A JUnit 5 Test for testing the requirements of an AppointmentService.
 */

package com.snhu.GrandStrandSystems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentServiceTest {

	@Test
	void testAdd() {
		String appointmentDesc = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx";
		AppointmentService service = new AppointmentService();
		// assert that .add doesn't throw exceptions
		for (int i = 0; i < 5; ++i) {
			Assertions.assertDoesNotThrow(() -> {
				service.add(new Date(), appointmentDesc);
			});
		}
	}

	@Test
	void testDelete() {
		String appointmentDesc = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx";
		AppointmentService service = new AppointmentService();
		// add some appointments to remove later
		String[] IDs = {"", "", "", "", ""};
		for (int i = 0; i < IDs.length; ++i) {
			IDs[i] = service.add(new Date(), appointmentDesc);
		}
		int[] delete = {0, 2, 4}; // indices to remove
		for (int i : delete) {
			// assert that deleted appointment is actually deleted
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				// assert that .delete doesn't throw exceptions
				Assertions.assertDoesNotThrow(() -> {
					service.delete(IDs[i]);
				});
				service.get(IDs[i]);
			});
		}
		
		// assert that the other appointments remain
		Assertions.assertDoesNotThrow(() -> {
			service.get(IDs[1]);
			service.get(IDs[3]);
		});
	}

}
