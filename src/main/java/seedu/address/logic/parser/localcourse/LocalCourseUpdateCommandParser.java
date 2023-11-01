package seedu.address.logic.parser.localcourse;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALATTRIBUTE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UPDATEDVALUE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.localcourse.LocalCourseUpdateCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalDescription;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalUnit;

/**
 * Parses input arguments and creates a new LocalCourseUpdateCommand object.
 */
public class LocalCourseUpdateCommandParser implements Parser<LocalCourseUpdateCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the LocalCourseUpdateCommand
     * and returns a LocalCourseUpdateCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public LocalCourseUpdateCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseUpdateCommand.LOCAL_COURSE_UPDATE_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap = SeplendidArgumentTokenizer.tokenize(args,
                PARAMETER_LOCALCODE,
                PARAMETER_LOCALATTRIBUTE,
                PARAMETER_UPDATEDVALUE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_LOCALCODE,
                PARAMETER_LOCALATTRIBUTE,
                PARAMETER_UPDATEDVALUE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseUpdateCommand.LOCAL_COURSE_UPDATE_MESSAGE_USAGE));
        }

        LocalCode localCode = ParserUtil.parseLocalCode(parameterToArgMap.getValue(PARAMETER_LOCALCODE).get());
        LocalCourseAttribute localCourseAttribute = ParserUtil.parseLocalCourseAttributeForUpdate(
                parameterToArgMap.getValue(PARAMETER_LOCALATTRIBUTE).get());
        String updatedValue = parseUpdatedValue(localCourseAttribute,
                parameterToArgMap.getValue(PARAMETER_UPDATEDVALUE).get());

        return new LocalCourseUpdateCommand(localCode, localCourseAttribute, updatedValue);
    }

    private String parseUpdatedValue(LocalCourseAttribute localCourseAttribute, String updatedValue)
            throws ParseException {
        requireAllNonNull(localCourseAttribute, updatedValue);
        String trimmedUpdatedValue = updatedValue.trim();
        switch (localCourseAttribute) {
        case LOCALCODE:
            if (!LocalCode.isValidLocalCode(trimmedUpdatedValue)) {
                throw new ParseException(LocalCode.MESSAGE_CONSTRAINTS);
            }
            break;
        case LOCALNAME:
            if (!LocalName.isValidLocalName(trimmedUpdatedValue)) {
                throw new ParseException(LocalName.MESSAGE_CONSTRAINTS);
            }
            break;
        case LOCALUNIT:
            if (!LocalUnit.isValidLocalUnit(trimmedUpdatedValue)) {
                throw new ParseException(LocalUnit.MESSAGE_CONSTRAINTS);
            }
            break;
        case LOCALDESCRIPTION:
            if (!LocalDescription.isValidLocalDescription(trimmedUpdatedValue)) {
                throw new ParseException(LocalDescription.MESSAGE_CONSTRAINTS);
            }
            break;
        default:
            //do nothing
        }
        return trimmedUpdatedValue;
    }
}
