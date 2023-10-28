package seedu.address.model.sampledata;

import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerDescription;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerUnit;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * A utility class that provides sample mappings for seeding the application.
 */
public class SamplePartnerCourses {
    /**
     * Returns an array of sample partner courses.
     *
     * @return An array of sample {@code PartnerCourse} objects.
     */
    public static PartnerCourse[] getSamplePartnerCourses() {
        return new PartnerCourse[]{
            new PartnerCourse(
                new University(new UniversityName("Boston College")),
                new PartnerCode("COM1231"),
                new PartnerName("Discrete Mathematics"),
                new PartnerUnit(5.0),
                new PartnerDescription("Fundamental concepts in discrete mathematics.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Waterloo")),
                new PartnerCode("INFR1101"),
                new PartnerName("Ethics and Computer Security"),
                new PartnerUnit(5.0),
                new PartnerDescription("Exploration of ethical considerations in computer security.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Harvard University")),
                new PartnerCode("COM3041"),
                new PartnerName("Computational Mathematics"),
                new PartnerUnit(2.0),
                new PartnerDescription("Study of computational mathematics.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of California, Berkeley")),
                new PartnerCode("COM3042"),
                new PartnerName("Operating Systems"),
                new PartnerUnit(5.0),
                new PartnerDescription("Introduction to operating systems principles.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Stanford University")),
                new PartnerCode("INFR3043"),
                new PartnerName("Computer Architecture"),
                new PartnerUnit(5.0),
                new PartnerDescription("Study of computer architecture principles.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Massachusetts Institute of Technology")),
                new PartnerCode("INFR3044"),
                new PartnerName("Networking"),
                new PartnerUnit(5.0),
                new PartnerDescription("Introduction to computer networking concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Yale University")),
                new PartnerCode("INFR3045"),
                new PartnerName("Programming Methodology II"),
                new PartnerUnit(5.0),
                new PartnerDescription("Advanced programming methodologies.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Princeton University")),
                new PartnerCode("INFR3046"),
                new PartnerName("Introduction to Algorithms"),
                new PartnerUnit(5.0),
                new PartnerDescription("Study of algorithms and algorithmic design.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Oxford")),
                new PartnerCode("COM3047"),
                new PartnerName("Advanced Topics in Security"),
                new PartnerUnit(2.0),
                new PartnerDescription("Exploration of advanced topics in security.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Cambridge")),
                new PartnerCode("COMP3048"),
                new PartnerName("Introduction to Artificial Intelligence"),
                new PartnerUnit(2.0),
                new PartnerDescription("Overview of artificial intelligence concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Columbia University")),
                new PartnerCode("COMP3049"),
                new PartnerName("Engineering of Software"),
                new PartnerUnit(2.0),
                new PartnerDescription("Study of software engineering principles.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Chicago")),
                new PartnerCode("COMP3050"),
                new PartnerName("Introduction to Computer Vision"),
                new PartnerUnit(4.0),
                new PartnerDescription("Introduction to computer vision concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("CalTech")),
                new PartnerCode("COMP3051"),
                new PartnerName("Introduction to Natural Language Processing"),
                new PartnerUnit(4.0),
                new PartnerDescription("Overview of natural language processing.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Michigan")),
                new PartnerCode("COMP3052"),
                new PartnerName("Introduction to Computer Graphics"),
                new PartnerUnit(4.0),
                new PartnerDescription("Introduction to computer graphics concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Cornell University")),
                new PartnerCode("COM3053"),
                new PartnerName("Introduction to Computer Music"),
                new PartnerUnit(4.0),
                new PartnerDescription("Study of computer music concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("UCLA")),
                new PartnerCode("COM3054"),
                new PartnerName("Introduction to Computer Animation"),
                new PartnerUnit(2.0),
                new PartnerDescription("Introduction to computer animation concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Texas at Austin")),
                new PartnerCode("COM3055"),
                new PartnerName("Introduction to Computer Games"),
                new PartnerUnit(2.0),
                new PartnerDescription("Introduction to computer games concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("University of Pennsylvania")),
                new PartnerCode("COM3056"),
                new PartnerName("Introduction to Computer Music"),
                new PartnerUnit(3.0),
                new PartnerDescription("Introduction to computer music concepts.")
            ),
            new PartnerCourse(
                new University(new UniversityName("Northwestern University")),
                new PartnerCode("COM3057"),
                new PartnerName("Introduction to Computer Animation"),
                new PartnerUnit(3.0),
                new PartnerDescription("Introduction to computer animation concepts.")
            )
        };
    }
}
