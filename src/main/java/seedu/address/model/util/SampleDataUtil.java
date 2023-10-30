package seedu.address.model.util;

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
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.person.Person;
import seedu.address.model.sampledata.SampleLocalCourses;
import seedu.address.model.sampledata.SampleMappings;
import seedu.address.model.sampledata.SampleNotes;
import seedu.address.model.sampledata.SamplePartnerCourses;
import seedu.address.model.sampledata.SamplePersons;
import seedu.address.model.sampledata.SampleUniversities;
import seedu.address.model.university.University;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return SamplePersons.getSamplePersons();
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static LocalCourse[] getSampleLocalCourses() {
        return SampleLocalCourses.getSampleLocalCourses();
    }

    public static ReadOnlyLocalCourseCatalogue getSampleLocalCourseCatalogue() {
        LocalCourseCatalogue sampleLocalCourseCatalogue = new LocalCourseCatalogue();
        for (LocalCourse sampleLocalCourse : getSampleLocalCourses()) {
            sampleLocalCourseCatalogue.addLocalCourse(sampleLocalCourse);
        }
        return sampleLocalCourseCatalogue;
    }

    public static University[] getSampleUniversities() {
        return SampleUniversities.getSampleUniversities();
    }

    public static ReadOnlyUniversityCatalogue getSampleUniversityCatalogue() {
        UniversityCatalogue sampleUniversityCatalogue = new UniversityCatalogue();
        for (University sampleUniversity : getSampleUniversities()) {
            sampleUniversityCatalogue.addUniversity(sampleUniversity);
        }
        return sampleUniversityCatalogue;
    }

    public static PartnerCourse[] getSamplePartnerCourses() {
        return SamplePartnerCourses.getSamplePartnerCourses();
    }

    public static ReadOnlyPartnerCourseCatalogue getSamplePartnerCourseCatalogue() {
        PartnerCourseCatalogue samplePartnerCourseCatalogue = new PartnerCourseCatalogue();
        for (PartnerCourse samplePartnerCourse : getSamplePartnerCourses()) {
            samplePartnerCourseCatalogue.addPartnerCourse(samplePartnerCourse);
        }
        return samplePartnerCourseCatalogue;
    }

    public static Note[] getSampleNotes() {
        return SampleNotes.getSampleNotes();
    }

    public static ReadOnlyNoteCatalogue getSampleNoteCatalogue() {
        NoteCatalogue sampleNoteCatalogue = new NoteCatalogue();
        for (Note sampleNote : getSampleNotes()) {
            sampleNoteCatalogue.addNote(sampleNote);
        }
        return sampleNoteCatalogue;
    }

    public static Mapping[] getSampleMappings() {
        return SampleMappings.getSampleMappings();
    }

    public static ReadOnlyMappingCatalogue getSampleMappingCatalogue() {
        MappingCatalogue sampleMappingCatalogue = new MappingCatalogue();
        for (Mapping sampleMapping : getSampleMappings()) {
            sampleMappingCatalogue.addMapping(sampleMapping);
        }
        return sampleMappingCatalogue;
    }
}
