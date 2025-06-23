/**
 * Name: Thomas Davis
 * Date: 5/24/2025
 * CS-320-12165
 */

package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	// Test for valid contact
	@Test
	void testValidContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
        assertEquals("1", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Easy Street", contact.getAddress());
	}
	
	// Test for null contactID
	@Test
	void testNullContactID() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact(null, "John", "Doe", "1234567890", "123 Easy Street");
	});
	}
	
	// Test for duplicate contactID
	@Test
	void testDuplicateID() {
		final ContactService testContactService = new ContactService();
		final Contact Contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		final Contact duplicateIDContact = new Contact("1", "Jane", "Doe", "0987654321", "321 Easy Street");
		testContactService.addContact(Contact);
	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        testContactService.addContact(duplicateIDContact);
	    });
	}
	
	// Test to get contactID
	@Test
	void testGetContactID() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		assertEquals("1", contact.getContactID());
	}
	
	//Test for null firstName
	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact("1", null, "Doe", "1234567890", "123 Easy Street");
	});
	}
	
	// Test for null lastName
	@Test
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact("1", "JohnDoe", null, "1234567890", "123 Easy Street");
	});
	}
	
	// Test for null phoneNumber
	@Test
	void testNullPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact("1", "John", "Doe", null, "123 Easy Street");
	});
	}
	
	// Test for null address
	@Test
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
			new Contact("1", "John", "Doe", "1234567890", null);
	});
	}
	
	// Test for setting firstName
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Easy Street");
		contact.setFirstName("John");
		assertEquals("John",contact.getFirstName());
	}
	
	// Test for setting null firstName
	@Test
	void testSetNullFirstName() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
			});
		}
	
	// Test for setting firstName with invalid length
	@Test
	void testSetInvalidFirstName() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("JohnJaneDoe");
			});
		}
		
	// Test for setting lastName
	@Test
	void testSetLastName() {
		Contact contact = new Contact("1", "John", "Jane", "1234567890", "123 Easy Street");
		contact.setLastName("Doe");
		assertEquals("Doe",contact.getLastName());
		}
		
	// Test for setting null lastName
	@Test
	void testSetNullLastName() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
			});
		}
	
	// Test for setting lastName with invalid length
	@Test
	void testSetInvalidLastName() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("JohnJaneDoe");
			});
		}
	
	// Test for setting phoneNumber
	@Test
	void testSetPhoneNumber() {
		Contact contact = new Contact("1", "John", "Doe", "1111111111", "123 Easy Street");
		contact.setPhoneNumber("1234567890");
		assertEquals("1234567890",contact.getPhoneNumber());
		}
		
	// Test for setting null phoneNumber
	@Test
	void testSetNullPhoneNumber() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber(null);
			});
		}
	
	// Test for setting phoneNumber with invalid length
	@Test
	void testSetInvalidPhoneNumber() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("1");
			});
		}
	
	// Test for setting valid address
	@Test
	void testSetAddress() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		contact.setAddress("123 Easy Street");
		assertEquals("123 Easy Street", contact.getAddress());
	}	
	
	// Test for setting null address
	void testSetNullAddress() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
			});
	}
	
	// Test for setting address with invalid length
	void testSetInvalidAddress() {
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Easy Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123 Easy Street, on the corner near the pharmacy.");
			});
	}
	
		
		
		
	}	
	
