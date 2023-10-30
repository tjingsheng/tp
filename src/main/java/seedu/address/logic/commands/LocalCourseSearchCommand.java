package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCodeContainsKeywordsPredicate;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class LocalCourseSearchCommand extends LocalCourseCommand {
    public static final String ACTION_WORD = "search"; // Use "search" as the command word

    public static final String MESSAGE_SUCCESS = "Local courses searched: %1$s";

    public static final String LOCALCOURSE_SEARCH_MESSAGE_USAGE = COMMAND_WORD
            + " : Search local courses by attributes - localcode and localname";

    private final LocalCourseAttribute attribute;

    private final LocalCodeContainsKeywordsPredicate codePredicate;
    private final LocalNameContainsKeywordsPredicate namePredicate;

    public LocalCourseSearchCommand(LocalCodeContainsKeywordsPredicate codePredicate) {
        this.attribute = LocalCourseAttribute.LOCALCODE;
        this.codePredicate = codePredicate;
        this.namePredicate = null; // Initialize to null; you can add support for both predicates if needed
    }

    public LocalCourseSearchCommand(LocalNameContainsKeywordsPredicate namePredicate) {
        this.attribute = LocalCourseAttribute.LOCALNAME;
        this.codePredicate = null; // Initialize to null; you can add support for both predicates if needed
        this.namePredicate = namePredicate;
    }

    @Override
    public CommandResult execute(SeplendidModel model) throws CommandException {
        requireNonNull(model);

        // You need to implement the search logic here based on the attribute and predicates
        // You can use the attribute to determine what to search by (local code or local name)
        // Then, use the corresponding predicate to filter the results in the model

        // For now, let's assume you have a method in the model to perform the search
        model.searchLocalCourses(attribute, codePredicate, namePredicate);

        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getSearchResults()));
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

