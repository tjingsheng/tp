package seedu.address.testutil;

import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * A utility class to help with building PartnerCourse objects.
 */
public class PartnerCourseBuilder {

    public static final String DEFAULT_PARTNER_CODE = "COMP5330";
    public static final String DEFAULT_PARTNER_NAME = "Database Systems for Advanced Machine Learning";
    public static final UniversityName DEFAULT_PARTNER_UNIVERSITY = new UniversityName("University of Waterloo");

    private PartnerCode partnerCode;
    private PartnerName partnerName;
    private University partnerUniversity;

    /**
     * Creates a {@code PartnerCourseBuilder} with the default details.
     */
    public PartnerCourseBuilder() {
        partnerCode = new PartnerCode(DEFAULT_PARTNER_CODE);
        partnerName = new PartnerName(DEFAULT_PARTNER_NAME);
        partnerUniversity = new University(DEFAULT_PARTNER_UNIVERSITY);
    }

    /**
     * Initializes the PartnerCourseBuilder with the data of {@code partnerCourseToCopy}.
     */
    public PartnerCourseBuilder(PartnerCourse partnerCourseToCopy) {
        partnerCode = partnerCourseToCopy.getPartnerCode();
        partnerName = partnerCourseToCopy.getPartnerName();
        partnerUniversity = partnerCourseToCopy.getPartnerUniversity();
    }

    /**
     * Sets the {@code PartnerCode} of the {@code PartnerCourse} that we are building.
     */
    public PartnerCourseBuilder withPartnerCode(String partnerCode) {
        this.partnerCode = new PartnerCode(partnerCode);
        return this;
    }

    /**
     * Sets the {@code PartnerName} of the {@code PartnerCourse} that we are building.
     */
    public PartnerCourseBuilder withPartnerName(String partnerName) {
        this.partnerName = new PartnerName(partnerName);
        return this;
    }

    /**
     * Sets the {@code PartnerUniversity} of the {@code PartnerCourse} that we are building.
     */
    public PartnerCourseBuilder withPartnerUniversity(UniversityName partnerUniversity) {
        this.partnerUniversity = new University(partnerUniversity);
        return this;
    }

    public PartnerCourse build() {
        return new PartnerCourse(partnerUniversity, partnerCode, partnerName);
    }

}
