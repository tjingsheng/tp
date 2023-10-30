package seedu.address.testutil;

import java.util.Comparator;

import seedu.address.logic.commands.localcourse.LocalCourseAddCommand;
import seedu.address.logic.commands.localcourse.LocalCourseDeleteCommand;
import seedu.address.logic.commands.localcourse.LocalCourseSortCommand;
import seedu.address.model.localcourse.LocalCourse;

/**
 * A utility class for LocalCourse.
 */
public class LocalCourseUtil {

    /**
     * Returns an add command string for adding the {@code LocalCourse}.
     */
    public static String getLocalCourseAddCommandFrom(LocalCourse localCourse) {
        return String.format("%s %s %s",
            LocalCourseAddCommand.COMMAND_WORD,
            LocalCourseAddCommand.ACTION_WORD,
            getLocalCourseArgumentsForAddCommand(localCourse));
    }

    /**
     * Returns the part of the add command string for the given {@code localCourse}'s details.
     */
    public static String getLocalCourseArgumentsForAddCommand(LocalCourse localCourse) {
        return String.format("[%s] [%s] [%s] [%s]",
            localCourse.getLocalCode(),
            localCourse.getLocalName(),
            localCourse.getLocalUnit(),
            localCourse.getLocalDescription());
    }

    /**
     * Returns a delete command string for deleting the {@code LocalCourse}.
     */
    public static String getLocalCourseDeleteCommandFrom(LocalCourse localCourse) {
        return String.format("%s %s %s",
            LocalCourseDeleteCommand.COMMAND_WORD,
            LocalCourseDeleteCommand.ACTION_WORD,
            getLocalCourseArgumentsForDeleteCommand(localCourse));
    }

    /**
     * Returns the part of delete command string for the given {@code LocalCourse}'s details.
     */
    public static String getLocalCourseArgumentsForDeleteCommand(LocalCourse localCourse) {
        return String.format("[%s]", localCourse.getLocalCode());
    }

    public static String getLocalCourseSortCommandFrom(Comparator<LocalCourse> localCourseComparator) {
        return String.format("%s %s %s",
                LocalCourseSortCommand.COMMAND_WORD,
                LocalCourseSortCommand.ACTION_WORD,
                getLocalCourseArgumentsForSortCommand(localCourseComparator));
    }

    public static String getLocalCourseArgumentsForSortCommand(Comparator<LocalCourse> comparator) {
        return String.format("[%s]", comparator.toString());
    }


    // TBD: modify for the purpose of seplendid
    //    /**
    //     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
    //     */
    //    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
    //        StringBuilder sb = new StringBuilder();
    //        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
    //        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
    //        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
    //        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
    //        if (descriptor.getTags().isPresent()) {
    //            Set<Tag> tags = descriptor.getTags().get();
    //            if (tags.isEmpty()) {
    //                sb.append(PREFIX_TAG);
    //            } else {
    //                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
    //            }
    //        }
    //        return sb.toString();
    //    }

}
