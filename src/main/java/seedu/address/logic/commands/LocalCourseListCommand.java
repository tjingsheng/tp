package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;

/**
 * Lists all local courses in the LocalCourseCatalogue.
 */
public class LocalCourseListCommand extends LocalCourseCommand {

    // Also available in abstract class LocalCourseCommand to support polymorphism
    public static final String LOCAL_COURSE_LIST_MESSAGE_USAGE = COMMAND_WORD
            + " list: Lists all local courses.";
    public static final String ACTION_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all local courses";

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
        seplendidModel.updateFilteredLocalCourseList(SeplendidModel.PREDICATE_SHOW_ALL_LOCAL_COURSES);
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
