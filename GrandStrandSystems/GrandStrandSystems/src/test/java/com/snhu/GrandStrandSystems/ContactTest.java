/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: A JUnit 5 Test for testing the requirements of a Contact.
 * Because the Contact constructor simply passes arguments to it's methods,
 * only the constructor needs to be tested. In other words,
 * If the constructor passes the tests, so will the Contact class methods
 */

package com.snhu.GrandStrandSystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	// a matrix of test cases for a valid contact
	// each row is a test: { id, first name, last name, phone number, address }
	private String[][] valid = {
		{"1234567890", "abcdefghij", "ABCDEFGHIJ", "1234567890", "123456789012345678901234567890"},
		{"", "", "", "0987654321", ""},
	};
	// a matrix of test cases for an invalid contact
	// each row is a test
	private String[][] invalid = {
		// invalid ID (too long)
		{"12345678901", "", "", "1234567890", ""},
		// invalid ID (null)
		{null, "", "", "1234567890", ""},
		// invalid firstName (too long)
		{"", "abcdefghijk", "", "1234567890", ""},
		// invalid firstName (null)
		{"", null, "", "1234567890", ""},
		// invalid lastName (too long)
		{"", "", "ABCDEFGHIJK", "1234567890", ""},
		// invalid lastName (null)
		{"", "", null, "1234567890", ""},
		// invalid phone (too long)
		{"", "", "", "12345678901", ""},
		// invalid phone (too short)
		{"", "", "", "123456789", ""},
		// invalid phone (non-numeric)
		{"", "", "", "a234567890", ""},
		// invalid phone (null)
		{"", "", "", null, ""},
		// invalid address (too long)
		{"", "", "", "1234567890", "1234567890123456789012345678901"},
		// invalid address (null)
		{"", "", "", "1234567890", null},
	};
	@Test 
	void testInvalidContact() {
		for (String[] test : this.invalid) {
			// assert that invalid arguments throws an exception
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(test[0], test[1], test[2], test[3], test[4]);
			});
		}
	}
	@Test
	void testValidContact() {
		for (String[] test : this.valid) {
			// assert that valid arguments don't throw exceptions
			Assertions.assertDoesNotThrow(() -> {
				Contact contact = new Contact(test[0], test[1], test[2], test[3], test[4]);
				// assert class members were successfully set
				assertTrue(contact.getID().equals(test[0]));
				assertTrue(contact.getFirstName().equals(test[1]));
				assertTrue(contact.getLastName().equals(test[2]));
				assertTrue(contact.getPhone().equals(test[3]));
				assertTrue(contact.getAddress().equals(test[4]));
			});	
		}
	}
}
