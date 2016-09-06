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

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
