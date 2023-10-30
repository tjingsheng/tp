package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.ObservableList;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.person.Person;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
        "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
            Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
            .append("; Phone: ")
            .append(person.getPhone())
            .append("; Email: ")
            .append(person.getEmail())
            .append("; Address: ")
            .append(person.getAddress())
            .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * Formats the {@code localCourse} for display to the user.
     * Overloaded method.
     */
    public static String format(LocalCourse localCourse) {
        final StringBuilder builder = new StringBuilder();
        builder.append("LocalCode: ")
            .append(localCourse.getLocalCode())
            .append("; LocalName: ")
            .append(localCourse.getLocalName())
            .append("; LocalUnit: ")
            .append(localCourse.getLocalUnit());
        return builder.toString();
    }

    /**
     * Formats the {@code university} for display to the user.
     * Overloaded method.
     *
     * @param university
     * @return
     */
    public static String format(University university) {
        final StringBuilder builder = new StringBuilder("UniversityName: ");
        builder.append(university.getUniversityName());
        return builder.toString();
    }

    /**
     * Formats the {@code university} for display to the user.
     * Overloaded method.
     * @param universityObservableList
     * @return
     */

    public static String formatList(ObservableList<LocalCourse> localCourseObservableList) {
        final StringBuilder builder = new StringBuilder("Localcourses: ");
        String localCourses = localCourseObservableList.stream()
                .map(localCourse -> {
                    String localName = localCourse.getLocalName().toString();
                    String localCode = localCourse.getLocalCode().toString();
                    double units = localCourse.getLocalUnit().getValue();
                    return localName + " (" + localCode + ", " + units + " units)";
                })
                .collect(Collectors.joining(", "));
        builder.append(localCourses);
        return builder.toString();
    }


    public static String format(ObservableList<University> universityObservableList) {
        final StringBuilder builder = new StringBuilder("UniversityName: ");
        String universityNames = universityObservableList.stream()
                .map(University::getUniversityName).map(UniversityName::getName).collect(Collectors.joining(", "));
        builder.append(universityNames);
        return builder.toString();
    }
    /**
     * Formats the {@code partnerCourse} for display to the user.
     * Overloaded method.
     */
    public static String format(PartnerCourse partnerCourse) {
        final StringBuilder builder = new StringBuilder();
        builder.append("PartnerUniversity: ")
            .append(partnerCourse.getPartnerUniversity())
            .append("; PartnerCode: ")
            .append(partnerCourse.getPartnerCode())
            .append("; PartnerName: ")
            .append(partnerCourse.getPartnerName())
            .append("; PartnerUnit: ")
            .append(partnerCourse.getPartnerUnit());
        return builder.toString();
    }

    /**
     * Formast the {@code mapping} for display to the user.
     * Overloaded method.
     */
    public static String format(Mapping mapping) {
        final StringBuilder builder = new StringBuilder("LocalCode: ");
        builder.append(mapping.getLocalCode())
                .append("; UniversityName: ")
                .append(mapping.getUniversityName())
                .append("; PartnerCode: ")
                .append(mapping.getPartnerCode());
        return builder.toString();
    }

    /**
     * Formats the {@code note} for display to the user.
     * Overloaded method.
     */
    public static String format(Note note) {
        return note.toString();
    }

}
