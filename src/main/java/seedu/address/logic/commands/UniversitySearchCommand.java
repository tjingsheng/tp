package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.university.UniversityNameContainsKeywordsPredicate;
import seedu.address.seplendidui.UiUtil;
public class UniversitySearchCommand extends UniversityCommand {

    public static final String ACTION_WORD = "search";

    public static final String MESSAGE_SUCCESS = "Search [university_keyword]";

    public static final String UNIVERSITY_SEARCH_MESSAGE_USAGE = COMMAND_WORD + ": Finds all universities whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " harv";

    private final UniversityNameContainsKeywordsPredicate predicate;

    public UniversitySearchCommand(UniversityNameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(SeplendidModel model) {
        requireNonNull(model);
        model.updateFilteredUniversityList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredUniversityList().size()));
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
