package seedu.address.logic.parser.localcourse;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALNAME;

import seedu.address.logic.commands.localcourse.LocalCourseSearchCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCodeContainsKeywordsPredicate;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new LocalCourseSearchCommand object.
 */
public class LocalCourseSearchCommandParser implements Parser<LocalCourseSearchCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the LocalCourseSearchCommand
     * and returns a LocalCourseSearchCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public LocalCourseSearchCommand parse(String args) throws ParseException {
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            LocalCourseSearchCommand.LOCALCOURSE_SEARCH_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_LOCALCODE, PARAMETER_LOCALNAME);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_LOCALCODE, PARAMETER_LOCALNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseSearchCommand.LOCALCOURSE_SEARCH_MESSAGE_USAGE));
        }

        if (parameterToArgMap.contains(PARAMETER_LOCALCODE) && parameterToArgMap.contains(PARAMETER_LOCALNAME)) {
            // Both localcode and localname are present, check their order
            int localCodeIndex = parameterToArgMap.getIndexOf(PARAMETER_LOCALCODE);
            int localNameIndex = parameterToArgMap.getIndexOf(PARAMETER_LOCALNAME);

            if (localCodeIndex > localNameIndex) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        LocalCourseSearchCommand.LOCALCOURSE_SEARCH_MESSAGE_USAGE));
            }
        }

        LocalCourseAttribute attribute;

        if (parameterToArgMap.contains(PARAMETER_LOCALNAME)) {
            attribute = LocalCourseAttribute.LOCALNAME;
            LocalName localName = ParserUtil.parseLocalName(
                    parameterToArgMap.getValue(PARAMETER_LOCALNAME).get());
            return new LocalCourseSearchCommand(
                    new LocalNameContainsKeywordsPredicate(localName.toString(), attribute));
        }

        if (parameterToArgMap.contains(PARAMETER_LOCALCODE)) {
            attribute = LocalCourseAttribute.LOCALCODE;
            LocalCode localCode = ParserUtil.parseLocalCode(
                    parameterToArgMap.getValue(PARAMETER_LOCALCODE).get());
            return new LocalCourseSearchCommand(
                    new LocalCodeContainsKeywordsPredicate(localCode.toString(), attribute));
        }

        throw new ParseException("You must specify either local code or local name.");
    }
}






