package seedu.address.testutil;

import seedu.address.logic.commands.partnercourse.PartnerCourseAddCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseDeleteCommand;
import seedu.address.model.partnercourse.PartnerCourse;

/**
 * A utility class for PartnerCourse.
 */
public class PartnerCourseUtil {
    /**
     * Returns an add command string for adding the {@code PartnerCourse}.
     */
    public static String getPartnerCourseAddCommandFrom(PartnerCourse partnerCourse) {
        return String.format("%s %s %s",
            PartnerCourseAddCommand.COMMAND_WORD,
            PartnerCourseAddCommand.ACTION_WORD,
            getPartnerCourseArgumentsForAddCommand(partnerCourse));
    }

    /**
     * Returns the part of add command string for the given {@code PartnerCourse}'s details.
     */
    public static String getPartnerCourseArgumentsForAddCommand(PartnerCourse partnerCourse) {
        return String.format("[%s] [%s] [%s] [%s] [%s]",
            partnerCourse.getPartnerUniversity(),
            partnerCourse.getPartnerCode(),
            partnerCourse.getPartnerName(),
            partnerCourse.getPartnerUnit(),
            partnerCourse.getPartnerDescription());
    }

    /**
     * Returns a delete command string for deleting the {@code PartnerCourse}.
     */
    public static String getPartnerCourseDeleteCommandFrom(PartnerCourse partnerCourse) {
        return String.format("%s %s %s",
            PartnerCourseDeleteCommand.COMMAND_WORD,
            PartnerCourseDeleteCommand.ACTION_WORD,
            getPartnerCourseArgumentsForDeleteCommand(partnerCourse));
    }

    /**
     * Returns the part of delete command string for the given {@code PartnerCourse}'s details.
     */
    public static String getPartnerCourseArgumentsForDeleteCommand(PartnerCourse partnerCourse) {
        return String.format("[%s] [%s]",
                partnerCourse.getPartnerCode(), partnerCourse.getPartnerUniversity().getUniversityName());
    }
}
