package seedu.addressbook.data.person;

/**
 * Represents a Person's contact in address book.
 */

public class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String contactComponent, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
	this.value = contactComponent.trim();
    }

    /**
     * Returns true if a given string is a valid contact component.
     */
    public static boolean isValidContactComponent(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    @Override
    public String toString() {
        return value;
    }
}
