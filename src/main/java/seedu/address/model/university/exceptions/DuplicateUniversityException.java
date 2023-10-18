package seedu.address.model.university.exceptions;

public class DuplicateUniversityException extends RuntimeException {
    public DuplicateUniversityException() {
        super("Operation would result in duplicate universities");
    }
}
