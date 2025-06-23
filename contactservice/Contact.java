/**
 * Name: Thomas Davis
 * Date: 5/24/2025
 * CS-320-12165
 */

package contactservice;

public class Contact {
	
	// Declares the required field
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Constructor for contact with validation 
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and up to 10 characters.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and up to 10 characters.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and up to 10 characters.");
        }
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Phone number  cannot be null and must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and no longer than 30 characters.");
        }
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
	
	// Creates get methods for each field
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}

	// Creates setters with validation for updatable fields
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() >10) { 
			throw new IllegalArgumentException("Invalid first name.");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() >10) { 
			throw new IllegalArgumentException("Invalid last name.");
		}
		this.lastName = lastName;
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10) { 
			throw new IllegalArgumentException("Invalid phone number.");
		}
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) { 
			throw new IllegalArgumentException("Invalid address.");
		}
		this.address = address;
	}
		
}
