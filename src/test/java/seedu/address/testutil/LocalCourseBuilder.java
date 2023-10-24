package seedu.address.testutil;

import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;

/**
 * A utility class to help with building LocalCourse objects.
 */
public class LocalCourseBuilder {

    public static final String DEFAULT_LOCAL_CODE = "CS2103T";
    public static final String DEFAULT_LOCAL_NAME = "Software Engineering";
    public static final Double DEFAULT_LOCAL_UNIT = 4.0;

    private LocalCode localCode;
    private LocalName localName;
    private LocalUnit localUnit;

    /**
     * Creates a {@code LocalCourseBuilder} with the default details.
     */
    public LocalCourseBuilder() {
        localCode = new LocalCode(DEFAULT_LOCAL_CODE);
        localName = new LocalName(DEFAULT_LOCAL_NAME);
        localUnit = new LocalUnit(DEFAULT_LOCAL_UNIT);
    }

    /**
     * Initializes the LocalCourseBuilder with the data of {@code localCourseToCopy}.
     */
    public LocalCourseBuilder(LocalCourse localCourseToCopy) {
        localCode = localCourseToCopy.getLocalCode();
        localName = localCourseToCopy.getLocalName();
        localUnit = localCourseToCopy.getLocalUnit();
    }

    /**
     * Sets the {@code LocalCode} of the {@code LocalCourse} that we are building.
     */
    public LocalCourseBuilder withLocalCode(String localCode) {
        this.localCode = new LocalCode(localCode);
        return this;
    }

    /**
     * Sets the {@code LocalName} of the {@code LocalCourse} that we are building.
     */
    public LocalCourseBuilder withLocalName(String localName) {
        this.localName = new LocalName(localName);
        return this;
    }

    /**
     * Sets the {@code LocalName} of the {@code LocalCourse} that we are building.
     */
    public LocalCourseBuilder withLocalUnit(Double localUnit) {
        this.localUnit = new LocalUnit(localUnit);
        return this;
    }


    public LocalCourse build() {
        return new LocalCourse(localCode, localName, localUnit);
    }

}
