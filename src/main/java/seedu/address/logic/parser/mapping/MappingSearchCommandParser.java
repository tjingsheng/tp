package seedu.address.logic.parser.mapping;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_MAPPINGATTRIBUTE;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_QUERY;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;
import static seedu.address.logic.parser.ParserUtil.parseMappingAttribute;

import seedu.address.logic.commands.mapping.MappingSearchCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.mapping.MappingAttributeContainsKeywordPredicate;
import seedu.address.model.mapping.MappingAttributeEnum;

/**
 * Parses input arguments and creates a new MappingSearchCommandParser object.
 */
public class MappingSearchCommandParser implements Parser<MappingSearchCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MappingSearchCommandParser
     * and returns a MappingSearchCommandParser object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public MappingSearchCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MappingSearchCommand.MAPPING_SEARCH_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_MAPPINGATTRIBUTE, PARAMETER_QUERY);


        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_MAPPINGATTRIBUTE, PARAMETER_QUERY)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MappingSearchCommand.MAPPING_SEARCH_MESSAGE_USAGE));
        }

        // All arguments should be a non-empty {@code Optional}
        MappingAttributeEnum attributeEnumValue = parseMappingAttribute(parameterToArgMap.getValue(
                PARAMETER_MAPPINGATTRIBUTE).get().toLowerCase());
        // query is non-empty
        String query = parameterToArgMap.getValue(PARAMETER_QUERY).get();

        MappingAttributeContainsKeywordPredicate predicate =
                new MappingAttributeContainsKeywordPredicate(query, attributeEnumValue);

        return new MappingSearchCommand(predicate);
    }

}
