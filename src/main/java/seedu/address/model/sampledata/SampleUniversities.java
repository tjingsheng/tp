package seedu.address.model.sampledata;

import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * A utility class that provides sample universities for seeding the application.
 */
public class SampleUniversities {
    /**
     * Returns an array of sample partner courses.
     *
     * @return An array of sample {@code PartnerCourse} objects.
     */
    public static University[] getSampleUniversity() {
        return new University[]{
            new University(new UniversityName("Imperial College of London")),
            new University(new UniversityName("University of Waterloo")),
            new University(new UniversityName("Boston College")),
            new University(new UniversityName("Harvard University")),
            new University(new UniversityName("University of California, Berkeley")),
            new University(new UniversityName("Stanford University")),
            new University(new UniversityName("Massachusetts Institute of Technology")),
            new University(new UniversityName("Yale University")),
            new University(new UniversityName("Princeton University")),
            new University(new UniversityName("University of Oxford")),
            new University(new UniversityName("University of Cambridge")),
            new University(new UniversityName("Columbia University")),
            new University(new UniversityName("University of Chicago")),
            new University(new UniversityName("CalTech")),
            new University(new UniversityName("University of Michigan")),
            new University(new UniversityName("Cornell University")),
            new University(new UniversityName("UCLA")),
            new University(new UniversityName("University of Texas at Austin")),
            new University(new UniversityName("University of Pennsylvania")),
            new University(new UniversityName("Northwestern University")),
            new University(new UniversityName("Duke University")),
            new University(new UniversityName("Johns Hopkins University"))
        };
    }
}
