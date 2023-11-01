package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.logic.commands.LocalCourseDeleteCommand;
import seedu.address.logic.commands.LocalCourseSortCommand;
import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.PartnerCourseDeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.testutil.LocalCourseBuilder;
import seedu.address.testutil.LocalCourseUtil;
import seedu.address.testutil.PartnerCourseBuilder;
import seedu.address.testutil.PartnerCourseUtil;

public class SeplendidParserTest {

    private final SeplendidParser parser = new SeplendidParser();

    /**
     * Unit testing with stub-like seed data.
     */
    @Test
    public void parseCommand_addLocalCourse() throws Exception {
        LocalCourse localCourse = new LocalCourseBuilder().build();
        // This narrow typecast is safe as LocalCourseAddCommand is a known subtype of Command
        LocalCourseAddCommand command = (LocalCourseAddCommand) parser
                .parseCommand(LocalCourseUtil.getLocalCourseAddCommandFrom(localCourse));
        assertEquals(new LocalCourseAddCommand(localCourse), command);
    }

    @Test
    public void parseCommand_deleteLocalCourse() throws Exception {
        LocalCourse localCourse = new LocalCourseBuilder().build();
        // This narrow typecast is safe as LocalCourseDeleteCommand is a known subtype of Command
        LocalCourseDeleteCommand command = (LocalCourseDeleteCommand) parser
                .parseCommand(LocalCourseUtil.getLocalCourseDeleteCommandFrom(localCourse));
        assertEquals(new LocalCourseDeleteCommand(localCourse.getLocalCode()), command);
    }

    @Test
    public void parseCommand_sortLocalCourse() throws Exception {
        Comparator<LocalCourse> localCourseComparator = new LocalCourseComparatorByLocalCode();

        LocalCourseSortCommand command = (LocalCourseSortCommand) parser
                .parseCommand(LocalCourseUtil.getLocalCourseSortCommandFrom(localCourseComparator));
        assertEquals(new LocalCourseSortCommand(localCourseComparator), command);
    }

    @Test
    public void parseCommand_addPartnerCourse() throws Exception {
        PartnerCourse partnerCourse = new PartnerCourseBuilder().build();
        // This narrow typecast is safe as PartnerCourseAddCommand is a known subtype of Command
        PartnerCourseAddCommand command = (PartnerCourseAddCommand) parser
                .parseCommand(PartnerCourseUtil.getPartnerCourseAddCommandFrom(partnerCourse));
        assertEquals(new PartnerCourseAddCommand(partnerCourse), command);
    }

    @Test
    public void parseCommand_deletePartnerCourse() throws Exception {
        PartnerCourse partnerCourse = new PartnerCourseBuilder().build();
        // This narrow typecast is safe as PartnerCourseDeleteCommand is a known subtype of Command
        PartnerCourseDeleteCommand command = (PartnerCourseDeleteCommand) parser
                .parseCommand(PartnerCourseUtil.getPartnerCourseDeleteCommandFrom(partnerCourse));
        assertEquals(new PartnerCourseDeleteCommand(
                            partnerCourse.getPartnerUniversity().getUniversityName(),
                            partnerCourse.getPartnerCode()),
                    command);
    }


    //    @Test
    //    public void parseCommand_help() throws Exception {
    //        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
    //        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    //    }

    //    @Test
    //    public void parseCommand_list() throws Exception {
    //        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
    //        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
    //    }

    /**
     * Testing SeplendidParser class alone
     */
    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
                -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownLocalCourseCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, ()
                -> parser.parseCommand("localcourse eject args"));
    }

    @Test
    public void parseCommand_unknownPartnerCourseCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, ()
                -> parser.parseCommand("partnercourse eject args"));
    }

    @Test
    public void parseCommand_unknownUniversityCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, ()
                -> parser.parseCommand("university eject args"));
    }

}
