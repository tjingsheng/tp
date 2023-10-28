package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.MappingCatalogue;
import seedu.address.model.NoteCatalogue;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyMappingCatalogue;
import seedu.address.model.ReadOnlyNoteCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.UniversityCatalogue;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalDescription;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.mapping.MappingMiscInformation;
import seedu.address.model.notes.Content;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerDescription;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerUnit;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"),
                new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"),
                new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                     .map(Tag::new)
                     .collect(Collectors.toSet());
    }

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

    public static ReadOnlyLocalCourseCatalogue getSampleLocalCourseCatalogue() {
        LocalCourseCatalogue sampleLocalCourseCatalogue = new LocalCourseCatalogue();
        for (LocalCourse sampleLocalCourse : getSampleLocalCourses()) {
            sampleLocalCourseCatalogue.addLocalCourse(sampleLocalCourse);
        }
        return sampleLocalCourseCatalogue;
    }

    public static University[] getSampleUniversities() {
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

    public static ReadOnlyUniversityCatalogue getSampleUniversityCatalogue() {
        UniversityCatalogue sampleUniversityCatalogue = new UniversityCatalogue();
        for (University sampleUniversity : getSampleUniversities()) {
            sampleUniversityCatalogue.addUniversity(sampleUniversity);
        }
        return sampleUniversityCatalogue;
    }

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

    public static ReadOnlyPartnerCourseCatalogue getSamplePartnerCourseCatalogue() {
        PartnerCourseCatalogue samplePartnerCourseCatalogue = new PartnerCourseCatalogue();
        for (PartnerCourse samplePartnerCourse : getSamplePartnerCourses()) {
            samplePartnerCourseCatalogue.addPartnerCourse(samplePartnerCourse);
        }
        return samplePartnerCourseCatalogue;
    }

    public static Note[] getSampleNotes() {
        return new Note[] {new Note(new Content("Dummy Note 1"),
                new Tag("dummy")),
                           new Note(new Content("Dummy Note 2"), new Tag("dummy"))
        };
    }

    public static ReadOnlyNoteCatalogue getSampleNoteCatalogue() {
        NoteCatalogue sampleNoteCatalogue = new NoteCatalogue();
        for (Note sampleNote : getSampleNotes()) {
            sampleNoteCatalogue.addNote(sampleNote);
        }
        return sampleNoteCatalogue;
    }

    public static Mapping[] getSampleMappings() {
        return new Mapping[] {new Mapping(
                new LocalCode("CS1101S"), new UniversityName("Yale University"),
                new PartnerCode("INFR3045"),
                new MappingMiscInformation("Both semesters.")),
                              new Mapping(new LocalCode("CS1231S"), new UniversityName("Harvard University"),
                                      new PartnerCode("COM3041"),
                                      new MappingMiscInformation("Fall semester.")),
                              new Mapping(new LocalCode("IS1108"), new UniversityName("University of Waterloo"),
                                      new PartnerCode("INFR1101"),
                                      new MappingMiscInformation("Both semesters.")),
                              new Mapping(new LocalCode("CS2100"), new UniversityName("Stanford University"),
                                      new PartnerCode("INFR3043"),
                                      new MappingMiscInformation("Both semesters.")),
                              new Mapping(new LocalCode("CS3230"), new UniversityName("Princeton University"),
                                      new PartnerCode("INFR3046"),
                                      new MappingMiscInformation("Spring semester.")),
                              new Mapping(new LocalCode("CS2105"),
                                      new UniversityName("Massachusetts Institute of Technology"),
                                      new PartnerCode("INFR3044"),
                                      new MappingMiscInformation("Both semesters.")),
                              new Mapping(new LocalCode("CS2106"),
                                      new UniversityName("University of California, Berkeley"),
                                      new PartnerCode("COM3042"),
                                      new MappingMiscInformation("Both semesters.")),
                              new Mapping(new LocalCode("CS3235"), new UniversityName("University of Oxford"),
                                      new PartnerCode("COM3047"),
                                      new MappingMiscInformation("Spring semester.")),
                              new Mapping(new LocalCode("CS2103T"), new UniversityName("Columbia University"),
                                      new PartnerCode("COMP3049"),
                                      new MappingMiscInformation("Both semesters."))
        };
    }

    public static ReadOnlyMappingCatalogue getSampleMappingCatalogue() {
        MappingCatalogue sampleMappingCatalogue = new MappingCatalogue();
        for (Mapping sampleMapping : getSampleMappings()) {
            sampleMappingCatalogue.addMapping(sampleMapping);
        }
        return sampleMappingCatalogue;
    }

}
