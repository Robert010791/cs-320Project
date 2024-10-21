//Author Name: Robert Robbins
//
//Date: 10/09/2024
//
//Course Id; CS-320


//This file is used to test the functionality of the appointment class.
//Some examples of the test are the appointment object creation test, a
//test to check that unique ids are created for each appointment object and 
// tests to check what happens when invalid date is passed into the appointment object creation.



package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import module5.Appointment;

class AppointmentTest {

	
	//tests that an appointment object can be created
	@Test
	void testAppointmentObjectCreation() {
		String appDate = "2025-12-12";
		String appDesc = "appointment description";
		LocalDate newAppDate = LocalDate.parse(appDate);
		Appointment newApp = new Appointment(appDate, appDesc);
		assertEquals(newAppDate, newApp.getAppDate());
		assertEquals(appDesc, newApp.getAppDesc());		
	}
	
	//tests that appointment objects have unique ids
	@Test
	void testUniqueAppId() {
		String appDate = "2025-12-12";
		String appDesc = "appointment description";
		Appointment appOne = new Appointment(appDate, appDesc);
		Appointment appTwo = new Appointment(appDate, appDesc);
		assertNotEquals(appOne.getAppId(), appTwo.getAppId());
	}
	
	
	//tests that appointment date can't be null
	@Test 
	void testAppointmentDateNull() {
		String appDesc = "appointment description";
		Appointment nullDateApp = new Appointment(null, appDesc);
		assertNotEquals(null, nullDateApp.getAppDate());
	}
	
	//tests that appointment date cannot be in the past.
	@Test
	void testAppointmentDateInPast() {
		String dateFromPast = "2023-12-12";
		String appDesc = "appointment description";
		LocalDate replacementDate = LocalDate.now().plusDays(7);
		Appointment pastDateApp = new Appointment(dateFromPast, appDesc);
		assertEquals(replacementDate, pastDateApp.getAppDate());
	}
	
	//tests that appointment date must be in valid year-month-day format
	@Test
	void testInvalidAppointmentDate() {
		String invalidDate = "202-12-12";
		String appDesc = "appointment description";
		LocalDate replacementDate = LocalDate.now().plusDays(7);
		Appointment invalidDateApp = new Appointment(invalidDate, appDesc);
		assertEquals(replacementDate, invalidDateApp.getAppDate());
	}
	
	//tests that appointment description cannot be null
	@Test
	void testNullAppointmentDescription() {
		String appDate = "2025-12-12";
		Appointment nullDescApp = new Appointment(appDate, null);
		assertNotEquals(null, nullDescApp.getAppDesc());
	}
	
	//test that appointment description cannot be greater than 50
	@Test
	void testAppoinmentDescNotTooLong() {
		String appDate = "2025-12-12";
		String tooLongName = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String shortenDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing";
		Appointment longDescApp = new Appointment(appDate, tooLongName);
		assertEquals(shortenDesc, longDescApp.getAppDesc());
		assertEquals(50, longDescApp.getAppDesc().length());
	}
	
	
	
	
	
	
	

}








