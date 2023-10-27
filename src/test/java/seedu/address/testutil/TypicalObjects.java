package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.MappingCatalogue;
import seedu.address.model.NoteCatalogue;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.UniversityCatalogue;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.mapping.MappingMiscInformation;
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
    public static final Double TYPICAL_LOCAL_COURSE_UNIT = 4.0;
    public static final String TYPICAL_LOCAL_COURSE_DESCRIPTION = "This course introduces the necessary conceptual "
        + "and analytical tools for systematic and rigorous development of software systems. It covers four main "
        + "areas of software development, namely object-oriented system analysis, object-oriented system modelling "
        + "and design, implementation, and testing, with emphasis on system modelling and design and implementation "
        + "of software courses that work cooperatively to fulfill the requirements of the system. Tools and "
        + "techniques for software development, such as Unified Modelling Language (UML), program specification, and "
        + "testing methods, will be taught. Major software engineering issues such as modularisation criteria, "
        + "program correctness, and software quality will also be covered.";

    public static final String TYPICAL_PARTNER_COURSE_CODE = "CS50";
    public static final String TYPICAL_PARTNER_COURSE_NAME = "Introduction to Computer Science";
    public static final Double TYPICAL_PARTNER_COURSE_UNIT = 5.0;
    public static final String TYPICAL_PARTNER_COURSE_DESCRIPTION = "This is CS50x , Harvard University's "
        + "introduction to the intellectual enterprises of computer science and the art of programming for majors and"
        + " non-majors alike, with or without prior programming experience. An entry-level course taught by David J. "
        + "Malan, CS50x teaches students how to think algorithmically and solve problems efficiently. Topics include "
        + "abstraction, algorithms, data structures, encapsulation, resource management, security, software "
        + "engineering, and web development. Languages include C, Python, SQL, and JavaScript plus CSS and HTML. "
        + "Problem sets inspired by real-world domains of biology, cryptography, finance, forensics, and gaming. The "
        + "on-campus version of CS50x , CS50, is Harvard's largest course.";

    public static final String TYPICAL_UNIVERSITY_NAME = "Typical University";
    public static final UniversityName TYPICAL_PARTNER_UNIVERSITY_NAME = new UniversityName("Harvard University");

    public static final String EDGE_CASE_VALID_LOCAL_COURSE_CODE = "S";
    public static final String EDGE_CASE_VALID_LOCAL_COURSE_NAME = " Software Testing";
    public static final Double EDGE_CASE_VALID_LOCAL_COURSE_UNIT = 0.0;
    public static final String EDGE_CASE_VALID_LOCAL_COURSE_DESCRIPTION = "a!";

    public static final String EDGE_CASE_VALID_PARTNER_COURSE_CODE = "V";
    public static final String EDGE_CASE_VALID_PARTNER_COURSE_NAME = " Game Development";
    public static final Double EDGE_CASE_VALID_PARTNER_COURSE_UNIT = 0.0;
    public static final String EDGE_CASE_VALID_PARTNER_COURSE_DESCRIPTION = "@";

    public static final String EDGE_CASE_VALID_UNIVERSITY_NAME = " School";

    public static final String INVALID_LOCAL_COURSE_CODE = "$HOW2BECOMERICH";
    public static final String INVALID_LOCAL_COURSE_NAME = " ";
    public static final Double INVALID_LOCAL_COURSE_UNIT = -1.0;

    public static final String INVALID_PARTNER_COURSE_CODE = "$H23Y1";
    public static final String INVALID_PARTNER_COURSE_NAME = " ";
    public static final Double INVALID_PARTNER_COURSE_UNIT = -1.0;


    public static final LocalCourse CS2040S = new LocalCourseBuilder().withLocalCode("CS2040S").withLocalName(
        "Data Structures & Algorithms").withLocalUnit(4.0).withLocalDescription("Fun course about algos.").build();
    public static final LocalCourse CS3230 = new LocalCourseBuilder().withLocalCode("CS3230").withLocalName(
        "Design & Analysis of Algorithms").withLocalUnit(4.0).withLocalDescription("Pain course about design.").build();
    public static final LocalCourse CS1231S = new LocalCourseBuilder().withLocalCode("CS1231S").withLocalName(
        "Discrete Structures").withLocalDescription("Course about Aiken and " + "Dueet.").withLocalUnit(4.0).build();
    public static final LocalCourse CS2030S = new LocalCourseBuilder().withLocalCode("CS2030S").withLocalName(
        "Programming Methodology II").withLocalUnit(4.0).withLocalDescription("Course about OOP.").build();
    public static final LocalCourse MA2001 = new LocalCourseBuilder().withLocalCode("MA2001").withLocalName(
        "Linear Algebra").withLocalUnit(4.0).withLocalDescription("RREF is the best.").build();
    public static final LocalCourse TYPICAL_LOCAL_COURSE = new LocalCourseBuilder().withLocalCode(
                                                                                       TYPICAL_LOCAL_COURSE_CODE)
                                                                                   .withLocalName(
                                                                                       TYPICAL_LOCAL_COURSE_NAME)
                                                                                   .withLocalUnit(
                                                                                       TYPICAL_LOCAL_COURSE_UNIT)
                                                                                   .withLocalDescription(
                                                                                       TYPICAL_LOCAL_COURSE_DESCRIPTION)
                                                                                   .build();
    public static final LocalCourse EDGE_CASE_VALID_LOCAL_COURSE = new LocalCourseBuilder().withLocalCode(
        EDGE_CASE_VALID_LOCAL_COURSE_CODE).withLocalName(EDGE_CASE_VALID_LOCAL_COURSE_NAME).withLocalUnit(
        EDGE_CASE_VALID_LOCAL_COURSE_UNIT).withLocalDescription(EDGE_CASE_VALID_LOCAL_COURSE_DESCRIPTION).build();

    // PartnerCourse
    public static final PartnerCourse TYPICAL_PARTNER_COURSE = new PartnerCourseBuilder().withPartnerUniversity(
        TYPICAL_PARTNER_UNIVERSITY_NAME).withPartnerCode(TYPICAL_PARTNER_COURSE_CODE).withPartnerName(
        TYPICAL_PARTNER_COURSE_NAME).withPartnerUnit(TYPICAL_PARTNER_COURSE_UNIT).withPartnerDescription(
        TYPICAL_PARTNER_COURSE_DESCRIPTION).build();
    public static final PartnerCourse EDGE_CASE_VALID_PARTNER_COURSE =
        new PartnerCourseBuilder().withPartnerUniversity(
            new UniversityName(EDGE_CASE_VALID_UNIVERSITY_NAME))
             .withPartnerCode(
                 EDGE_CASE_VALID_PARTNER_COURSE_CODE)
             .withPartnerName(
                 EDGE_CASE_VALID_PARTNER_COURSE_NAME)
             .withPartnerUnit(
                 EDGE_CASE_VALID_PARTNER_COURSE_UNIT)
             .withPartnerDescription(
                 EDGE_CASE_VALID_PARTNER_COURSE_DESCRIPTION)
             .build();

    public static final PartnerCourse COMP1000 = new PartnerCourseBuilder().withPartnerUniversity(new UniversityName(
                                                                               "University of Edinburgh"))
                                                                           .withPartnerCode("COMP1000")
                                                                           .withPartnerName(
                                                                               "Introduction to Programming")
                                                                           .withPartnerUnit(5.0)
                                                                           .build();
    public static final PartnerCourse COMP2000 = new PartnerCourseBuilder().withPartnerUniversity(new UniversityName(
                                                                               "University of Leeds"))
                                                                           .withPartnerCode("COMP2000")
                                                                           .withPartnerName("Introduction to Databases")
                                                                           .withPartnerUnit(5.0)
                                                                           .build();
    public static final PartnerCourse COMP3000 = new PartnerCourseBuilder().withPartnerUniversity(new UniversityName(
                                                                               "University of Zurich"))
                                                                           .withPartnerCode("COMP3000")
                                                                           .withPartnerName("Introduction to Networks")
                                                                           .withPartnerUnit(5.0)
                                                                           .build();

    public static final PartnerCourse S0402SC = new PartnerCourseBuilder().withPartnerUniversity(new UniversityName(
        "Nanyang Technological University")).withPartnerCode("S0402SC").withPartnerName("Algorithms").build();
    public static final PartnerCourse STAN3230 = new PartnerCourseBuilder().withPartnerUniversity(new UniversityName(
        "Stanford University")).withPartnerCode("STAN3230").withPartnerName("Design & Analysis of Algorithms").build();


    // University
    public static final University NTU = new University(new UniversityName("Nanyang Technological University"));
    public static final University STANFORD = new University(new UniversityName("Stanford University"));
    public static final University WATERLOO = new University(new UniversityName("University of Waterloo"));
    // Note
    public static final Note NOTE1 =
        new Note(
            new Content("Nanyang Technological University"),
            new Tag("university"));
    public static final Note NOTE2 =
        new Note(
            new Content("Application Deadline 1 December 2023"),
            new Tag("deadline"));

    // Mapping
    public static final Mapping CS2040S_TO_NTU_S0402SC = new Mapping(CS2040S.getLocalCode(),
        NTU.getUniversityName(),
        S0402SC.getPartnerCode(),
        new MappingMiscInformation("NIL"));
    public static final Mapping CS3230S_TO_STANFORD_STAN3230 = new Mapping(CS3230.getLocalCode(),
        STANFORD.getUniversityName(),
        STAN3230.getPartnerCode(),
        new MappingMiscInformation("NIL"));

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

    /**
     * Returns an {@code MappingCatalogue} with all the typical mappings.
     */
    public static MappingCatalogue getTypicalMappingCatalogue() {
        MappingCatalogue mappingCatalogue = new MappingCatalogue();
        for (Mapping mapping : getTypicalMappings()) {
            mappingCatalogue.addMapping(mapping);
        }
        return mappingCatalogue;
    }

    public static List<LocalCourse> getTypicalLocalCourses() {
        return new ArrayList<>(Arrays.asList(CS2040S, CS3230));
    }

    public static List<PartnerCourse> getTypicalPartnerCourses() {
        return new ArrayList<>(Arrays.asList(COMP1000, COMP2000, S0402SC, STAN3230));
    }

    public static List<University> getTypicalUniversities() {
        return new ArrayList<>(Arrays.asList(NTU, STANFORD));
    }

    public static List<Note> getTypicalNotes() {
        return new ArrayList<>(Arrays.asList(NOTE1, NOTE2));
    }

    public static List<Mapping> getTypicalMappings() {
        return new ArrayList<>(Arrays.asList(CS3230S_TO_STANFORD_STAN3230));
    }
}
