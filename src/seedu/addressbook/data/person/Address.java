package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int NUM_COMPONENTS = 4;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
	this.isPrivate = isPrivate;
        
	String[] components = address.split(",");
	int lenComponents = components.length;
	for (int i = lenComponents; i < NUM_COMPONENTS; i++) {
	    components[i] = null;
	}

	this.block = new Block(components[0]);
	this.street = new Street(components[1]);
	this.unit = new Unit(components[2]);
	this.postalCode = new PostalCode(components[3]);
	
	if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public boolean isValidAddress(String test) {
        return this.block.getComponent() != null
	        && this.street.getComponent() != null
		&& this.unit.getComponent() != null
		&& this.postalCode.getComponent() != null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(this.block.getComponent());
	stringBuilder.append(", ");
	stringBuilder.append(this.street.getComponent());
	stringBuilder.append(", ");
	stringBuilder.append(this.unit.getComponent());
	stringBuilder.append(", ");
	stringBuilder.append(this.postalCode.getComponent());
	return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.getComponent().equals(((Address) other).block.getComponent()) // state check
                && this.street.getComponent().equals(((Address) other).street.getComponent())
                && this.unit.getComponent().equals(((Address) other).unit.getComponent())
                && this.postalCode.getComponent().equals(((Address) other).postalCode.getComponent()));
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
