package seedu.address.model.sampledata;

import java.util.Arrays;

import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * A utility class that provides sample universities for seeding the application.
 */
public class SampleUniversities {
    /**
     * The `SampleUniversityName` enum represents sample university names.
     */
    public enum SampleUniversityName {
        BOSTON_COLLEGE("Boston College"),
        CALTECH("California Institute of Technology"),
        COLUMBIA_UNIVERSITY("Columbia University"),
        CORNELL_UNIVERSITY("Cornell University"),
        DUKE_UNIVERSITY("Duke University"),
        HARVARD_UNIVERSITY("Harvard University"),
        IMPERIAL_COLLEGE_OF_LONDON("Imperial College of London"),
        JOHNS_HOPKINS_UNIVERSITY("Johns Hopkins University"),
        MASSACHUSETTS_INSTITUTE_OF_TECHNOLOGY("Massachusetts Institute of Technology"),
        NORTHWESTERN_UNIVERSITY("Northwestern University"),
        PRINCETON_UNIVERSITY("Princeton University"),
        STANFORD_UNIVERSITY("Stanford University"),
        UCLA("University of California, Los Angeles"),
        UNIVERSITY_OF_CALIFORNIA_BERKELEY("University of California, Berkeley"),
        UNIVERSITY_OF_CAMBRIDGE("University of Cambridge"),
        UNIVERSITY_OF_CHICAGO("University of Chicago"),
        UNIVERSITY_OF_MICHIGAN("University of Michigan"),
        UNIVERSITY_OF_OXFORD("University of Oxford"),
        UNIVERSITY_OF_PENNSYLVANIA("University of Pennsylvania"),
        UNIVERSITY_OF_TEXAS_AT_AUSTIN("University of Texas at Austin"),
        UNIVERSITY_OF_WATERLOO("University of Waterloo"),
        YALE_UNIVERSITY("Yale University");

        private final String value;

        /**
         * Constructs a `SampleUniversityName` enum with the given formatted value.
         *
         * @param value The formatted string representation of the university name.
         */
        SampleUniversityName(String value) {
            this.value = value;
        }

        /**
         * Gets the formatted string representation of the `SampleUniversityName`.
         *
         * @return The formatted string representation of the `SampleUniversityName`.
         */
        public String toValue() {
            return this.value;
        }
    }

    /**
     * Returns an array of sample universities.
     *
     * @return An array of sample {@code University} objects.
     */
    public static University[] getSampleUniversities() {
        return Arrays.stream(SampleUniversityName.values())
                     .map(name -> new UniversityName(name.toValue()))
                     .map(University::new)
                     .toArray(University[]::new);
    }
}
