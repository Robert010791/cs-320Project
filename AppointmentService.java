//Author Name: Robert Robbins
//
//Date: 10/09/2024
//
//Course Id; CS-320

//This is the appointment service class. It is used to
//create appointment object, store them in a list and 
//used to delete appointments using appointment id.




package module5;

import java.util.ArrayList;

public class AppointmentService {
	public static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	public static void createNewAppointment(String date, String desc) {
		Appointment newApp = new Appointment(date, desc);
		appointments.add(newApp);
	}
	
	
	public static void removeApp(String appId) {
		for(int i = 0; i < appointments.size(); i++) {
			if(appointments.get(i).getAppId() == appId) {
				appointments.remove(i);
				break;
			}
		}
	}
	

}
