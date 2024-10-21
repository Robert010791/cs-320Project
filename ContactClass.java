//Author Name: Robert Robbins
//
//Date: 10/9/2024
//
//Course Id; CS-320

//I changed the constructor and setter functions to modify the string if
//an invalid or null value is passed in.



package module3;
import java.util.concurrent.atomic.AtomicLong;



public class ContactClass {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//initial id counter which is incremented with each instantiation to 
	// prevent duplicate ids.
    public static AtomicLong idCounter = new AtomicLong();
    
    public static String uniqueId(){
     return String.valueOf(idCounter.getAndIncrement());
    }
	
    
    
    
//    Constructor
   public ContactClass(String firstName, String lastName, String phoneNumber, String address) {
	   
	   this.contactId = uniqueId();
	   
	   
	   

	   
	   if(firstName == null) {
		   firstName = "Null";
	   }else if(firstName.length() > 10) {
		   firstName = firstName.substring(0, 10);
	   }
	   
	   
	   

	   
	   if (lastName == null) {
		   lastName = "Null";
	   } else if(lastName.length() > 10) {
		   lastName = lastName.substring(0, 10);
	   }
	   
	   
	   

	   
	   if(phoneNumber == null) {
		   phoneNumber = "1111111111";
	   } else if(phoneNumber.length() != 10) {
		   phoneNumber = "1111111111";
	   }
	   

	   
	   if(address == null) {
		   address = "Null";
	   } else if(address.length() > 30) {
		   address = address.substring(0, 30);
	   }
	   
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.phoneNumber = phoneNumber;
	   this.address = address;
	   
	   
	   
   }
    
   
   //Setter methods below if a null value is passed into update then nothing happens
   //if a invalid length value is passed in then the value is trimmed.
   //Update firstName
   public void setFirstName (String newFirstName) {
       if(newFirstName == null) {
           newFirstName = this.firstName;
       }else if(newFirstName.length() > 10) {
           newFirstName = newFirstName.substring(0, 10);
       }
       
       this.firstName = newFirstName;
   }
   
   
   //Update lastName
   public void setLastName (String newLastName) {
       if (newLastName == null) {
           newLastName = this.lastName;
       } else if(newLastName.length() > 10) {
           newLastName = newLastName.substring(0, 10);
       }
	   
	   this.lastName = newLastName;
	   
   }
   
   
   //Update phoneNumber
   public void setPhoneNumber (String newPhoneNumber) {
       if(newPhoneNumber == null) {
           newPhoneNumber = this.phoneNumber;
       } else if(newPhoneNumber.length() != 10) {
    	   newPhoneNumber = this.phoneNumber;
       }
	   
	   this.phoneNumber = newPhoneNumber;
   }
   
   //Update address
   public void setAddress (String newAddress) {
       if(newAddress == null) {
           newAddress = this.address;
       } else if(newAddress.length() > 30) {
           newAddress = newAddress.substring(0, 30);
       }
	   
	   this.address = newAddress;
   }
   
   
   
   
   
   
//   Getter methods below
    
    public String getContactId() {
    	return contactId;
    }
    
    public String getFirstName () {
    	return firstName;
    }

    
    public String getLastName () {
    	return lastName;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    public String getAddress() {
    	return address;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
