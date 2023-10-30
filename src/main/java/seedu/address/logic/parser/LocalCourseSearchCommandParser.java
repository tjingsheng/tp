package seedu.address.logic.parser;

import seedu.address.logic.commands.LocalCourseSearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.LocalCodeContainsKeywordsPredicate;
import seedu.address.model.localcourse.LocalName;
import seedu.address.model.localcourse.LocalNameContainsKeywordsPredicate;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALNAME;

public class LocalCourseSearchCommandParser implements Parser<LocalCourseSearchCommand> {
    public LocalCourseSearchCommand parse(String args) throws ParseException {
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            LocalCourseSearchCommand.LOCALCOURSE_SEARCH_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_LOCALNAME, PARAMETER_LOCALCODE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_LOCALNAME, PARAMETER_LOCALCODE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseSearchCommand.LOCALCOURSE_SEARCH_MESSAGE_USAGE));
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






