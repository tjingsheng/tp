package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.localcourse.LocalCourseAddCommand;
import seedu.address.logic.commands.localcourse.LocalCourseDeleteCommand;
import seedu.address.logic.commands.localcourse.LocalCourseSortCommand;
import seedu.address.logic.commands.note.*;
import seedu.address.logic.commands.partnercourse.PartnerCourseAddCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseDeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.messages.UsageMessage;
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
        assertThrows(ParseException.class, UsageMessage.HELP.getValue(), ()
                -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownLocalCourseCommand_throwsParseException() {
        assertThrows(ParseException.class,
                     UsageMessage.LOCALCOURSE.getValue(), (
                     ) -> parser.parseCommand("localcourse eject args"));
    }

    @Test
    public void parseCommand_unknownPartnerCourseCommand_throwsParseException() {
        assertThrows(ParseException.class,
                     UsageMessage.PARTNERCOURSE.getValue(), (
                     ) -> parser.parseCommand("partnercourse eject args"));
    }

    @Test
    public void parseCommand_unknownUniversityCommand_throwsParseException() {
        assertThrows(ParseException.class,
                     UsageMessage.UNIVERSITY.getValue(), (
                     )-> parser.parseCommand("university eject args"));
    }

    /**
     * Positive note command parsing test cases
     */
    @Test
    public void parseCommand_addNote() throws Exception {
        String command = "note add [test note] [test]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteAddCommand;
    }

    @Test
    public void parseCommand_addNoteNumericSpecial() throws Exception {
        String command = "note add [test 1234 @#$%^&] [test]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteAddCommand;
    }

    @Test
    public void parseCommand_listNote() throws Exception {
        String command = "note list";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteListCommand;
    }

    @Test
    public void parseCommand_updateNote() throws Exception {
        String command = "note update [1] [new content]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteUpdateCommand;
    }

    @Test
    public void parseCommand_tagNote() throws Exception {
        String command = "note tag [1] [newtag]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteTagCommand;
    }

    @Test
    public void parseCommand_deleteNote() throws Exception {
        String command = "note delete [1]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteDeleteCommand;
    }

    @Test
    public void parseCommand_clearTagNote() throws Exception {
        String command = "note cleartag [1]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteClearTagCommand;
    }

    @Test
    public void parseCommand_searchNote() throws Exception {
        String command = "note search [tag]";
        Command c = parser.parseCommand(command);
        assert c instanceof NoteSearchCommand;
    }

    /**
     * Negative note command parsing test cases
     */
    @Test
    public void parseCommand_addNoteInvalidCommand_throwsParseException() {
        String command = "note_add [test] [test]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_addNoteWrongSpelling_throwsParseException() {
        String command = "not add [test] [test]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_unknownInstruction_throwsParseException() {
        String command = "note idk [test] [test]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_addNoteExtraBracket_throwsParseException() {
        String command = "note add [[111] [test]]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_addNoteExtraBrackets_throwsParseException() {
        String command = "note add [[111]] [test]]]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_listNoteExtraSpace_throwsParseException() {
        String command = "note  list          ";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_listNoteExtraArgs_throwsParseException() {
        String command = "note list 1";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_listNoteInvalidInstruction_throwsParseException() {
        String command = "note li  st";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_updateNoteInvalidInstruction_throwsParseException()  {
        String command = "note up  date [1] [new content]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_updateNoteInvalidIndex_throwsParseException() throws Exception {
        String command = "note update [1     0] [new content]";
        NoteUpdateCommand c = (NoteUpdateCommand) parser.parseCommand(command);
        assert c.getNoteIndexToUpdate() == -1;
    }

    @Test
    public void parseCommand_updateNoteNoIndex_throwsParseException()  {
        String command = "note update [] [new content]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }
    @Test
    public void parseCommand_updateNoteNoContent_throwsParseException() {
        String command = "note update [1] []";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_updateNoteNoContentMissingOneArg_throwsParseException() {
        String command = "note update [1]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_updateNoteNoBracket_throwsParseException() {
        String command = "note update 1 content";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteInvalidIndex() throws Exception {
        String command = "note tag [1   0] [newtag]";
        NoteTagCommand c = (NoteTagCommand) parser.parseCommand(command);
        assert c.getNoteIndexToUpdate() == -1;
    }

    @Test
    public void parseCommand_tagNoteNoBracket_throwsParseException() {
        String command = "note tag 1 content";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteWithSpaces_throwsParseException() {
        String command = "note tag [1] [content   content]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteWithSpecialChar_throwsParseException() {
        String command = "note tag [1] [content@content]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteInvalidInstruction_throwsParseException() {
        String command = "note tagtag [1] [content@content]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteMissingSpaceBetweenArgs_throwsParseException() {
        String command = "note tag [1][contentcontent]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_tagNoteWrongBracketType_throwsParseException() {
        String command = "note tag (1) (contentcontent)";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_deleteNoteWrongIndex_throwsParseException() throws Exception {
        String command = "note delete [1   00 0]";
        NoteDeleteCommand c = (NoteDeleteCommand) parser.parseCommand(command);
        assert c.getNoteIndexToDelete() == -1;
    }

    @Test
    public void parseCommand_deleteNoteExtraArgs_throwsParseException() {
        String command = "note delete [1000] [hi]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_deleteNoteInvalidIndex_throwsParseException() throws Exception {
        String command = "note delete [abc]";
        NoteDeleteCommand c = (NoteDeleteCommand) parser.parseCommand(command);
        assert c.getNoteIndexToDelete() == -1;
    }

    @Test
    public void parseCommand_deleteNoteExtraBracket_throwsParseException() {
        String command = "note delete [[1]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_cleartagNoteInvalidIndex_throwsParseException() throws Exception {
        String command = "note cleartag [abc]";
        NoteClearTagCommand c = (NoteClearTagCommand) parser.parseCommand(command);
        assert c.getNoteIndexToUpdate() == -1;
    }

    @Test
    public void parseCommand_cleartagNoteExtraBracket_throwsParseException() {
        String command = "note cleartag [[1]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_searchNoteEmptyArg_throwsParseException() {
        String command = "note search []";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_searchNoteArgWithSpaces_throwsParseException() {
        String command = "note search [test test]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }

    @Test
    public void parseCommand_searchNoteArgWithSpecialChar_throwsParseException() {
        String command = "note search [tes$test]";
        assertThrows(ParseException.class, () -> parser.parseCommand(command));
    }
}
