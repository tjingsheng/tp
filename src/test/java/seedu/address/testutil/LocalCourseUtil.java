package seedu.address.testutil;

import seedu.address.logic.commands.LocalCourseAddCommand;
import seedu.address.model.localcourse.LocalCourse;

/**
 * A utility class for LocalCourse.
 */
public class LocalCourseUtil {

    /**
     * Returns an add command string for adding the {@code LocalCourse}.
     */
    public static String getLocalCourseAddCommandFrom(LocalCourse localCourse) {
        return LocalCourseAddCommand.COMMAND_WORD
                + " "
                + LocalCourseAddCommand.ACTION_WORD
                + " "
                + getLocalCourseArgumentsForCommand(localCourse);
    }

    /**
     * Returns the part of command string for the given {@code localCourse}'s details.
     */
    public static String getLocalCourseArgumentsForCommand(LocalCourse localCourse) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(localCourse.getLocalCode()).append("] [");
        sb.append(localCourse.getLocalName()).append("]");
        return sb.toString();
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
