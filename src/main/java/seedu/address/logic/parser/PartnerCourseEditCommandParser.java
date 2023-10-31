package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_EDITEDVALUE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERATTRIBUTE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITYNAME;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.PartnerCourseEditCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerDescription;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerUnit;
import seedu.address.model.university.UniversityName;

/**
 * Parses input arguments and creates a new PartnerCourseEditCommand object.
 */
public class PartnerCourseEditCommandParser implements Parser<PartnerCourseEditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PartnerCourseEditCommand
     * and returns a PartnerCourseEditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public PartnerCourseEditCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseEditCommand.PARTNER_COURSE_EDIT_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap = SeplendidArgumentTokenizer.tokenize(args,
                PARAMETER_UNIVERSITYNAME,
                PARAMETER_PARTNERCODE,
                PARAMETER_PARTNERATTRIBUTE,
                PARAMETER_EDITEDVALUE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_UNIVERSITYNAME,
                PARAMETER_PARTNERCODE,
                PARAMETER_PARTNERATTRIBUTE,
                PARAMETER_EDITEDVALUE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseEditCommand.PARTNER_COURSE_EDIT_MESSAGE_USAGE));
        }

        UniversityName universityName =
                ParserUtil.parseUniversityName(parameterToArgMap.getValue(PARAMETER_UNIVERSITYNAME).get());
        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
        PartnerCourseAttribute partnerCourseAttribute = ParserUtil.parsePartnerCourseAttributeForEdit(
                parameterToArgMap.getValue(PARAMETER_PARTNERATTRIBUTE).get());
        String editedValue = parseEditedValue(partnerCourseAttribute,
                parameterToArgMap.getValue(PARAMETER_EDITEDVALUE).get());

        return new PartnerCourseEditCommand(universityName, partnerCode, partnerCourseAttribute, editedValue);
    }

    private String parseEditedValue(PartnerCourseAttribute partnerCourseAttribute, String editedValue)
            throws ParseException {
        switch (partnerCourseAttribute) {
        case UNIVERSITY:
            if (!UniversityName.isValidUniversityName(editedValue)) {
                throw new ParseException(UniversityName.MESSAGE_CONSTRAINTS);
            }
            break;
        case PARTNERCODE:
            if (!PartnerCode.isValidPartnerCode(editedValue)) {
                throw new ParseException(PartnerCode.MESSAGE_CONSTRAINTS);
            }
            break;
        case PARTNERNAME:
            if (!PartnerName.isValidPartnerName(editedValue)) {
                throw new ParseException(PartnerName.MESSAGE_CONSTRAINTS);
            }
            break;
        case UNIT:
            if (!PartnerUnit.isValidPartnerUnit(editedValue)) {
                throw new ParseException(PartnerUnit.MESSAGE_CONSTRAINTS);
            }
            break;
        case DESCRIPTION:
            if (!PartnerDescription.isValidPartnerDescription(editedValue)) {
                throw new ParseException(PartnerDescription.MESSAGE_CONSTRAINTS);
            }
            break;
        default:
            //do nothing
        }
        return editedValue;
    }
}
