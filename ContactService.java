//Author Name: Robert Robbins
//
//Date: 10/9/2024
//
//Course Id; CS-320



//This is the ContactService file which is used to create, modify and delete contacts.
//It uses the ContactClass class to create the contact objects and stores them in a static
//arraylist. The ContactService class also has methods to update the first and last name, 
//phone number and address and can remove a contact based on the contactID







package module3;
import java.util.ArrayList;

public class ContactService {
	
	public static ArrayList<ContactClass> contacts = new ArrayList<ContactClass>();
	
	public static void createNewContact(String firstName, String lastName, String phoneNumber, String address) {
		ContactClass newContact = new ContactClass(firstName, lastName, phoneNumber, address);
		contacts.add(newContact);
	}
	
	
	
	
	public static void removeContact(String contactId) {
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getContactId() == contactId) {
				contacts.remove(i);
				break;
			}
		}
	
	}

	
	
	public static void updateFirstName(String contactId, String newFirstName) {
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getContactId() == contactId) {
				contacts.get(i).setFirstName(newFirstName);
				break;
			}
		}
	}
	
	
	
	public static void updateLastName (String contactId, String newLastName) {
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getContactId() == contactId) {
				contacts.get(i).setLastName(newLastName); 
				break;
			}
		}
	}
	
	
	public static void updatePhoneNumber(String contactId, String newPhoneNumber) {
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getContactId() == contactId) {
				contacts.get(i).setPhoneNumber(newPhoneNumber);
				break;
			}
		}
	}
	
	
	public static void updateAddress(String contactId, String newAddress) {
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getContactId() == contactId) {
				contacts.get(i).setAddress(newAddress);
				break;
			}
		}
	}
	
	
	
	
	


}
