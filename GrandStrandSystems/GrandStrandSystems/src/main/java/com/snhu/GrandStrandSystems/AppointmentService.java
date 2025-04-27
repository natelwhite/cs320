/**
 * Author Name: Nathaniel White
 * Date: 04/13/2025
 * Course ID: CS-320-10813-M01
 * Description: AppointmentService allows the user to
 * manage appointments using CRUD operations.
 */

package com.snhu.GrandStrandSystems;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	// retrieve a Task from the service
	public Appointment get(String appointmentID) {
		if (!m_appointments.containsKey(appointmentID)) { // Appointment does not exist
			throw new IllegalArgumentException("Appointment DNE");
		}
		return m_appointments.get(appointmentID);
	}
	// add an Appointment to the service
	public String add(Date date, String description) {
		// get unique id and increment to keep it unique
		String id = Integer.toString(this.m_nextAppointmentID++);
		m_appointments.put(id, new Appointment(id, date, description));
		return id;
	}
	// remove an Appointment from the service
	public void delete(String appointmentID) {
		if (!m_appointments.containsKey(appointmentID)) { // Appointment does not exist
			throw new IllegalArgumentException("Appointment DNE");
		}
		m_appointments.remove(appointmentID);
	}
	private HashMap<String, Appointment> m_appointments = new HashMap<String, Appointment>();
	private int m_nextAppointmentID = 0;
}
