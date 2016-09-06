package seedu.addressbook.data.tag;

import seedu.addressbook.data.Person;

import java.util.ArrayList;

/**
 * An association class between Tag and Person classes.
 */

public class Tagging {
    
    private static ArrayList<String> list;
    private Person person;
    private Tag tag;
    private boolean isAdd;

    public Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
	this.tag = tag;
	this.isAdd = isAdd;
	this.list.add(this.toString());
    }

    @Override
    public String toString() {
        return (isAdd)?"+":"-" + " " + this.person.getName() + tag.toString();
    }

    public ArrayList<String> printModifiedTags() {
        return list;
    }
}
