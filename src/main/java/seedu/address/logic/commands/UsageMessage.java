package seedu.address.logic.commands;

import seedu.address.logic.commands.localcourse.LocalCourseAddCommand;
import seedu.address.logic.commands.localcourse.LocalCourseCommand;
import seedu.address.logic.commands.localcourse.LocalCourseDeleteCommand;
import seedu.address.logic.commands.localcourse.LocalCourseListCommand;
import seedu.address.logic.commands.localcourse.LocalCourseSearchCommand;
import seedu.address.logic.commands.localcourse.LocalCourseSortCommand;
import seedu.address.logic.commands.localcourse.LocalCourseUpdateCommand;
import seedu.address.logic.commands.mapping.MappingAddCommand;
import seedu.address.logic.commands.mapping.MappingCommand;
import seedu.address.logic.commands.mapping.MappingDeleteCommand;
import seedu.address.logic.commands.mapping.MappingListCommand;
import seedu.address.logic.commands.mapping.MappingSearchCommand;
import seedu.address.logic.commands.note.NoteAddCommand;
import seedu.address.logic.commands.note.NoteClearTagCommand;
import seedu.address.logic.commands.note.NoteCommand;
import seedu.address.logic.commands.note.NoteDeleteCommand;
import seedu.address.logic.commands.note.NoteListCommand;
import seedu.address.logic.commands.note.NoteSearchCommand;
import seedu.address.logic.commands.note.NoteTagCommand;
import seedu.address.logic.commands.note.NoteUpdateCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseAddCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseDeleteCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseListCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseSearchCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseSortCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseUpdateCommand;
import seedu.address.logic.commands.university.UniversityCommand;
import seedu.address.logic.commands.university.UniversityListCommand;
import seedu.address.logic.commands.university.UniversitySearchCommand;
import seedu.address.logic.commands.university.UniversitySortCommand;

/**
 * Enum for command usage messages.
 */
