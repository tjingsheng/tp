package seedu.address.logic.commands.localcourse;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.seplendidui.UiUtil;

/**
 * Sorts local course list.
 */
public class LocalCourseSortCommand extends LocalCourseCommand {
    public static final String LOCAL_COURSE_SORT_MESSAGE_USAGE = COMMAND_WORD
            + " sort: Sorts all local courses by attributes - localcode & localname";
    public static final String ACTION_WORD = "sort";

    public static final String MESSAGE_SUCCESS = "Sorted all local courses";

    private final Comparator<LocalCourse> comparator;

    /**
     * Creates a LocalCourseSortCommand to sort the local course list.
     * @param comparator Comparator used for sorting
     */
    public LocalCourseSortCommand(Comparator<LocalCourse> comparator) {
        this.comparator = comparator;
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
        seplendidModel.updateSortedLocalList(comparator);
        return new CommandResult(MESSAGE_SUCCESS,
                UiUtil.ListViewModel.LOCAL_COURSE_SORT);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalCourseSortCommand)) {
            return false;
        }

        LocalCourseSortCommand otherLocalCourseSortCommand = (LocalCourseSortCommand) other;
        return comparator.equals(otherLocalCourseSortCommand.comparator);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("localCourseAttributeToSort", comparator)
                .toString();
    }
}
