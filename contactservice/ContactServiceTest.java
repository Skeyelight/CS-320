/**
 * Name: Thomas Davis
 * Date: 5/24/2025
 * CS-320-12165
 */

package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	
	@AfterEach
	void clearHashMap() {
		ContactService.contacts.clear();
	}
	
	// Test if contact was successfully added
	@Test
	void testAddContact() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    assertEquals("John", verifyContact.getFirstName());
	    assertEquals("Doe", verifyContact.getLastName());
	    assertEquals("1234567890", verifyContact.getPhoneNumber());
	    assertEquals("123 Easy Street", verifyContact.getAddress());
	}
	
	// Test adding contact with invalid ID
	@Test
	void testInvaildContactID() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact("12345678987654321", "John", "Doe", "1234567890", "123 Easy Street");
		});
	}
	
	// Test adding contact with Null
	@Test
	void testNullContactID() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Easy Street");
		});
	}
	
	// Verify contactID is unique
	@Test 
	void testUniqueContactID() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Contact duplicateID = new Contact("1", "Jane", "Doe", "0987654321", "456 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
		assertEquals("1", verifyContact.getContactID());
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			testContactService.addContact(duplicateID);
		});
	}
	// Check contact delete function
	@Test
	void testDeleteContact() {
		Contact testContact1 = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Contact testContact2 = new Contact("2", "Jane", "Doe", "0987654321", "456 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact1);		
		testContactService.addContact(testContact2);
		assertEquals(2, testContactService.contacts.size());
		testContactService.removeContact("2");
		assertEquals(1, testContactService.contacts.size());
		assertFalse(ContactService.contacts.containsKey("2"));
	}
	
	// Test failing search function
	@Test
	void testFailSearchContact() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        testContactService.getContact("2"); 
	    });
	}
	
	// Test updating firstName
	@Test
	void testUpdateFirstName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    testContactService.updateFirstName("1","Jane");
	    assertEquals("Jane", verifyContact.getFirstName());
	}
	
	// Test updating invalid firstName
	@Test
	void testInvalidUpdateFirstName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateFirstName("1","JohnJaneDoe"); 
	    });
	}
	
	// Test updating null firstName
	@Test
	void testNullUpdateFirstName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateFirstName("1",null); 
	    });
	}

	// Test updating lastName
	@Test
	void testUpdateLastName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    testContactService.updateLastName("1","Smith");
	    assertEquals("Smith", verifyContact.getLastName());
	}
	
	// Test updating invalid lastName
	@Test
	void testInvalidUpdateLastName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateLastName("1","JohnJaneDoe"); 
	    });
	}
	
	// Test updating null lastName
	@Test
	void testNullUpdateLastName() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateLastName("1", null); 
	    });
	}
	
	// Test updating phoneNumber
	@Test
	void testUpdatePhoneNumber() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    testContactService.updatePhoneNumber("1","0987654321");
	    assertEquals("0987654321", verifyContact.getPhoneNumber());
	}
	
	//Test updating invalid phoneNumber
	@Test
	void testInvalidUpdatePhoneNumber() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updatePhoneNumber("1","Short"); 
	    });
	}
	
	//Test updating null phoneNumber
	@Test
	void testNullUpdatePhoneNumber() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updatePhoneNumber("1",null); 
	    });
	}
	
	// Test updating address
	@Test
	void testUpdateAddress() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    testContactService.updateAddress("1","456 Easy Street");
	    assertEquals("456 Easy Street", verifyContact.getAddress());
	}
	
	// Test updating invalid address
	@Test
	void testInvalidUpdateAddress() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateAddress("1","123 Easy Street, on the corner near the pharmacy"); 
	    });
	}
	
	// Test updating null address
	@Test
	void testNullUpdateAddress() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		Contact verifyContact = testContactService.getContact("1");
	    assertEquals("1", verifyContact.getContactID());
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    	testContactService.updateAddress("1",null); 
	    });
	}
}
