/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: ContactService allows the user to
 * manage contacts using CRUD operations.
 */
package com.snhu.GrandStrandSystems;

import java.util.HashMap;

public class ContactService {
	// retrieve a Contact from the service
	public Contact get(String contactID) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		return m_contacts.get(contactID);
	}
	// add a Contact to the service
	public String add(String firstName, String lastName, String phone, String address) {
		// get unique id and increment to keep it unique
		String id = Integer.toString(this.m_nextContactID++);
		m_contacts.put(id, new Contact(id, firstName, lastName, phone, address));
		return id;
	}
	// remove a Contact from the service
	public void delete(String contactID) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		m_contacts.remove(contactID);
	}
	// set first name of contact
	public void setFirstName(String contactID, String value) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		m_contacts.get(contactID).setFirstName(value);
	}
	// set last name of contact
	public void setLastName(String contactID, String value) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		m_contacts.get(contactID).setLastName(value);
	}
	// set phone number of contact
	public void setPhone(String contactID, String value) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		m_contacts.get(contactID).setPhone(value);
	}
	// set address of contact
	public void setAddress(String contactID, String value) {
		if (!m_contacts.containsKey(contactID)) { // contact does not exist
			throw new IllegalArgumentException("Contact DNE");
		}
		m_contacts.get(contactID).setAddress(value);
	}
	private HashMap<String, Contact> m_contacts = new HashMap<String, Contact>();
	private int m_nextContactID = 0;
}
