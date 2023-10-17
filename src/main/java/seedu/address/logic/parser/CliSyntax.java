package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_NOTE = new Prefix("note/");


    /* Seplendid parameters */
    public static final SeplendidParameter PARAMETER_LOCALCODE = new SeplendidParameter("localcode");
    public static final SeplendidParameter PARAMETER_LOCALNAME = new SeplendidParameter("localname");
    public static final SeplendidParameter PARAMETER_CONTENT = new SeplendidParameter("content");
    public static final SeplendidParameter PARAMETER_TAGS = new SeplendidParameter("tags");

}
