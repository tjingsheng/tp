package seedu.address.model.partnercourse.exceptions;

public class DuplicatePartnerCourseException extends RuntimeException {
    public DuplicatePartnerCourseException() {
        super("Operation would result in duplicate partner courses");
    }
}
