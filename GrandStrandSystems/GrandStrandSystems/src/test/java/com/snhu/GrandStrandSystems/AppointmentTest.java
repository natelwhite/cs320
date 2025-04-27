/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: A JUnit 5 Test for testing the requirements of an Appointment.
 * Because the Appointment constructor simply passes arguments to it's methods,
 * only the constructor needs to be tested. In other words,
 * If the constructor passes the tests, so will the Appointment class methods
 */

package com.snhu.GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {
	// a matrix of test cases
	// each row is a test: { id, description }
	// valid dates are tested separately
	private String[][] m_valid = {
		{"", ""},
		{"1234567890", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx"}
	};
	private String[][] m_invalid = {
		// id is null
		{null, "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx"},
		// description is null
		{"1234567890", null},
		// description too long
		{"1234567890", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy"},
		// id too long
		{"12345678901", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx"},
	};
	@Test 
	void testInvalidAppointment() {
		for (String[] test : m_invalid) {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Appointment(test[0], new Date(), test[1]);
			});
		}
		Date old = new Date();
		// make sure date is old
		while (!old.before(new Date())) { 
		}
		// assert that invalid dates throw an exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(m_valid[0][0], old, m_valid[0][1]);
		});
	}
	@Test
	void testValidAppointment() {
		for (String[] test : m_valid) {
			// assert that valid arguments don't throw exceptions
			Assertions.assertDoesNotThrow(() -> {
				Appointment apt = new Appointment(test[0], new Date(), test[1]);
				// assert class members were successfully set
				assertTrue(apt.getID().equals(test[0]));
				assertTrue(apt.getDescription().equals(test[1]));
			});
		}
	}
}
