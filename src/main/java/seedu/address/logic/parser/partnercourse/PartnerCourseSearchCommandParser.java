package seedu.address.logic.parser.partnercourse;

import seedu.address.logic.commands.localcourse.LocalCourseSearchCommand;
import seedu.address.logic.commands.partnercourse.PartnerCourseSearchCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.partnercourse.PartnerCodeContainsKeywordsPredicate;
import seedu.address.model.partnercourse.PartnerCourseAttribute;
import seedu.address.model.partnercourse.PartnerName;
import seedu.address.model.partnercourse.PartnerNameContainsKeywordsPredicate;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERNAME;

public class PartnerCourseSearchCommandParser implements Parser<PartnerCourseSearchCommand> {
    public PartnerCourseSearchCommand parse(String args) throws ParseException {
        if (!ParserUtil.areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                            PartnerCourseSearchCommand.PARTNERCOURSE_SEARCH_MESSAGE_USAGE)
            );
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args,
                        PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap,
                PARAMETER_PARTNERCODE, PARAMETER_PARTNERNAME)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PartnerCourseSearchCommand.PARTNERCOURSE_SEARCH_MESSAGE_USAGE));
        }

        if (parameterToArgMap.contains(PARAMETER_PARTNERCODE) && parameterToArgMap.contains(PARAMETER_PARTNERNAME)) {
            // Both partnercode and partnername are present, check their order
            int partnerCodeIndex = parameterToArgMap.getIndexOf(PARAMETER_PARTNERCODE);
            int partnerNameIndex = parameterToArgMap.getIndexOf(PARAMETER_PARTNERNAME);

            if (partnerCodeIndex > partnerNameIndex) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        PartnerCourseSearchCommand.PARTNERCOURSE_SEARCH_MESSAGE_USAGE));
            }
        }

        PartnerCourseAttribute attribute;

        if (parameterToArgMap.contains(PARAMETER_PARTNERNAME)) {
            attribute = PartnerCourseAttribute.PARTNERNAME;
            PartnerName partnerName = ParserUtil.parsePartnerName(
                    parameterToArgMap.getValue(PARAMETER_PARTNERNAME).get());
            return new PartnerCourseSearchCommand(
                    new PartnerNameContainsKeywordsPredicate(partnerName.toString(), attribute));
        }

        if (parameterToArgMap.contains(PARAMETER_PARTNERCODE)) {
            attribute = PartnerCourseAttribute.PARTNERCODE;
            PartnerCode partnerCode = ParserUtil.parsePartnerCode(
                    parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());
            return new PartnerCourseSearchCommand(
                    new PartnerCodeContainsKeywordsPredicate(partnerCode.toString(), attribute));
        }

        throw new ParseException("You must specify either local code or local name.");
    }
}
