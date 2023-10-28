package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.university.UniversityNameContainsKeywordsPredicate;
import seedu.address.seplendidui.UiUtil;

import static java.util.Objects.requireNonNull;

public class LocalCourseSeachCommand extends LocalCourseCommand {

    public static final String ACTION_WORD = "search";

    public static final String MESSAGE_SUCCESS = "Local courses searched: %1$s";

    public static final String MESSAGE_NONEXISTENT_UNIVERSITIES = "This localcourse does not exist in SEPlendid";

    public static final String LOCALSEARCH_SEARCH_MESSAGE_USAGE = COMMAND_WORD
            + " search : Search all local courses by attributes- localcode and localname";

    private final
    private final LocalNameContainsKeywordsPredicate name_predicate;

    public UniversitySearchCommand(UniversityNameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(SeplendidModel model) throws CommandException {
        requireNonNull(model);

        model.getSearchUniversityIfExists(predicate);

        if (model.getFilteredUniversityList().isEmpty()) {
            throw new CommandException(MESSAGE_NONEXISTENT_UNIVERSITIES);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(model.getFilteredUniversityList())),
                UiUtil.ListViewModel.UNIVERSITY_LIST);
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

        // instanceof handles nulls
        if (!(other instanceof UniversitySearchCommand)) {
            return false;
        }

        UniversitySearchCommand otherUniversitySearchCommand = (UniversitySearchCommand) other;
        return predicate.equals(otherUniversitySearchCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
