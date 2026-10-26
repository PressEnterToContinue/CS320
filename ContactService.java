// ContactService.java
// Landon Allanson

import java.util.HashMap;

public class ContactService {

	// this is where contacts get stored (keyed by id so lookups don't need a loop)
	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();

	// adds contact to list
	public void addContact(Contact contact) {

		// make sure there's actually a contact
		if (contact == null) {
			throw new IllegalArgumentException("Invalid contact");
		}

		// make sure id isn't already in use
		if (contactList.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("That contact ID is already taken");
		}

		contactList.put(contact.getContactID(), contact);
	}

	// delete contact using id
	public void deleteContact(String contactID) {
		if (!contactList.containsKey(contactID)) {
			throw new IllegalArgumentException("Could not find that contact");
		}

		contactList.remove(contactID);
	}

	// update first name
	public void updateFirstName(String contactID, String firstName) {
		if (!contactList.containsKey(contactID)) {
			throw new IllegalArgumentException("Could not find that contact");
		}

		contactList.get(contactID).setFirstName(firstName);
	}

	// update last name
	public void updateLastName(String contactID, String lastName) {
		if (!contactList.containsKey(contactID)) {
			throw new IllegalArgumentException("Could not find that contact");
		}

		contactList.get(contactID).setLastName(lastName);
	}

	// update phone number
	public void updatePhoneNumber(String contactID, String phoneNumber) {
		if (!contactList.containsKey(contactID)) {
			throw new IllegalArgumentException("Could not find that contact");
		}

		contactList.get(contactID).setPhoneNumber(phoneNumber);
	}

	// update address
	public void updateAddress(String contactID, String address) {
		if (!contactList.containsKey(contactID)) {
			throw new IllegalArgumentException("Could not find that contact");
		}

		contactList.get(contactID).setAddress(address);
	}

	// this is so the tests can pull a contact and check it
	public Contact getContact(String contactID) {
		return contactList.get(contactID);
	}

	// returns total contacts
	public int getSize() {
		return contactList.size();
	}
}