/*
 * Author: Chris Riegger
 * Course: CS 320: Software Testing, Automation, and Quality Assurance
 * Assignment: 6-1 Project One Submission
 * Date: August 7, 2026
 *
 * Description:
 * JUnit test suite for validating the Contact class. These tests verify correct
 * construction behavior and enforcement of all field validation rules, ensuring
 * reliable and consistent contact information within the Project One application.
 */

package contact.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.Contact;

/**
 * Test suite for the Contact class. These tests verify that all validation rules
 * for contact ID, first name, last name, phone number, and address are properly
 * enforced. Both positive and negative test cases are included to ensure robust
 * behavior and data integrity.
 */
public class ContactTest {

    // ---------------------------------------------------------
    // Valid object creation
    // ---------------------------------------------------------

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // ---------------------------------------------------------
    // Getter and integrity tests
    // ---------------------------------------------------------

    @Test
    public void testContactGetters() {
        Contact contact = new Contact("99999", "Jane", "Smith", "0987654321", "456 Oak St");

        assertEquals("99999", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    public void testContactIntegrity() {
        Contact contact = new Contact("11111", "Alice", "Brown", "1112223333", "789 Pine Rd");

        assertNotNull(contact.getContactId());
        assertNotNull(contact.getFirstName());
        assertNotNull(contact.getLastName());
        assertNotNull(contact.getPhone());
        assertNotNull(contact.getAddress());
    }

    // ---------------------------------------------------------
    // Boundary-valid ID tests
    // ---------------------------------------------------------

    @Test
    public void testValidContactIdMinLength() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        assertEquals("1", contact.getContactId());
    }

    @Test
    public void testValidContactIdMaxLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "Address");
        assertEquals("1234567890", contact.getContactId());
    }

    // ---------------------------------------------------------
    // Boundary-valid first name tests
    // ---------------------------------------------------------

    @Test
    public void testValidFirstNameMinLength() {
        Contact contact = new Contact("12345", "J", "Doe", "1234567890", "Address");
        assertEquals("J", contact.getFirstName());
    }

    @Test
    public void testValidFirstNameMaxLength() {
        Contact contact = new Contact("12345", "JohnSmithX", "Doe", "1234567890", "Address");
        assertEquals("JohnSmithX", contact.getFirstName());
    }

    // ---------------------------------------------------------
    // Boundary-valid last name tests
    // ---------------------------------------------------------

    @Test
    public void testValidLastNameMinLength() {
        Contact contact = new Contact("12345", "John", "D", "1234567890", "Address");
        assertEquals("D", contact.getLastName());
    }

    @Test
    public void testValidLastNameMaxLength() {
        Contact contact = new Contact("12345", "John", "DoeSmithX", "1234567890", "Address");
        assertEquals("DoeSmithX", contact.getLastName());
    }

    // ---------------------------------------------------------
    // Boundary-valid phone tests
    // ---------------------------------------------------------

    @Test
    public void testValidPhoneExactLength() {
        Contact contact = new Contact("12345", "John", "Doe", "0123456789", "Address");
        assertEquals("0123456789", contact.getPhone());
    }

    @Test
    public void testValidPhoneNonDigitsAllowed() {
        Contact contact = new Contact("12345", "John", "Doe", "ABCDEFGHIJ", "Address");
        assertEquals("ABCDEFGHIJ", contact.getPhone());
    }

    // ---------------------------------------------------------
    // Boundary-valid address tests
    // ---------------------------------------------------------

    @Test
    public void testValidAddressMinLength() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "A");
        assertEquals("A", contact.getAddress());
    }

    @Test
    public void testValidAddressMaxLength() {
        String addr30 = "123456789012345678901234567890"; // 30 chars
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", addr30);
        assertEquals(addr30, contact.getAddress());
    }

    @Test
    public void testValidAddressMidLength() {
        String addr15 = "123456789012345"; // 15 chars
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", addr15);
        assertEquals(addr15, contact.getAddress());
    }

    // ---------------------------------------------------------
    // Multi-field boundary-valid combinations
    // ---------------------------------------------------------

    @Test
    public void testAllFieldsMinLength() {
        Contact contact = new Contact("1", "J", "D", "1234567890", "A");

        assertEquals("1", contact.getContactId());
        assertEquals("J", contact.getFirstName());
        assertEquals("D", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("A", contact.getAddress());
    }

    @Test
    public void testAllFieldsMaxLength() {
        String addr30 = "123456789012345678901234567890";
        Contact contact = new Contact("1234567890", "JohnSmithX", "DoeSmithX", "0123456789", addr30);

        assertEquals("1234567890", contact.getContactId());
        assertEquals("JohnSmithX", contact.getFirstName());
        assertEquals("DoeSmithX", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals(addr30, contact.getAddress());
    }

    // ---------------------------------------------------------
    // Null value validation tests
    // ---------------------------------------------------------

    @Test
    public void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    // ---------------------------------------------------------
    // Too-long value validation tests
    // ---------------------------------------------------------

    @Test
    public void testLongContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890",
                    "123 Main Street Apartment Building Complex");
        });
    }

    // ---------------------------------------------------------
    // Invalid phone number length test
    // ---------------------------------------------------------

    @Test
    public void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St");
        });
    }
}
