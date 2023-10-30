package seedu.address.logic.commands.partnercourse;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.localcourse.LocalCourseSearchCommand;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCodeContainsKeywordsPredicate;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;
import seedu.address.model.partnercourse.PartnerCourse;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Finds and lists all partnercourses in SEPlendid whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class PartnerCourseSearchCommand extends PartnerCourseCommand {
    public static final String ACTION_WORD = "search"; // Use "search" as the command word

    public static final String MESSAGE_SUCCESS = "Local courses searched: %1$s";


    public static final String PARTNERCOURSE_SEARCH_MESSAGE_USAGE = COMMAND_WORD
            + " : Search local courses by attributes - partnercode and partnername";

    private final PartnerCourseAttribute attribute;

    private final PartnerCodeContainsKeywordsPredicate codePredicate;
    private final PartnerNameContainsKeywordsPredicate namePredicate;

    /**
     * Creates a LocalCourseSearchCommand to sort the local course list based on the code predicate.
     * @param codePredicate Predicate use for search
     */
    public PartnerCourseSearchCommand(PartnerCodeContainsKeywordsPredicate codePredicate) {
        this.attribute = PartnerCourseAttribute.LOCALCODE;
        this.codePredicate = codePredicate;
        this.namePredicate = null;
    }

    /**
     * Creates a LocalCourseSearchCommand to sort the local course list based on the name predicate.
     * @param namePredicate Predicate use for search
     */
    public PartnerCourseSearchCommand(PartnerNameContainsKeywordsPredicate namePredicate) {
        this.attribute = PartnerCourseAttribute.LOCALNAME;
        this.codePredicate = null;
        this.namePredicate = namePredicate;
    }

    @Override
    public CommandResult execute(SeplendidModel model) throws CommandException {
        requireNonNull(model);

        model.searchPartnerCourses(attribute, codePredicate, namePredicate);

        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(model.getFilteredPartnerCourseList())));
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

        PartnerCourseSearchCommand otherPartnerCourseSearchCommand = (PartnerCourseSearchCommand) other;
        return attribute == otherPartnerCourseSearchCommand.attribute
                && Objects.equals(codePredicate, otherPartnerCourseSearchCommand.codePredicate)
                && Objects.equals(namePredicate, otherPartnerCourseSearchCommand.namePredicate);
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
