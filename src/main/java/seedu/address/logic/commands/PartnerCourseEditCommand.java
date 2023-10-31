package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerDescription;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerUnit;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;
import seedu.address.seplendidui.UiUtil;

/**
 * Edits partner course.
 */
public class PartnerCourseEditCommand extends PartnerCourseCommand {
    public static final String PARTNER_COURSE_EDIT_MESSAGE_USAGE = COMMAND_WORD
            + " edit: Edits a partner course for a particular attribute - "
            + "partnercode & partnername & university & unit & description";
    public static final String ACTION_WORD = "edit";
    public static final String MESSAGE_SUCCESS = "Edited this partner course: %1$s to this: %2$s.";
    public static final String MESSAGE_NONEXISTENT_PARTNER_COURSE = "This partner course does not exist in SEPlendid.";
    public static final String MESSAGE_DUPLICATE_PARTNER_COURSE =
            "This edited partner course already exists in SEPlendid.";
    private PartnerCourse partnerCourseToEdit;
    private PartnerCourse editedPartnerCourse;

    private UniversityName universityName;
    private PartnerCode partnerCode;
    private PartnerName partnerName;

    private PartnerUnit partnerUnit;
    private PartnerDescription partnerDescription;

    private PartnerCourseAttribute partnerCourseAttribute;
    private String editedValue;

    /**
     * Creates a PartnerCourseEditCommand to edit the given partner course.
     *
     * @param universityName University name of the course to be edited.
     * @param partnerCode Partner code of the course to be edited.
     * @param partnerCourseAttribute Attribute of the course to be edited.
     * @param editedValue Edited value of the specified attribute.
     */
    public PartnerCourseEditCommand(UniversityName universityName, PartnerCode partnerCode,
                                    PartnerCourseAttribute partnerCourseAttribute, String editedValue) {
        super();
        requireAllNonNull(universityName, partnerCode, partnerCourseAttribute, editedValue);
        this.universityName = universityName;
        this.partnerCode = partnerCode;
        this.partnerCourseAttribute = partnerCourseAttribute;
        this.editedValue = editedValue;
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

        partnerCourseToEdit = seplendidModel.getPartnerCourseIfExists(partnerCode, universityName).get();

        partnerName = partnerCourseToEdit.getPartnerName();
        partnerUnit = partnerCourseToEdit.getPartnerUnit();
        partnerDescription = partnerCourseToEdit.getPartnerDescription();

        switch (partnerCourseAttribute) {
        case UNIVERSITY:
            universityName = new UniversityName(editedValue);
            break;
        case PARTNERCODE:
            partnerCode = new PartnerCode(editedValue);
            break;
        case PARTNERNAME:
            partnerName = new PartnerName(editedValue);
            break;
        case UNIT:
            partnerUnit = new PartnerUnit(editedValue);
            break;
        case DESCRIPTION:
            partnerDescription = new PartnerDescription(editedValue);
            break;
        default:
            //do nothing
        }

        editedPartnerCourse = new PartnerCourse(
                new University(universityName), partnerCode, partnerName, partnerUnit, partnerDescription);

        if (!seplendidModel.hasPartnerCourse(partnerCourseToEdit)) {
            throw new CommandException(MESSAGE_NONEXISTENT_PARTNER_COURSE);
        }

        if (seplendidModel.hasPartnerCourse(editedPartnerCourse)
                && !partnerCourseToEdit.isSamePartnerCourse(editedPartnerCourse)) {
            throw new CommandException(MESSAGE_DUPLICATE_PARTNER_COURSE);
        }

        seplendidModel.setPartnerCourse(partnerCourseToEdit, editedPartnerCourse);

        return new CommandResult(
            String.format(MESSAGE_SUCCESS, Messages.format(partnerCourseToEdit), Messages.format(editedPartnerCourse)),
            UiUtil.ListViewModel.PARTNER_COURSE_LIST);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourseEditCommand)) {
            return false;
        }

        PartnerCourseEditCommand otherPartnerCourseEditCommand = (PartnerCourseEditCommand) other;
        return partnerCourseToEdit.equals(otherPartnerCourseEditCommand.partnerCourseToEdit)
                && editedPartnerCourse.equals(otherPartnerCourseEditCommand.editedPartnerCourse);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerCourseToEdit", partnerCourseToEdit)
                .add("editedPartnerCourse", editedPartnerCourse).toString();
    }
}
