package seedu.address.logic.commands.partnercourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.CommandResult;
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
 * Updates partner course.
 */
public class PartnerCourseUpdateCommand extends PartnerCourseCommand {
    public static final String PARTNER_COURSE_UPDATE_MESSAGE_USAGE = COMMAND_WORD
            + " update: Updates a partner course for a particular attribute - "
            + "partnercode & partnername & university & unit & description";
    public static final String ACTION_WORD = "update";
    public static final String MESSAGE_SUCCESS = "Updated this partner course: %1$s to this: %2$s.";
    public static final String MESSAGE_NONEXISTENT_PARTNER_COURSE = "This partner course does not exist in SEPlendid.";
    public static final String MESSAGE_DUPLICATE_PARTNER_COURSE =
            "This updated partner course already exists in SEPlendid.";
    private PartnerCourse partnerCourseToUpdate;
    private PartnerCourse updatedPartnerCourse;

    private UniversityName universityName;
    private PartnerCode partnerCode;
    private PartnerName partnerName;

    private PartnerUnit partnerUnit;
    private PartnerDescription partnerDescription;

    private PartnerCourseAttribute partnerCourseAttribute;
    private String updatedValue;

    /**
     * Creates a PartnerCourseEditCommand to edit the given partner course.
     *
     * @param universityName University name of the course to be edited.
     * @param partnerCode Partner code of the course to be edited.
     * @param partnerCourseAttribute Attribute of the course to be edited.
     * @param updatedValue Edited value of the specified attribute.
     */
    public PartnerCourseUpdateCommand(UniversityName universityName, PartnerCode partnerCode,
                                      PartnerCourseAttribute partnerCourseAttribute, String updatedValue) {
        super();
        requireAllNonNull(universityName, partnerCode, partnerCourseAttribute, updatedValue);
        this.universityName = universityName;
        this.partnerCode = partnerCode;
        this.partnerCourseAttribute = partnerCourseAttribute;
        this.updatedValue = updatedValue;
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

        Optional<PartnerCourse> partnerCourseToUpdateOptional =
                seplendidModel.getPartnerCourseIfExists(partnerCode, universityName);
        if (partnerCourseToUpdateOptional.isEmpty()) {
            throw new CommandException(MESSAGE_NONEXISTENT_PARTNER_COURSE);
        }

        partnerCourseToUpdate = partnerCourseToUpdateOptional.get();

        universityName = partnerCourseToUpdate.getPartnerUniversity().getUniversityName();
        partnerCode = partnerCourseToUpdate.getPartnerCode();
        partnerName = partnerCourseToUpdate.getPartnerName();
        partnerUnit = partnerCourseToUpdate.getPartnerUnit();
        partnerDescription = partnerCourseToUpdate.getPartnerDescription();

        switch (partnerCourseAttribute) {
        case PARTNERCODE:
            partnerCode = new PartnerCode(updatedValue);
            break;
        case PARTNERNAME:
            partnerName = new PartnerName(updatedValue);
            break;
        case UNIT:
            partnerUnit = new PartnerUnit(updatedValue);
            break;
        case DESCRIPTION:
            partnerDescription = new PartnerDescription(updatedValue);
            break;
        default:
            //do nothing
        }

        updatedPartnerCourse = new PartnerCourse(
                new University(universityName), partnerCode, partnerName, partnerUnit, partnerDescription);

        if (!seplendidModel.hasPartnerCourse(partnerCourseToUpdate)) {
            throw new CommandException(MESSAGE_NONEXISTENT_PARTNER_COURSE);
        }

        if (seplendidModel.hasPartnerCourse(updatedPartnerCourse)
                && !partnerCourseToUpdate.isSamePartnerCourse(updatedPartnerCourse)) {
            throw new CommandException(MESSAGE_DUPLICATE_PARTNER_COURSE);
        }

        seplendidModel.setPartnerCourse(partnerCourseToUpdate, updatedPartnerCourse);

        return new CommandResult(
            String.format(MESSAGE_SUCCESS,
                    Messages.format(partnerCourseToUpdate), Messages.format(updatedPartnerCourse)),
            UiUtil.ListViewModel.PARTNER_COURSE_LIST);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourseUpdateCommand)) {
            return false;
        }

        PartnerCourseUpdateCommand otherPartnerCourseUpdateCommand = (PartnerCourseUpdateCommand) other;
        return universityName.equals(otherPartnerCourseUpdateCommand.universityName)
                && partnerCode.equals(otherPartnerCourseUpdateCommand.partnerCode)
                && partnerCourseAttribute.equals(otherPartnerCourseUpdateCommand.partnerCourseAttribute)
                && updatedValue.equals(otherPartnerCourseUpdateCommand.updatedValue);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerCourseToEdit", partnerCourseToUpdate)
                .add("editedPartnerCourse", updatedPartnerCourse).toString();
    }
}
