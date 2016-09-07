package seedu.addressbook.common;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class UtilsTest {

    /**
     * Tests for isAnyNull method
     */

    @Test
    public void isAnyNull_noNull_returnsFalse() {
	final Object[] test = { "No null" };
	assertFalse(Utils.isAnyNull(test));
    }

    @Test
    public void isAnyNull_hasNull_returnsTrue() {
	final Object[] test = { null };
	assertTrue(Utils.isAnyNull(test));
    }
    
    @Test
    public void isAnyNull_randomNull_returnsTrue() {
	final Object[] test = { "Haha", null };
	assertTrue(Utils.isAnyNull(test));
    }
    
    /**
     * Tests for elementsAreUnique method
     */

    @Test
    public void elementsAreUnique_allUnique_returnsTrue() {
        final ArrayList<Object> test = new ArrayList<Object>();
	test.add("Haha");
	test.add("Another haha");
	assertTrue(Utils.elementsAreUnique(test));
    }

    @Test
    public void elementsAreUnique_notUnique_returnsFalse() {
        final ArrayList<Object> test = new ArrayList<Object>();
	test.add("Haha");
	test.add("Haha");
	assertFalse(Utils.elementsAreUnique(test));
    }

    @Test
    public void elementsAreUnique_noElements_returnsTrue() {
        final ArrayList<Object> test = new ArrayList<Object>();
	assertTrue(Utils.elementsAreUnique(test));
    }
}
