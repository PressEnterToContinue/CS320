// ContactTest.java
// Landon Allanson

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {

	// contact used by the tests
	private Contact contact;

	// set up a fresh contact before each test
	@BeforeEach
	void setUp() {
		contact = new Contact("1234567890", "Landon", "Allanson", "1234567890", "26 Knollwood Cir");
	}

	// this test makes sure a good contact works
	@Test
	void testContact() {
		assertEquals("1234567890", contact.getContactID());
		assertEquals("Landon", contact.getFirstName());
		assertEquals("Allanson", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNumber());
		assertEquals("26 Knollwood Cir", contact.getAddress());
	}

	// test id length
	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Landon", "Allanson", "1234567890", "26 Knollwood Cir");
		});
	}

	// test for null id
	@Test
	void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Landon", "Allanson", "1234567890", "26 Knollwood Cir");
		});
	}

	// test first name
	@Test
	void testFirstName() {
		// too long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landonnnnnn", "Allanson", "1234567890", "26 Knollwood Cir");
		});
		// null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Allanson", "1234567890", "26 Knollwood Cir");
		});
	}

	// test last name
	@Test
	void testLastName() {
		// too long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allansonnnn", "1234567890", "26 Knollwood Cir");
		});
		// null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", null, "1234567890", "26 Knollwood Cir");
		});
	}

	// test phone number
	@Test
	void testPhoneNumber() {
		// too short
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "123456789", "26 Knollwood Cir");
		});
		// too long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "12345678901", "26 Knollwood Cir");
		});
		// letters present
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "123ABC4567", "26 Knollwood Cir");
		});
		// null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", null, "26 Knollwood Cir");
		});
	}

	// test phone number with a plus or minus sign
	@Test
	void testPhoneNumberSign() {
		// minus sign
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "-123456789", "26 Knollwood Cir");
		});
		// plus sign
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "+123456789", "26 Knollwood Cir");
		});
	}

	// test address
	@Test
	void testAddress() {
		// too long
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "1234567890",
					"26 Knollwood Cir is an alright place to live, but living somewhere else would be cool");
		});
		// null
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Landon", "Allanson", "1234567890", null);
		});
	}

	// test max lengths to make sure they're allowed
	@Test
	void testMaxLengths() {
		Contact maxContact = new Contact("1234567890", "Landonnnnn", "Allansonnn", "1234567890",
				"123456789012345678901234567890");
		assertEquals("1234567890", maxContact.getContactID());
		assertEquals("Landonnnnn", maxContact.getFirstName());
		assertEquals("Allansonnn", maxContact.getLastName());
		assertEquals("123456789012345678901234567890", maxContact.getAddress());
	}

	// test setters to make sure they update values
	@Test
	void testSetters() {
		contact.setFirstName("Nodnal");
		assertEquals("Nodnal", contact.getFirstName());

		contact.setLastName("Nosnalla");
		assertEquals("Nosnalla", contact.getLastName());

		contact.setPhoneNumber("9876543210");
		assertEquals("9876543210", contact.getPhoneNumber());

		contact.setAddress("62 Knollwood Dr");
		assertEquals("62 Knollwood Dr", contact.getAddress());
	}

	// test setters with bad data to throw exception
	@Test
	void testSettersBadData() {
		// first name
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Landonnnnnn");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});

		// last name
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Allansonnnn");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});

		// phone number
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("123456");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("123ABC4567");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("-123456789");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber(null);
		});

		// address
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("26 Knollwood Cir is an alright place to live, but living somewhere else would be cool");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});

		// nothing should change
		assertEquals("Landon", contact.getFirstName());
		assertEquals("Allanson", contact.getLastName());
		assertEquals("1234567890", contact.getPhoneNumber());
		assertEquals("26 Knollwood Cir", contact.getAddress());
	}
}