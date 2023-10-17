package seedu.address.model.partnercourse.exceptions;

public class PartnerCourseNotFoundException extends RuntimeException {
    public PartnerCourseNotFoundException() {
        super("Partner course does not exist");
    }
}
