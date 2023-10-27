package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_ATTRIBUTE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import java.util.Comparator;

import seedu.address.logic.commands.LocalCourseSortCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.localcourse.LocalCourseAttribute;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalCode;
import seedu.address.model.localcourse.comparator.LocalCourseComparatorByLocalName;

/**
 * Parses input arguments and creates a new LocalCourseSortCommand object.
 */
public class LocalCourseSortCommandParser implements Parser<LocalCourseSortCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the LocalCourseSortCommand
     * and returns a LocalCourseSortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public LocalCourseSortCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            LocalCourseSortCommand.LOCAL_COURSE_SORT_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_ATTRIBUTE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_ATTRIBUTE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    LocalCourseSortCommand.LOCAL_COURSE_SORT_MESSAGE_USAGE));
        }

        Comparator<LocalCourse> localCourseComparator =
                parseLocalCourseComparator(parameterToArgMap.getValue(PARAMETER_ATTRIBUTE).get());

        return new LocalCourseSortCommand(localCourseComparator);
    }

    private Comparator<LocalCourse> parseLocalCourseComparator(String args) throws ParseException {
        LocalCourseAttribute localCourseAttribute = ParserUtil.parseLocalCourseAttribute(args);
        switch(localCourseAttribute) {
        case LOCALCODE:
            return new LocalCourseComparatorByLocalCode();
        case LOCALNAME:
            return new LocalCourseComparatorByLocalName();
        default:
            throw new ParseException(LocalCourseAttribute.MESSAGE_CONSTRAINTS);
        }
    }
}
