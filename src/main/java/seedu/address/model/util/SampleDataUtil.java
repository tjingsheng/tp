package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.NoteCatalogue;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyNoteCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.UniversityCatalogue;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalDescription;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;
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
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"), new Address(
                "Blk 30 Geylang Street 29, #06-40"), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"), new Address(
                "Blk 436 Serangoon Gardens Street 26, #16-43"), getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"), new Address(
                "Blk 47 Tampines Street 20, #17-35"), getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), getTagSet("colleagues"))};
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
        return Arrays.stream(strings).map(Tag::new).collect(Collectors.toSet());
    }

    public static LocalCourse[] getSampleLocalCourses() {
        return new LocalCourse[] {
            new LocalCourse(
                new LocalCode("CS1101S"),
                new LocalName("Programming Methodology I"),
                new LocalUnit(4.0),
                new LocalDescription(
                    "This course introduces the concepts of programming and computational problem solving, and is the "
                    + "first and foremost introductory course to computing. Starting from a small core of fundamental"
                    + " abstractions, the course introduces programming as a method for communicating computational "
                    + "processes. The course begins with purely functional programming based on a simple "
                    + "substitution-based execution model, and ends with a powerful modern imperative language based "
                    + "on a realistic environment-based execution model. Topics covered include: functional "
                    + "abstraction, recursion, higher-order functions, data abstraction, algorithmic strategies, "
                    + "state mutation, loops and arrays, evaluation strategies, sorting and searching, debugging and "
                    + "testing."
                )
            ),
            new LocalCourse(
                new LocalCode("CS1231S"),
                new LocalName("Discrete Structures"),
                new LocalUnit(4.0),
                new LocalDescription(
                    "This course introduces mathematical tools required in the study of computer science. Topics "
                    + "include: (1) Logic and proof techniques: propositions, quantifications. (2) Relations "
                    + "and Functions: Equivalence relations and partitions. Partially ordered sets. Well-Ordering "
                    + "Principle. Function equality. Boolean/identity/inverse functions. Bijection. (3) Mathematical "
                    + "formulation of data models (linear model, trees, graphs). (4) Counting and Combinatoric: "
                    + "Pigeonhole Principle. Inclusion-Exclusion Principle. Number of relations on a set, number of "
                    + "injections from one finite set to another, Diagonalization proof: An infinite countable set "
                    + "has an uncountable power set; Algorithmic proof: An infinite set has a countably infinite "
                    + "subset. Subsets of countable sets are countable."
                )
            ),
            new LocalCourse(
                new LocalCode("IS1108"),
                new LocalName("Digital Ethics and Data Privacy"),
                new LocalUnit(4.0),
                new LocalDescription(
                    "Course is designed to introduce students to the issues of digital ethics and privacy faced by "
                    + "individuals and organizations. It covers the ethical principles governing the behaviors and "
                    + "beliefs about how we use technology, and how we collect and process personal information in a "
                    + "manner that aligns with individual and organizational expectations for security and "
                    + "confidentiality. It will address challenges in balancing technological desirability with "
                    + "social desirability while developing digital products and services, including Professional "
                    + "Ethics, Computing for Social Good, Digital Ethics by Design, Digital Intellectual Property "
                    + "Rights, Automation and Autonomous Systems, and Artificial Intelligence Ethics and Governance."
                )
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
        return new University[] {new University(new UniversityName("Imperial College of London")),
            new University(new UniversityName("University of Waterloo")),
            new University(new UniversityName("Boston College")),
            new University(new UniversityName("Harvard University"))};
    }

    public static ReadOnlyUniversityCatalogue getSampleUniversityCatalogue() {
        UniversityCatalogue sampleUniversityCatalogue = new UniversityCatalogue();
        for (University sampleUniversity : getSampleUniversities()) {
            sampleUniversityCatalogue.addUniversity(sampleUniversity);
        }
        return sampleUniversityCatalogue;
    }

    public static PartnerCourse[] getSamplePartnerCourses() {
        return new PartnerCourse[] {
            new PartnerCourse(
                new University(new UniversityName("Boston College")),
                new PartnerCode("COM1231"),
                new PartnerName("Discrete Mathematics"),
                new PartnerUnit(5.0),
                new PartnerDescription("Fun math module.")),
            new PartnerCourse(
                new University(new UniversityName("University of Waterloo")),
                new PartnerCode("INFR1101"),
                new PartnerName("Computer Security"),
                new PartnerUnit(5.0),
                new PartnerDescription("Fun security module.")),
            new PartnerCourse(
                new University(new UniversityName("Harvard University")),
                new PartnerCode("COM3041"),
                new PartnerName("Computer Networks"),
                new PartnerUnit(2.0),
                new PartnerDescription("Fun network module."))};
    }

    public static ReadOnlyPartnerCourseCatalogue getSamplePartnerCourseCatalogue() {
        PartnerCourseCatalogue samplePartnerCourseCatalogue = new PartnerCourseCatalogue();
        for (PartnerCourse samplePartnerCourse : getSamplePartnerCourses()) {
            samplePartnerCourseCatalogue.addPartnerCourse(samplePartnerCourse);
        }
        return samplePartnerCourseCatalogue;
    }

    public static Note[] getSampleNotes() {
        return new Note[] {new Note(new Content("Dummy Note 1"), new Tag("dummy")),
            new Note(new Content("Dummy Note 2"), new Tag("dummy"))};
    }

    public static ReadOnlyNoteCatalogue getSampleNoteCatalogue() {
        NoteCatalogue sampleNoteCatalogue = new NoteCatalogue();
        for (Note sampleNote : getSampleNotes()) {
            sampleNoteCatalogue.addNote(sampleNote);
        }
        return sampleNoteCatalogue;
    }
}
