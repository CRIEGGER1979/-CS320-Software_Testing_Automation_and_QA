/*
 * Author: Chris Riegger
 * Course: CS 320: Software Testing, Automation, and Quality Assurance
 * Assignment: 6-1 Project One Submission
 * Date: August 7, 2026
 *
 * Description:
 * Provides service-level operations for managing Contact objects, including
 * creation, deletion, and field-specific updates. This service enforces unique
 * contact identifiers and uses immutable Contact objects to ensure predictable
 * and consistent behavior within the Project One application.
 */

package contact;

import java.util.ArrayList;
import java.util.List;

/**
 * The ContactService class manages Contact objects using an in-memory list.
 * Because Contact objects are immutable, updates are performed by creating
 * new Contact instances with modified fields while preserving the original
 * contact ID. This service enforces unique identifiers and provides controlled
 * access for adding, updating, and deleting contacts.
 */
public class ContactService {

    // Stores Contact objects in an in-memory list
    private final List<Contact> contacts = new ArrayList<>();

    /**
     * Adds a new contact to the service.
     * The contact ID must be unique to prevent duplicate records.
     *
     * @param contact The Contact object to add
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(Contact contact) {

        // Prevent duplicate IDs to maintain data integrity
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Duplicate contact ID");
            }
        }

        contacts.add(contact);
    }

    /**
     * Deletes a contact from the service using its ID.
     * If the ID does not exist, the operation completes silently.
     *
     * @param contactId The unique ID of the contact to delete
     */
    public void deleteContact(String contactId) {

        // Safe removal using predicate-based filtering
        contacts.removeIf(c -> c.getContactId().equals(contactId));
    }

    /**
     * Updates the first name of a contact by creating a new Contact object
     * with the updated field while preserving all other values.
     *
     * @param contactId     The ID of the contact to update
     * @param newFirstName  The new first name to apply
     */
    public void updateFirstName(String contactId, String newFirstName) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getContactId().equals(contactId)) {

                // Create a new Contact object with updated first name
                Contact updated = new Contact(
                        c.getContactId(),
                        newFirstName,
                        c.getLastName(),
                        c.getPhone(),
                        c.getAddress()
                );

                contacts.set(i, updated);
                return;
            }
        }
    }

    /**
     * Updates the last name of a contact by creating a new Contact object
     * with the updated field while preserving all other values.
     *
     * @param contactId    The ID of the contact to update
     * @param newLastName  The new last name to apply
     */
    public void updateLastName(String contactId, String newLastName) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getContactId().equals(contactId)) {

                Contact updated = new Contact(
                        c.getContactId(),
                        c.getFirstName(),
                        newLastName,
                        c.getPhone(),
                        c.getAddress()
                );

                contacts.set(i, updated);
                return;
            }
        }
    }

    /**
     * Updates the phone number of a contact by creating a new Contact object
     * with the updated field while preserving all other values.
     *
     * @param contactId  The ID of the contact to update
     * @param newPhone   The new phone number to apply
     */
    public void updatePhone(String contactId, String newPhone) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getContactId().equals(contactId)) {

                Contact updated = new Contact(
                        c.getContactId(),
                        c.getFirstName(),
                        c.getLastName(),
                        newPhone,
                        c.getAddress()
                );

                contacts.set(i, updated);
                return;
            }
        }
    }

    /**
     * Updates the address of a contact by creating a new Contact object
     * with the updated field while preserving all other values.
     *
     * @param contactId    The ID of the contact to update
     * @param newAddress   The new address to apply
     */
    public void updateAddress(String contactId, String newAddress) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);

            if (c.getContactId().equals(contactId)) {

                Contact updated = new Contact(
                        c.getContactId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getPhone(),
                        newAddress
                );

                contacts.set(i, updated);
                return;
            }
        }
    }
}
