package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.commands.CommandResult;

import java.util.List;

/**
 * Formatter of addressbook ui.
 */
public class Formatter {
    
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private static StringBuilder stringBuilder;

    public Fomatter() {
        this.stringBuilder = new StringBuilder();
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    public boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Returns the message that prompts command from user.
     */
    public static String formatUserCommandMessage() {
        return LINE_PREFIX + "Enter command: ";
    }

    /**
     * Returns the message when user enters a command.
     */
    public static String formatReceivedCommand(String command) {
        return "[Command entered:" + command + "]";
    }

    public static String formatWelcomeMessage(String version, String storageFilePath) {
        String[] message = new String[] { DIVIDER,
                                          DIVIDER,
                                          MESSAGE_WELCOME,
                                          version,
                                          MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                                          storageFileInfo,
                                          String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
                                          DIVIDE };
        return messageToString(message);
    }

    public static String formatGoodbyeMessage() {
        String[] message = new String[] { MESSAGE_GOODBYE, DIVIDER, DIVIDER };
	return messageToString(message);
    }

    public static String formatInitFailedMessage() {
        String[] message = new String[] { MESSAGE_INIT_FAILED, DIVIDER, DIVIDER };
	return messageToString(message);
    }

    /**
     * Converts array of strings into a formatted message.
     */
    private static String messageToString(String message) {
        stringBuilder.setLength(0);
	for (String m : message) {
	    stringBuilder.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
	return stringBuilder.toString();
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
