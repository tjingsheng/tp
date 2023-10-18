package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.*;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerName;
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
        return new Person[] {new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
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
        return new LocalCourse[] {new LocalCourse(new LocalCode("CS1101S"),
                new LocalName("Programming Methodology I")),
                                  new LocalCourse(new LocalCode("CS1231S"), new LocalName("Discrete Structures"))
        };
    }

    public static ReadOnlyLocalCourseCatalogue getSampleLocalCourseCatalogue() {
        LocalCourseCatalogue sampleLocalCourseCatalogue = new LocalCourseCatalogue();
        for (LocalCourse sampleLocalCourse : getSampleLocalCourses()) {
            sampleLocalCourseCatalogue.addLocalCourse(sampleLocalCourse);
        }
        return sampleLocalCourseCatalogue;
    }

    public static PartnerCourse[] getSamplePartnerCourses() {
        return new PartnerCourse[] {new PartnerCourse(new University(new UniversityName("")), new PartnerCode("CS1101S"),
                new PartnerName("Programming Methodology I")),
                new PartnerCourse(new University(new UniversityName("")), new PartnerCode("CS1231S"),
                        new PartnerName("Discrete Structures"))
        };
    }

    public static ReadOnlyPartnerCourseCatalogue getSamplePartnerCourseCatalogue() {
        PartnerCourseCatalogue samplePartnerCourseCatalogue = new PartnerCourseCatalogue();
        for (PartnerCourse samplePartnerCourse : getSamplePartnerCourses()) {
            samplePartnerCourseCatalogue.addPartnerCourse(samplePartnerCourse);
        }
        return samplePartnerCourseCatalogue;
    }

}
