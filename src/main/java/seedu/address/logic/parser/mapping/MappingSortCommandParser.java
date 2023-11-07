package seedu.address.logic.parser.mapping;


import static seedu.address.logic.parser.CliSyntax.PARAMETER_MAPPINGATTRIBUTE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;
import static seedu.address.logic.parser.ParserUtil.parseMappingAttributeForSort;

import seedu.address.logic.commands.UsageMessage;
import seedu.address.logic.commands.mapping.MappingSortCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.mapping.MappingAttribute;
import seedu.address.model.mapping.MappingComparatorByAttribute;

/**
 * Parses input arguments and creates a new MappingSortCommandParser object.
 */
public class MappingSortCommandParser implements Parser<MappingSortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MappingSortCommandParser
     * and returns a MappingSortCommandParser object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public MappingSortCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(UsageMessage.MAPPING_SORT.getValue());
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_MAPPINGATTRIBUTE);


        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_MAPPINGATTRIBUTE)) {
            throw new ParseException(UsageMessage.MAPPING_SORT.getValue());
        }

        // All arguments should be a non-empty {@code Optional}
        MappingAttribute attributeEnumValue = parseMappingAttributeForSort(parameterToArgMap.getValue(
                PARAMETER_MAPPINGATTRIBUTE).get().toLowerCase());

        MappingComparatorByAttribute mappingComparator = new MappingComparatorByAttribute(attributeEnumValue);

        return new MappingSortCommand(mappingComparator);
    }

}
