package seedu.addressbook.data.person;

import static org.junit.Assert.*;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name name;

    @Before
    public void setup() {
        name = new Name("Hel Lo");
    }

    /**
     * Tests for isSimilar method
     */

    @Test
    public void isSimilar_sameNames_returnsTrue() throws IllegalValueException {
        Name other = new Name("Hel Lo");
	assertTrue(name.isSimilar(other));
    }

    @Test
    public void isSimilar_similarNames_returnsTrue() throws IllegalValueException {
        Name other = new Name("hel lo");
	assertTrue(name.isSimilar(other));
    }

    @Test
    public void isSimilar_diffNames_returnsFalse() throws IllegalValueException {
        Name other = new Name("Bye bye");
	assertFalse(name.isSimilar(other));
    }
}
