//Author Name: Robert Robbins
//
//Date: 10/9/2024
//
//Course Id; CS-320

//This is the Contact service class test class. It tests that the ContactService
//class can add new contact objects with unique ids and that the first name, last name, phone
//number and address can be modified.



package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import module3.ContactService;

class ContactServiceTest {

	//tests that a contact object can be created, stored and that all of the fields match what were passed in.
	@Test
	void testContactCreation() {
		ContactService.createNewContact("Robert", "Robbins", "1234567890", "Short address");
		int testIndex = ContactService.contacts.size() -1;
		assertTrue(ContactService.contacts.get(testIndex).getFirstName().equals("Robert"));
		assertTrue(ContactService.contacts.get(testIndex).getLastName().equals("Robbins"));
		assertTrue(ContactService.contacts.get(testIndex).getPhoneNumber().equals("1234567890"));
		assertTrue(ContactService.contacts.get(testIndex).getAddress().equals("Short address"));
	}
	
	
	//tests that the remove function removes contacts.
	@Test 
	void testRemoveContact() {
		int oldContactListSize;
		int newContactListSize;
		String contactId;
		boolean contactDeleted = true; 
		
		
		ContactService.createNewContact("first", "last", "1234567890", "Short address");
		
		contactId = ContactService.contacts.get(0).getContactId();
		oldContactListSize = ContactService.contacts.size();
		
		ContactService.removeContact(contactId);
		
		newContactListSize = ContactService.contacts.size();
		
		for (int i = 0; i < newContactListSize; i++) {
			if(ContactService.contacts.get(i).getContactId() == contactId) {
				contactDeleted = false;
			}
		}
		assertNotEquals(oldContactListSize, newContactListSize);
		assertTrue(contactDeleted);
	}
	
	//Tests that nothing happens if contact ID is not found
	@Test
	void testRemove() {
		ContactService.createNewContact("first", "last", "1234567890", "Short address");
		int oldList = ContactService.contacts.size();
		ContactService.removeContact("a");
		int newList = ContactService.contacts.size();
		assertEquals(newList, oldList);
	}
	
	
	
	
	//Tests that contact objects have unique contact ids.
	@Test
	void testUniqueIdCreation() {
		ContactService.createNewContact("personA", "lastname", "1234567890", "Short address");
		ContactService.createNewContact("personB", "lastname", "1234567890", "Short address");
		assertNotEquals(ContactService.contacts.get(0).getContactId(), ContactService.contacts.get(1).getContactId());
	}
	
	
	//The last four tests test that the ContactService class can update first name, last name, phone number
//	and address
	@Test
	void testFirstNameUpdate() {
		ContactService.createNewContact("personC", "lastname", "1234567890", "Short address");
		String contactId = ContactService.contacts.get(0).getContactId();
		ContactService.updateFirstName(contactId, "new name");
		assertEquals(ContactService.contacts.get(0).getFirstName(), "new name");
	}
	
	@Test
	void testLastNameUpdate() {
		ContactService.createNewContact("personD", "lastname", "1234567890", "Short address");
		String contactId = ContactService.contacts.get(0).getContactId();
		ContactService.updateLastName(contactId, "new name");
		assertEquals(ContactService.contacts.get(0).getLastName(), "new name");
	}
	
	@Test
	void testPhoneNumberUpdate() {
		ContactService.createNewContact("personE", "lastname", "1234567890", "Short address");
		String contactId = ContactService.contacts.get(0).getContactId();
		ContactService.updatePhoneNumber(contactId, "1111111111");
		assertEquals(ContactService.contacts.get(0).getPhoneNumber(), "1111111111");
	}
	
	@Test
	void testAddressUpdate() {
		ContactService.createNewContact("personF", "lastname", "1234567890", "Short address");
		String contactId = ContactService.contacts.get(0).getContactId();
		ContactService.updateAddress(contactId, "new address");
		assertEquals(ContactService.contacts.get(0).getAddress(), "new address");
	}

}

