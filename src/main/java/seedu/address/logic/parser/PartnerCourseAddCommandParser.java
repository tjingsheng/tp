package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERNAME;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITY;

import java.util.stream.Stream;

import seedu.address.logic.commands.PartnerCourseAddCommand;
import seedu.address.logic.commands.PartnerCourseCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.university.University;

public class PartnerCourseAddCommandParser implements Parser<PartnerCourseAddCommand> {
    public PartnerCourseAddCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_UNIVERSITY, PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME);

        if (!areArgumentsPresent(parameterToArgMap, PARAMETER_UNIVERSITY, PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseAddCommand.PARTNER_COURSE_ADD_MESSAGE_USAGE));
        }


        University university = new University(ParserUtil.parseUniversityName(parameterToArgMap.getValue(PARAMETER_UNIVERSITY).get()));
        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
        PartnerName partnerName = ParserUtil.parsePartnerName(parameterToArgMap.getValue(PARAMETER_PARTNERNAME).get());

        PartnerCourse partnerCourse = new PartnerCourse(university, partnerCode, partnerName);

        return new PartnerCourseAddCommand(partnerCourse);
    }

    /**
     * Returns true if all arguments are enclosed in square brackets, and are non-empty.
     *
     * @param args Arguments in the format of {@code [args1] [args2] ...}.
     * @return true if in correct format.
     */
    private static boolean areValuesEnclosedAndNonEmpty(String args) {
        int bracketCount = 0;
        StringBuilder currValue = new StringBuilder();

        for (int i = 0; i < args.length(); i++) {
            Character currChar = args.charAt(i);
            if (currChar.equals('[')) {
                currValue.setLength(0);
                bracketCount++;
            } else if (currChar.equals(']') && currValue.toString().trim().isEmpty()) {
                return false;
            } else if (currChar.equals(']')) {
                bracketCount--;
            } else {
                currValue.append(currChar);
            }

            if (bracketCount < 0 || bracketCount > 1) {
                return false;
            }
        }

        return bracketCount == 0;
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code SeplendidArgumentMap}.
     */
    private static boolean areArgumentsPresent(SeplendidArgumentMap argumentMap, SeplendidParameter... parameters) {
        return Stream.of(parameters).allMatch(parameter -> argumentMap.getValue(parameter).isPresent());
    }
}
