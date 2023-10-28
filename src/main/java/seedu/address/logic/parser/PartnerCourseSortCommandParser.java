package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERATTRIBUTE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import java.util.Comparator;

import seedu.address.logic.commands.PartnerCourseSortCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.comparator.PartnerCourseComparatorByPartnerCode;
import seedu.address.model.partnercourse.comparator.PartnerCourseComparatorByPartnerName;
import seedu.address.model.partnercourse.comparator.PartnerCourseComparatorByUniversity;

/**
 * Parses input arguments and creates a new PartnerCourseSortCommand object.
 */
public class PartnerCourseSortCommandParser implements Parser<PartnerCourseSortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PartnerCourseSortCommand
     * and returns a PartnerCourseSortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public PartnerCourseSortCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseSortCommand.PARTNER_COURSE_SORT_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_PARTNERATTRIBUTE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_PARTNERATTRIBUTE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseSortCommand.PARTNER_COURSE_SORT_MESSAGE_USAGE));
        }

        Comparator<PartnerCourse> partnerCourseComparator =
                parsePartnerCourseComparator(parameterToArgMap.getValue(PARAMETER_PARTNERATTRIBUTE).get());

        return new PartnerCourseSortCommand(partnerCourseComparator);
    }

    private Comparator<PartnerCourse> parsePartnerCourseComparator(String args) throws ParseException {
        PartnerCourseAttribute partnerCourseAttribute = ParserUtil.parsePartnerCourseAttribute(args);
        switch(partnerCourseAttribute) {
        case PARTNERCODE:
            return new PartnerCourseComparatorByPartnerCode();
        case PARTNERNAME:
            return new PartnerCourseComparatorByPartnerName();
        case UNIVERSITY:
            return new PartnerCourseComparatorByUniversity();
        default:
            throw new ParseException(PartnerCourseAttribute.MESSAGE_CONSTRAINTS);
        }
    }
}
