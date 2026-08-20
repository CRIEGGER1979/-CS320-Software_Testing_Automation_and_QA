/*
 * Author: Chris Riegger
 * Course: CS 320: Software Testing, Automation, and Quality Assurance
 * Assignment: 6-1 Project One Submission
 * Date: August 7, 2026
 *
 * Description:
 * Defines the Contact data model used in the Project One application.
 * This class enforces strict validation rules for contact ID, first name,
 * last name, phone number, and address to ensure reliable and consistent
 * contact information. All fields are immutable once the object is created.
 */

package contact;

/**
 * The Contact class represents an immutable contact record containing a unique
 * identifier, first name, last name, phone number, and address. All fields are
 * validated during construction to ensure data integrity within the Project One
 * application. Because Contact objects are immutable, no setters are provided.
 */
public class Contact {

    // Unique identifier for the contact (required, non-null, max 10 characters)
    private final String contactId;

    // First name (required, non-null, max 10 characters)
    private final String firstName;

    // Last name (required, non-null, max 10 characters)
    private final String lastName;

    // Phone number (required, non-null, exactly 10 characters)
    private final String phone;

    // Address (required, non-null, max 30 characters)
    private final String address;

    /**
     * Constructs a new Contact object with validation applied to all fields.
     *
     * @param contactId Unique ID, max 10 characters, cannot be null
     * @param firstName First name, max 10 characters, cannot be null
     * @param lastName  Last name, max 10 characters, cannot be null
     * @param phone     Phone number, exactly 10 characters, cannot be null
     * @param address   Address, max 30 characters, cannot be null
     *
     * @throws IllegalArgumentException if any field violates its constraints
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone number
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /** Returns the unique contact ID. */
    public String getContactId() {
        return contactId;
    }

    /** Returns the first name. */
    public String getFirstName() {
        return firstName;
    }

    /** Returns the last name. */
    public String getLastName() {
        return lastName;
    }

    /** Returns the phone number. */
    public String getPhone() {
        return phone;
    }

    /** Returns the address. */
    public String getAddress() {
        return address;
    }
}
