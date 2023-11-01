package seedu.address.logic.parser;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERATTRIBUTE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITYNAME;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UPDATEDVALUE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.PartnerCourseUpdateCommand;
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
public class PartnerCourseUpdateCommandParser implements Parser<PartnerCourseUpdateCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PartnerCourseEditCommand
     * and returns a PartnerCourseEditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public PartnerCourseUpdateCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseUpdateCommand.PARTNER_COURSE_UPDATE_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap = SeplendidArgumentTokenizer.tokenize(args,
                PARAMETER_UNIVERSITYNAME,
                PARAMETER_PARTNERCODE,
                PARAMETER_PARTNERATTRIBUTE,
                PARAMETER_UPDATEDVALUE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_UNIVERSITYNAME,
                PARAMETER_PARTNERCODE,
                PARAMETER_PARTNERATTRIBUTE,
                PARAMETER_UPDATEDVALUE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseUpdateCommand.PARTNER_COURSE_UPDATE_MESSAGE_USAGE));
        }

        UniversityName universityName =
                ParserUtil.parseUniversityName(parameterToArgMap.getValue(PARAMETER_UNIVERSITYNAME).get());
        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
        PartnerCourseAttribute partnerCourseAttribute = ParserUtil.parsePartnerCourseAttributeForUpdate(
                parameterToArgMap.getValue(PARAMETER_PARTNERATTRIBUTE).get());
        String updatedValue = parseUpdatedValue(partnerCourseAttribute,
                parameterToArgMap.getValue(PARAMETER_UPDATEDVALUE).get());

        return new PartnerCourseUpdateCommand(universityName, partnerCode, partnerCourseAttribute, updatedValue);
    }

    private String parseUpdatedValue(PartnerCourseAttribute partnerCourseAttribute, String updatedValue)
            throws ParseException {
        requireAllNonNull(partnerCourseAttribute, updatedValue);
        String trimmedUpdatedValue = updatedValue.trim();
        switch (partnerCourseAttribute) {
        case PARTNERCODE:
            if (!PartnerCode.isValidPartnerCode(trimmedUpdatedValue)) {
                throw new ParseException(PartnerCode.MESSAGE_CONSTRAINTS);
            }
            break;
        case PARTNERNAME:
            if (!PartnerName.isValidPartnerName(trimmedUpdatedValue)) {
                throw new ParseException(PartnerName.MESSAGE_CONSTRAINTS);
            }
            break;
        case UNIT:
            if (!PartnerUnit.isValidPartnerUnit(trimmedUpdatedValue)) {
                throw new ParseException(PartnerUnit.MESSAGE_CONSTRAINTS);
            }
            break;
        case DESCRIPTION:
            if (!PartnerDescription.isValidPartnerDescription(trimmedUpdatedValue)) {
                throw new ParseException(PartnerDescription.MESSAGE_CONSTRAINTS);
            }
            break;
        default:
            //do nothing
        }
        return trimmedUpdatedValue;
    }
}
