package seedu.address.logic.commands.localcourse;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCodeContainsKeywordsPredicate;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;

/**
 * Finds and lists all localcourses in SEPlendid whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class LocalCourseSearchCommand extends LocalCourseCommand {
    public static final String ACTION_WORD = "search"; // Use "search" as the command word

    public static final String MESSAGE_SUCCESS = "Local courses searched: %1$s";


    public static final String LOCALCOURSE_SEARCH_MESSAGE_USAGE = COMMAND_WORD
            + " : Search local courses by attributes - localcode and localname";

    private final LocalCourseAttribute attribute;

    private final LocalCodeContainsKeywordsPredicate codePredicate;
    private final LocalNameContainsKeywordsPredicate namePredicate;

    /**
     * Creates a LocalCourseSearchCommand to sort the local course list based on the code predicate.
     * @param codePredicate Predicate use for search
     */
    public LocalCourseSearchCommand(LocalCodeContainsKeywordsPredicate codePredicate) {
        this.attribute = LocalCourseAttribute.LOCALCODE;
        this.codePredicate = codePredicate;
        this.namePredicate = null;
    }

    /**
     * Creates a LocalCourseSearchCommand to sort the local course list based on the name predicate.
     * @param namePredicate Predicate use for search
     */
    public LocalCourseSearchCommand(LocalNameContainsKeywordsPredicate namePredicate) {
        this.attribute = LocalCourseAttribute.LOCALNAME;
        this.codePredicate = null;
        this.namePredicate = namePredicate;
    }

    @Override
    public CommandResult execute(SeplendidModel model) throws CommandException {
        requireNonNull(model);

        model.searchLocalCourses(attribute, codePredicate, namePredicate);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(model.getFilteredLocalCourseList())));
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LocalCourseSearchCommand)) {
            return false;
        }

        LocalCourseSearchCommand otherLocalCourseSearchCommand = (LocalCourseSearchCommand) other;
        return attribute == otherLocalCourseSearchCommand.attribute
                && Objects.equals(codePredicate, otherLocalCourseSearchCommand.codePredicate)
                && Objects.equals(namePredicate, otherLocalCourseSearchCommand.namePredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("attribute", attribute)
                .add("codePredicate", codePredicate)
                .add("namePredicate", namePredicate)
                .toString();
    }
}

