//Author Name: Robert Robbins
//
//Date: 10/09/2024
//
//Course Id; CS-320

//This file tests the appointment service class. 
//It test the creation and removal functions and makes 
// sure it runs as desired.



package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import module5.AppointmentService;

class AppointmentServiceTest {

	
	//tests that an appointment can be created
 @Test
 void testAppointmentCreation() {
	String appDate = "2025-12-12";
	String appDesc = "appointment description";
	LocalDate date = LocalDate.parse(appDate);
	AppointmentService.createNewAppointment(appDate, appDesc);
	int testIndex = AppointmentService.appointments.size() - 1;
	assertEquals(date, AppointmentService.appointments.get(testIndex).getAppDate());
	assertEquals(appDesc, AppointmentService.appointments.get(testIndex).getAppDesc());
 }
 
 
 
 //tests that appointments have unique ids
 @Test
 void testUniqueAppointmentId() {
	String appDate = "2025-12-12";
	String appDesc = "appointment description";
	for (int i = 0; i < 4; i++) {
		AppointmentService.createNewAppointment(appDate, appDesc);
	}
	String appOneId = AppointmentService.appointments.get(0).getAppId();
	String appTwoId = AppointmentService.appointments.get(1).getAppId();
	String appThreeId = AppointmentService.appointments.get(2).getAppId();
	String appFourId = AppointmentService.appointments.get(3).getAppId();
	assertNotEquals(appOneId, appTwoId);
	assertNotEquals(appThreeId, appFourId);
 }
 
 
 //tests that an appointment can be deleted using appointment id and verifies by checking 
 //there isn't a matching id in the appointment list
 @Test
 void testAppointmentDelete() {
	String appDate = "2025-12-12";
	String appDesc = "appointment description";
	int appListSize;
	String appId;
	boolean appDeleted = true;
	AppointmentService.createNewAppointment(appDate, appDesc);
	appListSize = AppointmentService.appointments.size();
	appId = AppointmentService.appointments.get(0).getAppId();
	AppointmentService.removeApp(appId);
	for(int i = 0; i < appListSize - 1; i++) {
		if(AppointmentService.appointments.get(i).getAppId() == appId) {
			appDeleted = false;
		}
	}
	assertTrue(appDeleted);
	assertNotEquals(appListSize, AppointmentService.appointments.size());
	
 }
 

}
