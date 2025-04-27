/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: Contact allows the user to
 * store an ID, first name, last name, phone number, and address.
 * The latter four are both accessible and mutable, except
 * ID is accessible and immutable. 
 */
package com.snhu.GrandStrandSystems;

public class Contact {
	Contact(String ID, String firstName, String lastName, String phone, String address) {
		// parameter validation is done in class methods,
		this.setID(ID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}
	// accessors
	public String getID() {
		return m_ID;
	}
	public String getFirstName() {
		return m_firstName;
	}
	public String getLastName() {
		return m_lastName;
	}
	public String getPhone() {
		return m_phone;
	}
	public String getAddress() {
		return m_address;
	}
	
	// mutators
	public void setFirstName(String t_name) {
		if (t_name == null) {
			throw new IllegalArgumentException("name is null");
		} else if (t_name.length() > 10) {
			throw new IllegalArgumentException("name exceeds maximum length");
		}
		m_firstName = t_name;
	}
	public void setLastName(String t_name) {
		if (t_name == null) {
			throw new IllegalArgumentException("name is null");
		} else if (t_name.length() > 10) {
			throw new IllegalArgumentException("name exceeds maximum length");
		}
		m_lastName = t_name;
	}
	public void setPhone(String t_phoneNumber) {
		if (t_phoneNumber == null) {
			throw new IllegalArgumentException("phoneNumber is null");
		} else if (t_phoneNumber.length() != 10) {
			throw new IllegalArgumentException("phoneNumber must be 10 digits");
		}
		try {
			Integer.parseInt(t_phoneNumber);
		} catch(NumberFormatException e) { // non-numeric
			throw new IllegalArgumentException("phoneNumber is non-numeric");
		}
		m_phone = t_phoneNumber;
	}
	public void setAddress(String t_address) {
		if (t_address == null) {
			throw new IllegalArgumentException("address is null");
		} else if (t_address.length() > 30) {
			throw new IllegalArgumentException("address exceeds maximum length");
		}
		m_address = t_address;
	}
	
	// ID is not mutable
	private void setID(String t_ID) {
		if (t_ID == null) {
			throw new IllegalArgumentException("ID is null");
		} else if (t_ID.length() > 10) {
			throw new IllegalArgumentException("ID exceeds maximum length");
		}
		m_ID = t_ID;
	}
	private String m_ID, m_firstName, m_lastName, m_phone, m_address;
}
