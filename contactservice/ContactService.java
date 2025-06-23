/**
 * Name: Thomas Davis
 * Date: 5/24/2025
 * CS-320-12165
 */

package contactservice;

import java.util.HashMap;
import java.util.Map;


public class ContactService {
	
	// Create Hash Map to contain the contacts
	public static Map<String, Contact> contacts = new HashMap<>();
	
	// Adds new contact and verifies not null
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null.");
		}
		
		// Stores the contactID 
		String newContactID = contact.getContactID();
		
		// Compares new contactID with existing to ensure it is unique
		if (contacts.containsKey(newContactID)) {
			throw new IllegalArgumentException("Duplicate contact ID found.");
		}
		
		// Adds new contact to Hash map 
		contacts.put(newContactID, contact);
	}
	
	// Removes contact using contactID to verify correct contact
	public void removeContact(String contactID) {
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact could not be found with provided ID.");
		}
		contacts.remove(contactID);
	}
	
	// Setter for updating existing fields
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContact(contactID);
        contact.setFirstName(firstName); // Validation is in the setter
    }
    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(lastName);
    }
    public void updatePhoneNumber(String contactID, String phoneNumber) {
        Contact contact = getContact(contactID);
        contact.setPhoneNumber(phoneNumber);
    }
    public void updateAddress(String contactID, String address) {
        Contact contact = getContact(contactID);
        contact.setAddress(address);
    }
	// Searches for a contact based on the contactID
	public Contact getContact(String contactID) {
        Contact contact = contacts.get(contactID);
        	if (contact == null) {
	            throw new IllegalArgumentException("Contact could not be found with provided ID.");
        	}
	        return contact;
	    }
	}