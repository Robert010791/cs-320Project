//Author Name: Robert Robbins
//
//Date: 10/09/2024
//
//Course Id; CS-320

//This is the appointment class file and is used to create appointment objects. 
//It uses a static field to ensure that no duplicate appointment ids are created.
//In the constructor there are conditional statements to address possible issues that might
//arise when creating an appointment.



package module5;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
	//class fields 
	private final String appId;
	private LocalDate appDate;
	private String appDesc;
	
	
	
	//initial id set using AtomicLong
	private static AtomicLong idCounter = new AtomicLong();
	
	//Static id increment function to increase each id when an appointment object is created
	private static String uniqueIdGenerator() {
		return String.valueOf(idCounter.getAndIncrement());
	}
	
	
	//constructor 
	public Appointment(String newAppDate, String appDesc) {
		// Appointment id is created using private static class methods and cannot
		// be changed or set to null
		appId = uniqueIdGenerator();

		
		
		// logic to ensure that an appointment object with a date that is null, invalid or 
		// a date from the past is not created.
		LocalDate today = LocalDate.now();
		
		if(newAppDate == null) {
			this.appDate = today.plusDays(7);
		}else if(newAppDate.length() != 10) {
			this.appDate = today.plusDays(7);
		} else {
			this.appDate = LocalDate.parse(newAppDate);
		}
		

		
		if(this.appDate.isBefore(today)) {
			this.appDate = today.plusDays(7);
		}
		
		
		//Appointment description logic below
		if(appDesc == null) {
			this.appDesc = "Null";
		} else if(appDesc.length() > 50) {
			this.appDesc = appDesc.substring(0, 50);
		}else {
			this.appDesc = appDesc;
		}
		

		
		
		
	}
	
	
	
	//getter methods below
	public String getAppId() {
		return this.appId;
	}
	
	public LocalDate getAppDate() {
		return this.appDate;
	}
	
	public String getAppDesc() {
		return this.appDesc;
	}
	
	
	
	

	
	

}
