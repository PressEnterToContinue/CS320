// Contact.java
// Landon Allanson

public class Contact {

	// variables for the contact
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	// constructor
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {

		// check contact id
		if (contactID == null) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		this.contactID = contactID;

		// check first name
		if (firstName == null) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;

		// check last name
		if (lastName == null) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;

		// check phone number
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// ensure phone number is exactly 10 digits w/ no special characters (+ or -)
		if (!phoneNumber.matches("[0-9]{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;

		// check address
		if (address == null) {
			throw new IllegalArgumentException("Invalid address");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}

	// getters
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

	// setters (contactID isn't updatable)
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (!phoneNumber.matches("[0-9]{10}")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Invalid address");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}