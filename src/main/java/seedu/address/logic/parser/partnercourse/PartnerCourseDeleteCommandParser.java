package seedu.address.logic.parser.partnercourse;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITYNAME;

import seedu.address.logic.commands.partnercourse.PartnerCourseDeleteCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.university.UniversityName;

/**
 * Parses input arguments and creates a new PartnerCourseCommand object.
 */
public class PartnerCourseDeleteCommandParser implements Parser<PartnerCourseDeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PartnerCourseDeleteCommand
     * and returns an PartnerCourseDeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public PartnerCourseDeleteCommand parse(String args) throws ParseException {
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            PartnerCourseDeleteCommand.PARTNER_COURSE_DELETE_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_PARTNERCODE, PARAMETER_UNIVERSITYNAME);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_PARTNERCODE, PARAMETER_UNIVERSITYNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseDeleteCommand.PARTNER_COURSE_DELETE_MESSAGE_USAGE));
        }

        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
        UniversityName universityName =
                ParserUtil.parseUniversityName(parameterToArgMap.getValue(PARAMETER_UNIVERSITYNAME).get());
        return new PartnerCourseDeleteCommand(partnerCode, universityName);
    }
}
