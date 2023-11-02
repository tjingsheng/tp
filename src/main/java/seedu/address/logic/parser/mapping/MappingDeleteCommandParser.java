package seedu.address.logic.parser.mapping;


import static seedu.address.logic.parser.CliSyntax.PARAMETER_LOCALCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_PARTNERCODE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITY;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.UsageMessage;
import seedu.address.logic.commands.mapping.MappingDeleteCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.partnercourse.PartnerCode;
import seedu.address.model.university.UniversityName;

/**
 * Parses input arguments and creates a new Mapping object.
 */
public class MappingDeleteCommandParser implements Parser<MappingDeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MappingDeleteCommand
     * and returns an MappingDeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public MappingDeleteCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(UsageMessage.MAPPING_DELETE.getValue());
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_LOCALCODE, PARAMETER_UNIVERSITY,
                        PARAMETER_PARTNERCODE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_LOCALCODE, PARAMETER_UNIVERSITY,
                PARAMETER_PARTNERCODE)) {
            throw new ParseException(UsageMessage.MAPPING_DELETE.getValue());
        }

        // All arguments should be a non-empty {@code Optional}
        LocalCode localCode = ParserUtil.parseLocalCode(parameterToArgMap.getValue(PARAMETER_LOCALCODE).get());
        UniversityName universityName = ParserUtil.parseUniversityName(
                parameterToArgMap.getValue(PARAMETER_UNIVERSITY).get());
        PartnerCode partnerCode = ParserUtil.parsePartnerCode(parameterToArgMap.getValue(PARAMETER_PARTNERCODE).get());


        return new MappingDeleteCommand(localCode, universityName, partnerCode);
    }

}