public enum UsageMessage {
    LOCALCOURSE_ADD(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseAddCommand.ACTION_WORD,
        "[localcode] [localname] [units] [description]",
        "Adds a local course"),
    LOCALCOURSE_DELETE(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseDeleteCommand.ACTION_WORD,
        "[localcode]",
        "Deletes a local course"),
    LOCALCOURSE_LIST(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseListCommand.ACTION_WORD,
        "",
        "Lists all local courses"),
    LOCALCOURSE_SEARCH(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseSearchCommand.ACTION_WORD,
        "[attribute] [query]",
        "Searches for a local course where query is found in the selected attribute\nAttributes:\n"
            + "localcode\nlocalname\ndescription"),
    LOCALCOURSE_SORT(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseSortCommand.ACTION_WORD,
        "[attribute]",
        "Sorts local courses by the selected attribute\nAttributes:\n"
            + "localcode\nlocalname"),
    LOCALCOURSE_UPDATE(
        LocalCourseCommand.COMMAND_WORD,
        LocalCourseUpdateCommand.ACTION_WORD,
        "[localcode] [attribute] [newvalue]",
        "Updates the attribute of the local course with a new value.\nAttributes:\n"
            + "localcode\nlocalname\nunits\ndescription'"),
    LOCALCOURSE(String.join("\n",
                    "Local Courses Commands:\n",
                    LOCALCOURSE_ADD.getValue(),
                    LOCALCOURSE_LIST.getValue(),
                    LOCALCOURSE_UPDATE.getValue(),
                    LOCALCOURSE_DELETE.getValue(),
                    LOCALCOURSE_SEARCH.getValue(),
                    LOCALCOURSE_SORT.getValue())),
    MAPPING_ADD(
        MappingCommand.COMMAND_WORD,
        MappingAddCommand.ACTION_WORD,
        "[localcode] [university] [partnercode] [information]",
        "Adds a mapping to the mapping catalogue"),
    MAPPING_DELETE(
        MappingCommand.COMMAND_WORD,
        MappingDeleteCommand.ACTION_WORD,
        "[localcode] [university] [partnercode]",
        "Deletes a course mapping."),
    MAPPING_LIST(
        MappingCommand.COMMAND_WORD,
        MappingListCommand.ACTION_WORD,
        "",
        "Lists all mappings"),
    MAPPING_SEARCH(
        MappingCommand.COMMAND_WORD,
        MappingSearchCommand.ACTION_WORD,
        "[attribute] [query]",
        "Searches for a mapping where query is found in the selected attribute\nAttributes:\n"
        + "localcode\nlocalname\npartnercode\npartnername\nuniversity\ninformation"),
    MAPPING_SORT(
        MappingCommand.COMMAND_WORD,
        MappingSearchCommand.ACTION_WORD,
        "[attribute]",
        "Sorts local courses by the selected attribute\nAttributes:\n"
            + "localcode\nlocalname\npartnercode\npartnername\nuniversity\ninformation"),
    MAPPING(String.join("\n",
                        "Mapping Commands:\n",
                        MAPPING_LIST.getValue(),
                        MAPPING_ADD.getValue(),
                        MAPPING_DELETE.getValue(),
                        MAPPING_SEARCH.getValue(),
                        MAPPING_SORT.getValue())),
    NOTE_ADD(
        NoteCommand.COMMAND_WORD,
        NoteAddCommand.ACTION_WORD,
        "[content] [tags]",
        "Adds a note"),
    NOTE_DELETE(
        NoteCommand.COMMAND_WORD,
        NoteDeleteCommand.ACTION_WORD,
        "[index]",
        "Deletes a note"),
    NOTE_LIST(
        NoteCommand.COMMAND_WORD,
        NoteListCommand.ACTION_WORD,
        "",
        "Lists all notes"),
    NOTE_SEARCH(
        NoteCommand.COMMAND_WORD,
        NoteSearchCommand.ACTION_WORD,
        "[query]",
        "Searches for notes with query is found in the note tag"),
    NOTE_TAG(
        NoteCommand.COMMAND_WORD,
        NoteTagCommand.ACTION_WORD,
        "[index] [tag]",
        "Add a tag to a note"),
    NOTE_UPDATE(
        NoteCommand.COMMAND_WORD,
        NoteUpdateCommand.ACTION_WORD,
        "[index] [content]",
        "Updates a note to the specified content"),
    NOTE_CLEAR_TAG(
        NoteCommand.COMMAND_WORD,
        NoteClearTagCommand.ACTION_WORD,
        "[index]",
        "Removes all tags to a note"),
    NOTE(String.join("\n",
                     "Note Commands:\n",
                     NOTE_ADD.getValue(),
                     NOTE_CLEAR_TAG.getValue(),
                     NOTE_DELETE.getValue(),
                     NOTE_LIST.getValue(),
                     NOTE_SEARCH.getValue(),
                     NOTE_TAG.getValue(),
                     NOTE_UPDATE.getValue())),
    PARTNERCOURSE_ADD(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseAddCommand.ACTION_WORD,
        "[university] [partnercode] [partnername] [units] [description]",
        "Adds a partner course"),
    PARTNERCOURSE_DELETE(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseDeleteCommand.ACTION_WORD,
        "[university] [partnercode] ",
        "Deletes a partner course"),
    PARTNERCOURSE_LIST(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseListCommand.ACTION_WORD,
        "",
        "Lists all partner courses"),
    PARTNERCOURSE_SEARCH(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseSearchCommand.ACTION_WORD,
        "[attribute] [query]",
        "Searches for a partner course where query is found in the selected attribute\nAttributes:\n"
            + "partnercode\npartnername\ndescription\nuniversity"),
    PARTNERCOURSE_SORT(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseSortCommand.ACTION_WORD,
        "[attribute]",
        "Sorts partner courses by the selected attribute\nAttributes:\n"
            + "partnercode\npartnername\nuniversity"),
    PARTNERCOURSE_UPDATE(
        PartnerCourseCommand.COMMAND_WORD,
        PartnerCourseUpdateCommand.ACTION_WORD,
        "[university] [partnercode] [attribute] [newvalue]",
        "Updates the attribute of the partner course with a new value.\nAttributes:\n"
            + "partnercode\npartnername\nunits\ndescription"),
    PARTNERCOURSE(String.join("\n",
                              "Partner Course Commands:\n",
                              PARTNERCOURSE_LIST.getValue(),
                              PARTNERCOURSE_ADD.getValue(),
                              PARTNERCOURSE_UPDATE.getValue(),
                              PARTNERCOURSE_DELETE.getValue(),
                              PARTNERCOURSE_SEARCH.getValue(),
                              PARTNERCOURSE_SORT.getValue())),
    UNIVERSITY_LIST(
        UniversityCommand.COMMAND_WORD,
        UniversityListCommand.ACTION_WORD,
        "",
        "Lists all universities"),
    UNIVERSITY_SEARCH(
        UniversityCommand.COMMAND_WORD,
        UniversitySearchCommand.ACTION_WORD,
        "[attribute] [query]",
        "Searches for a university where query is found in the selected attribute\nAttributes:\n"
            + "university\n"),
    UNIVERSITY_SORT(
        UniversityCommand.COMMAND_WORD,
        UniversitySortCommand.ACTION_WORD,
        "[attribute]",
        "Sorts universities by the selected attribute\nAttributes:\n"
            + "university"),
    UNIVERSITY(String.join("\n",
                           "University Commands:\n",
                           UNIVERSITY_LIST.getValue(),
                           UNIVERSITY_SEARCH.getValue(),
                           UNIVERSITY_SORT.getValue())),
    HELP(
        HelpCommand.COMMAND_WORD,
        "",
        "",
        "Shows a help window for the program usage");

    private final String value;

    /**
     * Constructs a UsageMessage with the specified value.
     *
     * @param description The usage message value.
     */
    UsageMessage(String description) {
        this.value = description;
    }

    /**
     * Constructs a UsageMessage with the specified values.
     *
     * @param commandWord The command word for the command.
     * @param actionWord The action word for the command.
     * @param args The arguments for the command.
     * @param description The description of the command.
     */
    UsageMessage(String commandWord, String actionWord, String args, String description) {
        this.value = String.format(">>> %s %s %s\n%s\n", commandWord, actionWord, args, description);
    }

    /**
     * Gets the value of the usage message.
     *
     * @return The usage message value.
     */
    public String getValue() {
        return value;
    }
}
