package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.seplendidui.UiUtil;

/**
 * Adds a local course to the LocalCourseCatalogue.
 */
public class LocalCourseAddCommand extends LocalCourseCommand {

    // Also available in abstract class LocalCourseCommand to support polymorphism
    public static final String LOCAL_COURSE_ADD_MESSAGE_USAGE = COMMAND_WORD
            + " add [localcode] [localname]: Adds a local course.";
    public static final String ACTION_WORD = "add";

    public static final String MESSAGE_SUCCESS = "New local course added: %1$s";
    public static final String MESSAGE_DUPLICATE_LOCAL_COURSE = "This local course already exists in SEPlendid";

    private final LocalCourse localCourseToAdd;

    /**
     * Creates a LocalCourseAddCommand to add the specified {@code LocalCourse}
     *
     * @param localCourse The LocalCourse to be added into Storage.
     */
    public LocalCourseAddCommand(LocalCourse localCourse) {
        super();
        requireNonNull(localCourse);
        localCourseToAdd = localCourse;
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        if (seplendidModel.hasLocalCourse(localCourseToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_LOCAL_COURSE);
        }

        seplendidModel.addLocalCourse(localCourseToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(localCourseToAdd)),
                UiUtil.ListViewModel.LOCAL_COURSE_LIST);

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalCourseAddCommand)) {
            return false;
        }

        LocalCourseAddCommand otherLocalCourseAddCommand = (LocalCourseAddCommand) other;
        return localCourseToAdd.equals(otherLocalCourseAddCommand.localCourseToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("localCourseToAdd", localCourseToAdd)
                .toString();
    }
}
