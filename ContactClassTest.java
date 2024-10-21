//Author Name: Robert Robbins
//
//Date: 10/9/2024
//
//Course Id; CS-320

//This is the ContactClassTest class which is used to test the ContactClass.
//It tests the contructor method and ensures that invalid arguements cannot be 
//instantiated into a new object.

package test;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import module3.ContactClass;

class ContactClassTest {

	//tests that new object can be created.
	@Test
	void createContactObject() {
		ContactClass contactTest = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		assertTrue(contactTest.getFirstName().equals("Robert"));
		assertTrue(contactTest.getLastName().equals("Robbins"));
		assertTrue(contactTest.getPhoneNumber().equals("1234567890"));
		assertTrue(contactTest.getAddress().equals("Short address"));
		assertNotEquals(contactTest.getContactId(), null);
		
	}
	
	//Tests all getter methods 
	@Test
	void testGetterMethods() {
		ContactClass contact = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		assertNotNull(contact.getContactId());
		assertEquals("Robert", contact.getFirstName());
		assertEquals("Robbins", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNumber());
		assertEquals("Short address", contact.getAddress());
	}
	
	//Tests that Contact objects are created with unique id
	@Test
	void testUniqueContactId() {
		ContactClass contactOne = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		ContactClass contactTwo = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		assertNotEquals(contactOne.getContactId(), contactTwo.getContactId());
	}
	
	
	
	
	//Next four tests test that a Contact object cannot be created with a null value
	@Test
	void testNullFirstNameContactCreation() {
		ContactClass nullFirstName = new ContactClass(null, "last Name", "1234567890", "Short address");
		assertNotNull(nullFirstName.getFirstName());
	}
	

	@Test
	void testNullLastNameContactCreation() {
		ContactClass nullLasttName = new ContactClass("name", null, "1234567890", "Short address");
		assertNotNull(nullLasttName.getLastName());
	}
	
	@Test
	void testNullPhoneNumberContactCreation() {
		ContactClass nullPhoneNumber = new ContactClass("name", "last Name", null, "Short address");
		assertNotNull(nullPhoneNumber.getPhoneNumber());
	}

	
	@Test
	void testNullAdressContactCreation() {
		ContactClass nullAddress = new ContactClass("name", "last Name", "1234567890", null);
		assertNotNull(nullAddress.getAddress());
	}
	
	
	
	
	//The next five tests test for invalid length arguments passed in
	@Test
	void testFirstNameTooLongContactCreation() {
		ContactClass tooLongFirstName = new ContactClass("Lorem ipsum dol", "last Name", "1234567890", "short address");
		assertEquals(10, tooLongFirstName.getFirstName().length());
		assertEquals("Lorem ipsu", tooLongFirstName.getFirstName());
	}
	
	@Test
	void testLastNameTooLongContactCreation() {
		ContactClass tooLongLastName = new ContactClass("name", "Lorem ipsum dol", "1234567890", "short address");
		assertEquals(10, tooLongLastName.getLastName().length());
		assertEquals("Lorem ipsu", tooLongLastName.getLastName());
	}
	
	@Test
	void testPhoneNumberTooLongContactCreation() {
		ContactClass tooLongPhoneNumber = new ContactClass("name", "Lorem ipsum dol", "1234567890111", "short address");
		assertEquals(10, tooLongPhoneNumber.getPhoneNumber().length());
		assertEquals("1111111111", tooLongPhoneNumber.getPhoneNumber());
	}
	
	
	@Test
	void testShortPhoneNumber() {
		ContactClass tooShortPhoneNumber = new ContactClass("Robert", "Robbins", "12340", "Short address");
		assertEquals(10, tooShortPhoneNumber.getPhoneNumber().length());
		assertNotNull(tooShortPhoneNumber.getPhoneNumber());
	}
	
	@Test
	void testAddressTooLongContactCreation() {
		ContactClass tooLongAddress = new ContactClass("name", "Lorem ipsum dol", "1234567890111", "Lorem ipsum dolor sit amet, consect");
		assertEquals(30, tooLongAddress.getAddress().length());
		assertEquals("Lorem ipsum dolor sit amet, co", tooLongAddress.getAddress());
	}
	
	
	
	//Tests setter functions can update object fields
	@Test
	void testUpdate() {
		   ContactClass updateObjVals = new ContactClass("name", "name", "1111111111", "Short address");
		    updateObjVals.setFirstName("Robert");
		    updateObjVals.setLastName("Robbins");
		    updateObjVals.setPhoneNumber("1234567890");
		    updateObjVals.setAddress("New address");
		    assertEquals("Robert", updateObjVals.getFirstName());
		    assertEquals("Robbins", updateObjVals.getLastName());
		    assertEquals("1234567890", updateObjVals.getPhoneNumber());
		    assertEquals("New address", updateObjVals.getAddress());
	}
	
	//Tests setter functions cannot change values to null
	@Test
    void testUpdateNotNull() {
		ContactClass updateToNull = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		updateToNull.setFirstName(null);
		updateToNull.setLastName(null);
		updateToNull.setPhoneNumber(null);
		updateToNull.setAddress(null);
		assertEquals("Robert", updateToNull.getFirstName());
		assertEquals("Robbins", updateToNull.getLastName());
		assertEquals("1234567890", updateToNull.getPhoneNumber());
		assertEquals("Short address", updateToNull.getAddress());
	}
	
	
	//Tests setter functions cannot update fields to invalid values
	@Test
	void testUpdateNotInvalid() {
		ContactClass updateInvalid = new ContactClass("Robert", "Robbins", "1234567890", "Short address");
		updateInvalid.setFirstName("Lorem ipsum dol");
		updateInvalid.setLastName("Lorem ipsum dol");
		updateInvalid.setPhoneNumber("1");
		updateInvalid.setAddress("Lorem ipsum dolor sit amet, consect");
		assertEquals("Lorem ipsu", updateInvalid.getFirstName());
		assertEquals("Lorem ipsu", updateInvalid.getLastName());
		assertEquals("1234567890", updateInvalid.getPhoneNumber());
		assertEquals("Lorem ipsum dolor sit amet, co", updateInvalid.getAddress());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




















