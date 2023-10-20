package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.NoteCatalogue;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.UniversityCatalogue;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.notes.Content;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.tag.Tag;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * A utility class containing a list of SEPlendid objects to use in tests.
 */
public class TypicalObjects {

    public static final String TYPICAL_LOCAL_COURSE_CODE = "CS2103";
    public static final String TYPICAL_LOCAL_COURSE_NAME = "Software Engineering";

    public static final String TYPICAL_PARTNER_COURSE_CODE = "CS50";
    public static final String TYPICAL_PARTNER_COURSE_NAME = "Introduction to Computer Science";

    public static final String TYPICAL_UNIVERSITY_NAME = "Typical University";
    public static final UniversityName TYPICAL_PARTNER_UNIVERSITY_NAME = new UniversityName("Harvard University");

    public static final String EDGE_CASE_VALID_LOCAL_COURSE_CODE = "S";
    public static final String EDGE_CASE_VALID_LOCAL_COURSE_NAME = " Software Testing";
    public static final String INVALID_LOCAL_COURSE_CODE = "$HOW2BECOMERICH";
    public static final String INVALID_LOCAL_COURSE_NAME = " ";

    public static final LocalCourse CS2040S = new LocalCourseBuilder().withLocalCode("CS2040S")
            .withLocalName("Data Structures & Algorithms").build();
    public static final LocalCourse CS3230 = new LocalCourseBuilder().withLocalCode("CS3230")
            .withLocalName("Design & Analysis of Algorithms").build();
    public static final LocalCourse CS1231S = new LocalCourseBuilder().withLocalCode("CS1231S")
            .withLocalName("Discrete Structures").build();
    public static final LocalCourse CS2030S = new LocalCourseBuilder().withLocalCode("CS2030S")
            .withLocalName("Programming Methodology II").build();
    public static final LocalCourse MA2001 = new LocalCourseBuilder().withLocalCode("MA2001")
            .withLocalName("Linear Algebra").build();
    public static final LocalCourse TYPICAL_LOCAL_COURSE = new LocalCourseBuilder()
            .withLocalCode(TYPICAL_LOCAL_COURSE_CODE).withLocalName(TYPICAL_LOCAL_COURSE_NAME).build();
    public static final LocalCourse EDGE_CASE_VALID_LOCAL_COURSE = new LocalCourseBuilder()
            .withLocalCode(EDGE_CASE_VALID_LOCAL_COURSE_CODE).withLocalName(EDGE_CASE_VALID_LOCAL_COURSE_NAME).build();

    // PartnerCourse
    public static final PartnerCourse TYPICAL_PARTNER_COURSE = new PartnerCourseBuilder()
            .withPartnerUniversity(TYPICAL_PARTNER_UNIVERSITY_NAME).withPartnerCode(TYPICAL_PARTNER_COURSE_CODE)
            .withPartnerName(TYPICAL_PARTNER_COURSE_NAME).build();

    public static final PartnerCourse COMP1000 = new PartnerCourseBuilder()
            .withPartnerUniversity(new UniversityName("University of Edinburgh"))
            .withPartnerCode("COMP1000").withPartnerName("Introduction to Programming").build();
    public static final PartnerCourse COMP2000 = new PartnerCourseBuilder()
            .withPartnerUniversity(new UniversityName("University of Leeds"))
            .withPartnerCode("COMP2000").withPartnerName("Introduction to Databases").build();
    public static final PartnerCourse COMP3000 = new PartnerCourseBuilder()
            .withPartnerUniversity(new UniversityName("University of Zurich"))
            .withPartnerCode("COMP3000").withPartnerName("Introduction to Networks").build();

    // University
    public static final University NTU = new University(new UniversityName("Nanyang Technological University"));
    public static final University STANFORD = new University(new UniversityName("Stanford University"));
    public static final University WATERLOO = new University(new UniversityName("University of Waterloo"));
    // Note
    public static final Note NOTE1 = new Note(new Content("Nanyang Technological University"),
            new Tag("university"));
    public static final Note NOTE2 = new Note(new Content("Application Deadline 1 December 2023"),
            new Tag("deadline"));
    private TypicalObjects() {
    } // prevents instantiation

    /**
     * Returns an {@code LocalCourseCatalogue} with all the typical localCourses.
     */
    public static LocalCourseCatalogue getTypicalLocalCourseCatalogue() {
        LocalCourseCatalogue localCourseCatalogue = new LocalCourseCatalogue();
        for (LocalCourse localCourse : getTypicalLocalCourses()) {
            localCourseCatalogue.addLocalCourse(localCourse);
        }
        return localCourseCatalogue;
    }

    /**
     * Returns an {@code PartnerCourseCatalogue} with all the typical partnerCourses.
     */
    public static PartnerCourseCatalogue getTypicalPartnerCourseCatalogue() {
        PartnerCourseCatalogue partnerCourseCatalogue = new PartnerCourseCatalogue();
        for (PartnerCourse partnerCourse : getTypicalPartnerCourses()) {
            partnerCourseCatalogue.addPartnerCourse(partnerCourse);
        }
        return partnerCourseCatalogue;
    }

    /**
     * Returns an {@code UniversityCatalogue} with all the typical universities.
     */
    public static UniversityCatalogue getTypicalUniversityCatalogue() {
        UniversityCatalogue universityCatalogue = new UniversityCatalogue();
        for (University university : getTypicalUniversities()) {
            universityCatalogue.addUniversity(university);
        }
        return universityCatalogue;
    }

    /**
     * Returns an {@code NoteCatalogue} with all the typical notes.
     */
    public static NoteCatalogue getTypicalNoteCatalogue() {
        NoteCatalogue noteCatalogue = new NoteCatalogue();
        for (Note note : getTypicalNotes()) {
            noteCatalogue.addNote(note);
        }
        return noteCatalogue;
    }

    public static List<LocalCourse> getTypicalLocalCourses() {
        return new ArrayList<>(Arrays.asList(CS2040S, CS3230));
    }

    public static List<PartnerCourse> getTypicalPartnerCourses() {
        return new ArrayList<>(Arrays.asList(COMP1000, COMP2000));
    }

    public static List<University> getTypicalUniversities() {
        return new ArrayList<>(Arrays.asList(NTU, STANFORD));
    }
    public static List<Note> getTypicalNotes() {
        return new ArrayList<>(Arrays.asList(NOTE1, NOTE2));
    }
}
