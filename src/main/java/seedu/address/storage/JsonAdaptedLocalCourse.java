package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalName;

/**
 * Jackson-friendly version of {@link LocalCourse}.
 */
class JsonAdaptedLocalCourse {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "LocalCourse's %s field is missing!";

    private final String localCode;
    private final String localName;


    /**
     * Constructs a {@code JsonAdaptedLocalCourse} with the given localCourse details.
     */
    @JsonCreator
    public JsonAdaptedLocalCourse(@JsonProperty("localCode") String localCode,
                                  @JsonProperty("localName") String localName) {
        this.localCode = localCode;
        this.localName = localName;
    }

    /**
     * Converts a given {@code LocalCourse} into this class for Jackson use.
     */
    public JsonAdaptedLocalCourse(LocalCourse source) {
        localCode = source.getLocalCode().value;
        localName = source.getLocalName().value;
    }

    /**
     * Converts this Jackson-friendly adapted localCourse object into the model's {@code LocalCourse} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted localCourse.
     */
    public LocalCourse toModelType() throws IllegalValueException {

        if (localCode == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, LocalCode.class.getSimpleName()));
        }
        if (!LocalCode.isValidLocalCode(localCode)) {
            throw new IllegalValueException(LocalCode.MESSAGE_CONSTRAINTS);
        }
        final LocalCode modelLocalCode = new LocalCode(localCode);

        if (localName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    LocalName.class.getSimpleName()));
        }
        if (!LocalName.isValidLocalName(localName)) {
            throw new IllegalValueException(LocalName.MESSAGE_CONSTRAINTS);
        }
        final LocalName modelLocalName = new LocalName(localName);

        return new LocalCourse(modelLocalCode, modelLocalName);
    }

}
