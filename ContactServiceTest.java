// ContactServiceTest.java
// Landon Allanson

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// shared objects for the tests
	private ContactService service;
	private Contact contact;
	private Contact contact2;

	// a new service and contacts before each test so tests don't share data
	@BeforeEach
	void setUp() {
		service = new ContactService();
		contact = new Contact("1", "Landon", "Allanson", "1234567890", "26 Knollwood Cir");
		contact2 = new Contact("2", "Nodnal", "Nosnalla", "9876543210", "62 Knollwood Dr");
	}

	// test adding a contact
	@Test
	void testAddContact() {
		service.addContact(contact);

		assertEquals(1, service.getSize());
		assertEquals("Landon", service.getContact("1").getFirstName());
	}

	// test adding two contacts with the same id
	@Test
	void testAddContactDupeID() {
		Contact sameID = new Contact("1", "Nodnal", "Nosnalla", "9876543210", "62 Knollwood Dr");

		service.addContact(contact);

		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(sameID);
		});

		// there should still only be one contact (the original)
		assertEquals(1, service.getSize());
		assertEquals("Landon", service.getContact("1").getFirstName());
	}

	// test adding a null contact
	@Test
	void testAddContactNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null);
		});

		// nothing should've been added
		assertEquals(0, service.getSize());
	}

	// test deleting a contact
	@Test
	void testDeleteContact() {
		service.addContact(contact);
		service.addContact(contact2);

		service.deleteContact("1");

		assertEquals(1, service.getSize());
		assertNull(service.getContact("1"));

		// other contact should remain
		assertEquals("Nodnal", service.getContact("2").getFirstName());
	}

	// test deleting a contact that is not there
	@Test
	void testDeleteContactNotThere() {
		service.addContact(contact);

		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("99");
		});

		// nothing should've been removed
		assertEquals(1, service.getSize());
	}

	// test updating the first name
	@Test
	void testUpdateFirstName() {
		service.addContact(contact);

		service.updateFirstName("1", "Nodnal");

		assertEquals("Nodnal", service.getContact("1").getFirstName());
	}

	// test updating the last name
	@Test
	void testUpdateLastName() {
		service.addContact(contact);

		service.updateLastName("1", "Nosnalla");

		assertEquals("Nosnalla", service.getContact("1").getLastName());
	}

	// test updating the phone number
	@Test
	void testUpdatePhoneNumber() {
		service.addContact(contact);

		service.updatePhoneNumber("1", "9876543210");

		assertEquals("9876543210", service.getContact("1").getPhoneNumber());
	}

	// test updating the address
	@Test
	void testUpdateAddress() {
		service.addContact(contact);

		service.updateAddress("1", "62 Knollwood Dr");

		assertEquals("62 Knollwood Dr", service.getContact("1").getAddress());
	}

	// test updating more than one field on the same contact
	@Test
	void testUpdateEverything() {
		service.addContact(contact);

		service.updateFirstName("1", "Nodnal");
		service.updateLastName("1", "Nosnalla");
		service.updatePhoneNumber("1", "9876543210");
		service.updateAddress("1", "62 Knollwood Dr");

		assertEquals("Nodnal", service.getContact("1").getFirstName());
		assertEquals("Nosnalla", service.getContact("1").getLastName());
		assertEquals("9876543210", service.getContact("1").getPhoneNumber());
		assertEquals("62 Knollwood Dr", service.getContact("1").getAddress());
	}

	// test updating with bad data
	@Test
	void testUpdateBadData() {
		service.addContact(contact);

		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("1", "Landonnnnnn");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("1", null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("1", "123456");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("1",
					"26 Knollwood Cir is an alright place to live, but living somewhere else would be cool");
		});

		// nothing should change
		assertEquals("Landon", service.getContact("1").getFirstName());
		assertEquals("Allanson", service.getContact("1").getLastName());
		assertEquals("1234567890", service.getContact("1").getPhoneNumber());
		assertEquals("26 Knollwood Cir", service.getContact("1").getAddress());
	}

	// test updating a contact that isn't there
	@Test
	void testUpdateContactNotThere() {
		service.addContact(contact);

		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("99", "Nodnal");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("99", "Nosnalla");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("99", "9876543210");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("99", "62 Knollwood Dr");
		});

		// the contact that is there shouldn't change
		assertEquals("Landon", service.getContact("1").getFirstName());
		assertEquals("Allanson", service.getContact("1").getLastName());
		assertEquals("1234567890", service.getContact("1").getPhoneNumber());
		assertEquals("26 Knollwood Cir", service.getContact("1").getAddress());
	}

	// test that updating one contact doesn't change the other one
	@Test
	void testUpdateOnlyChangesOneContact() {
		service.addContact(contact);
		service.addContact(contact2);

		service.updateFirstName("1", "Landen");

		assertEquals("Landen", service.getContact("1").getFirstName());
		assertEquals("Nodnal", service.getContact("2").getFirstName());
	}

	// test that the contact id doesn't change
	@Test
	void testContactIDDoesNotChange() {
		service.addContact(contact);

		service.updateFirstName("1", "Nodnal");

		assertEquals("1", service.getContact("1").getContactID());
	}
}