package seedu.address.model.sampledata;

import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.mapping.MappingMiscInformation;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.university.UniversityName;

/**
 * A utility class that provides sample mappings for seeding the application.
 */
public class SampleMappings {

    /**
     * Returns an array of sample mappings
     *
     * @return An array of sample {@code Mapping} objects.
     */
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
}
