package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERNAME;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITY;

import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityName;

/**
 * Parses input arguments and creates a new PartnerCourseCommand object.
 */
public class PartnerCourseAddCommandParser implements Parser<PartnerCourseAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PartnerCourseAddCommand
     * and returns an PartnerCourseAddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public PartnerCourseAddCommand parse(String args) throws ParseException {
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_UNIVERSITY, PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_UNIVERSITY,
                PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE));
        }


        UniversityName universityName = ParserUtil.parseUniversityName(parameterToArgMap
                .getValue(PARAMETER_UNIVERSITY).get());
        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
        PartnerName partnerName = ParserUtil.parsePartnerName(parameterToArgMap.getValue(PARAMETER_PARTNERNAME).get());

        PartnerCourse partnerCourse = new PartnerCourse(new University(universityName), partnerCode, partnerName);

        return new PartnerCourseAddCommand(partnerCourse);
    }
}
