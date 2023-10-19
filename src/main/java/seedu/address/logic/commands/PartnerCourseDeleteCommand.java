package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * Deletes a partner course in PartnerCourseCatalogue.
 */
public class PartnerCourseDeleteCommand extends PartnerCourseCommand {
    public static final String PARTNER_COURSE_DELETE_MESSAGE_USAGE = COMMAND_WORD
            + "delete [university] [partnercode] [partnername]: Deletes a partner course.";
    public static final String ACTION_WORD = "delete";
    public static final String MESSAGE_SUCCESS = "Partner course deleted: %1$s";
    public static final String MESSAGE_NONEXISTENT_PARTNER_COURSE = "This partner course does not exist in SEPlendid.";

    private final PartnerCode partnerCodeToDelete;
    private PartnerCourse partnerCourseToDelete;

    /**
     * Creates a PartnerCourseDeleteCommand to delete the specified {@code partnerCourse}
     *
     * @param partnerCode The partnerCourse to be deleted in Storage.
     */
    public PartnerCourseDeleteCommand(PartnerCode partnerCode) {
        super();
        requireNonNull(partnerCode);
        partnerCodeToDelete = partnerCode;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        ObservableList<PartnerCourse> partnerCourseObservableList = seplendidModel.getFilteredPartnerCourseList();

        partnerCourseToDelete = partnerCourseObservableList.filtered(
                partnerCourse -> partnerCourse.getPartnerCode().equals(partnerCodeToDelete)).get(0);

        requireNonNull(partnerCourseToDelete);

        if (!seplendidModel.hasPartnerCourse(partnerCourseToDelete)) {
            throw new CommandException(MESSAGE_NONEXISTENT_PARTNER_COURSE);
        }

        seplendidModel.deletePartnerCourse(partnerCourseToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(partnerCourseToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourseDeleteCommand)) {
            return false;
        }

        PartnerCourseDeleteCommand otherPartnerCourseDeleteCommand = (PartnerCourseDeleteCommand) other;
        return partnerCourseToDelete.equals(otherPartnerCourseDeleteCommand.partnerCourseToDelete);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerCourseToDelete", partnerCourseToDelete)
                .toString();
    }
}
