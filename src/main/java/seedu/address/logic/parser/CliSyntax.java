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


    /* Seplendid parameters */
    public static final SeplendidParameter PARAMETER_LOCALCODE = new SeplendidParameter("localcode");
    public static final SeplendidParameter PARAMETER_LOCALNAME = new SeplendidParameter("localname");
    public static final SeplendidParameter PARAMETER_LOCALUNIT = new SeplendidParameter("localunit");
    public static final SeplendidParameter PARAMETER_LOCALDESCRIPTION = new SeplendidParameter("localdescription");
    public static final SeplendidParameter PARAMETER_PARTNERCODE = new SeplendidParameter("partnercode");
    public static final SeplendidParameter PARAMETER_PARTNERNAME = new SeplendidParameter("partnername");
    public static final SeplendidParameter PARAMETER_PARTNERUNIT = new SeplendidParameter("partnerunit");
    public static final SeplendidParameter PARAMETER_PARTNERDESCRIPTION =
            new SeplendidParameter("partnerdescription");
    public static final SeplendidParameter PARAMETER_UNIVERSITY = new SeplendidParameter("university");
    public static final SeplendidParameter PARAMETER_ATTRIBUTE = new SeplendidParameter("attribute");
    public static final SeplendidParameter PARAMETER_LOCALATTRIBUTE =
            new SeplendidParameter("localattribute");
    public static final SeplendidParameter PARAMETER_PARTNERATTRIBUTE =
            new SeplendidParameter("partnerattribute");
    public static final SeplendidParameter PARAMETER_UNIVERSITYATTRIBUTE =
            new SeplendidParameter("universityattribute");
    public static final SeplendidParameter PARAMETER_UNIVERSITYNAME = new SeplendidParameter("university");
    public static final SeplendidParameter PARAMETER_CONTENT = new SeplendidParameter("content");
    public static final SeplendidParameter PARAMETER_TAGS = new SeplendidParameter("tags");
    public static final SeplendidParameter PARAMETER_INFORMATION = new SeplendidParameter("information");
    public static final SeplendidParameter PARAMETER_MAPPINGATTRIBUTE =
            new SeplendidParameter("mappingattribute");
    public static final SeplendidParameter PARAMETER_QUERY = new SeplendidParameter("query");
    public static final SeplendidParameter PARAMETER_LOCALUPDATEDVALUE =
            new SeplendidParameter("local updated value");
    public static final SeplendidParameter PARAMETER_INDEX = new SeplendidParameter("index");

}
