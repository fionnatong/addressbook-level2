package seedu.addressbook.data.person;

/**
 * Represents a Person's address components in address book.
 * All components of the address inherit from this class.
 */

public class AddressComponent {

    private String component = null;

    public AddressComponent(String component) {
        this.component = component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void getComponent() {
        return this.component;
    }

}

