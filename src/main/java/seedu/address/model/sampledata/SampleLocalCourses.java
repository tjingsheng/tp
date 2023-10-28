package seedu.address.model.sampledata;

import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalDescription;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;

/**
 * A utility class that provides sample local courses for seeding the application.
 */
public class SampleLocalCourses {

    /**
     * Returns an array of sample local courses.
     *
     * @return An array of sample {@code LocalCourse} objects.
     */
    public static LocalCourse[] getSampleLocalCourses() {
        return new LocalCourse[]{
            new LocalCourse(
                new LocalCode("CS1101S"),
                new LocalName("Programming Methodology I"),
                new LocalUnit(4.0),
                new LocalDescription("Introduction to the fundamentals of programming.")
            ),
            new LocalCourse(
                new LocalCode("CS1231S"),
                new LocalName("Discrete Structures"),
                new LocalUnit(4.0),
                new LocalDescription("Fundamental concepts in discrete mathematics.")
            ),
            new LocalCourse(
                new LocalCode("IS1108"),
                new LocalName("Digital Ethics and Data Privacy"),
                new LocalUnit(4.0),
                new LocalDescription("Exploration of ethical considerations in data privacy.")
            ),
            new LocalCourse(
                new LocalCode("CS2100"),
                new LocalName("Computer Organisation"),
                new LocalUnit(4.0),
                new LocalDescription("Study of computer architecture and organization.")
            ),
            new LocalCourse(
                new LocalCode("CS2103T"),
                new LocalName("Software Engineering"),
                new LocalUnit(4.0),
                new LocalDescription("Introduction to software engineering principles.")
            ),
            new LocalCourse(
                new LocalCode("CS2105"),
                new LocalName("Introduction to Computer Networks"),
                new LocalUnit(4.0),
                new LocalDescription("Fundamental concepts in computer networking.")
            ),
            new LocalCourse(
                new LocalCode("CS2106"),
                new LocalName("Introduction to Operating Systems"),
                new LocalUnit(4.0),
                new LocalDescription("Overview of operating systems principles.")
            ),
            new LocalCourse(
                new LocalCode("CS3230"),
                new LocalName("Design and Analysis of Algorithms"),
                new LocalUnit(4.0),
                new LocalDescription("Study of algorithms and algorithmic design.")
            ),
            new LocalCourse(
                new LocalCode("CS3235"),
                new LocalName("Computer Security"),
                new LocalUnit(4.0),
                new LocalDescription("Introduction to computer security concepts.")
            )
        };
    }

}
