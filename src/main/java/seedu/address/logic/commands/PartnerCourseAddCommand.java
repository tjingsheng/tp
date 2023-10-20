package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * Adds a partner course to the PartnerCourseCatalogue.
 */
public class PartnerCourseAddCommand extends PartnerCourseCommand {
    public static final String PARTNER_COURSE_ADD_MESSAGE_USAGE = COMMAND_WORD
            + "add [university] [partnercode] [partnername]: Adds a partner course.";
    public static final String ACTION_WORD = "add";
    public static final String MESSAGE_SUCCESS = "New partner course added: %1$s";
    public static final String MESSAGE_DUPLICATE_LOCAL_COURSE = "This partner course already exists in SEPlendid.";

    private final PartnerCourse partnerCourseToAdd;

    /**
     * Creates a PartnerCourseAddCommand to add the specified {@code partnerCourse}
     *
     * @param partnerCourse The partnerCourse to be added into Storage.
     */
    public PartnerCourseAddCommand(PartnerCourse partnerCourse) {
        super();
        requireNonNull(partnerCourse);
        partnerCourseToAdd = partnerCourse;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        if (seplendidModel.hasPartnerCourse(partnerCourseToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_LOCAL_COURSE);
        }

        seplendidModel.addPartnerCourse(partnerCourseToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(partnerCourseToAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourseAddCommand)) {
            return false;
        }

        PartnerCourseAddCommand otherPartnerCourseAddCommand = (PartnerCourseAddCommand) other;
        return partnerCourseToAdd.equals(otherPartnerCourseAddCommand.partnerCourseToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerCourseToAdd", partnerCourseToAdd)
                .toString();
    }
}
