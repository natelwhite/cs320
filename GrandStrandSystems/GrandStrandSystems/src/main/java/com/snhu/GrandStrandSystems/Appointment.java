/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: Appointment allows the user to
 * store an ID, date, and description.
 * The latter two are both accessible and mutable, except
 * ID is accessible and immutable.  */

package com.snhu.GrandStrandSystems;

import java.util.Date;

public class Appointment {
	Appointment(String ID, Date date, String description) {
		setID(ID);
		setDate(date);
		setDescription(description);
	}
	// accessors
	public String getID() {
		return m_ID;
	}
	public Date getDate() {
		return m_date;
	}
	public String getDescription() {
		return m_description;
	}
	// mutators
	public void setDate(Date t_date) {
		if (t_date == null) {
			throw new IllegalArgumentException("Appointment date is null");
		} else if (t_date.before(new Date())) {
			throw new IllegalArgumentException("Appointment date is in the past");
		}
		m_date = t_date;
	}
	public void setDescription(String t_description) {
		if (t_description == null) {
			throw new IllegalArgumentException("Appointment name is null");
		} else if (t_description.length() > 50) {
			throw new IllegalArgumentException("Appointment name exceeds maximum length");
		}
		m_description = t_description;
	}
	// ID is immutable
	private void setID(String t_ID) {
		if (t_ID == null) {
			throw new IllegalArgumentException("Appointment ID is null");
		} else if (t_ID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID exceeds maximum length");
		} 
		m_ID = t_ID;
	}
	private String m_ID, m_description;
	private Date m_date;
}
