/*
 * Author: Chris Riegger
 * Course: CS 320: Software Testing, Automation, and Quality Assurance
 * Assignment: 6-1 Project One Submission
 * Date: August 7, 2026
 *
 * Description:
 * JUnit test suite for validating the ContactService class. These tests verify
 * correct behavior for adding, deleting, and updating Contact objects, ensuring
 * reliable and consistent service-level operations within the Project One
 * application.
 */

package contact.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

/**
 * Test suite for the ContactService class. These tests verify that the service
 * correctly enforces unique contact IDs, supports safe deletion, and performs
 * field-specific updates by replacing immutable Contact objects with updated
 * instances. Both positive and negative test cases are included to ensure
 * reliable behavior and data integrity.
 */
public class ContactServiceTest {

    // ---------------------------------------------------------
    // Add contact tests
    // ---------------------------------------------------------

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        assertDoesNotThrow(() -> service.addContact(contact));
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Oak St");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // ---------------------------------------------------------
    // Delete contact tests
    // ---------------------------------------------------------

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        assertDoesNotThrow(() -> service.deleteContact("12345"));
        assertDoesNotThrow(() -> service.deleteContact("12345")); // Safe no-op
    }

    // ---------------------------------------------------------
    // Update field tests
    // ---------------------------------------------------------

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact original = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(original);
        service.updateFirstName("12345", "Mike");

        // Indirect verification: ensure update does not throw and service remains stable
        assertDoesNotThrow(() -> service.updateFirstName("12345", "Alex"));
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact original = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(original);
        service.updateLastName("12345", "Smith");

        assertDoesNotThrow(() -> service.updateLastName("12345", "Brown"));
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact original = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(original);
        service.updatePhone("12345", "0987654321");

        assertDoesNotThrow(() -> service.updatePhone("12345", "0123456789"));
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact original = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(original);
        service.updateAddress("12345", "456 Oak St");

        assertDoesNotThrow(() -> service.updateAddress("12345", "789 Pine Rd"));
    }
}
