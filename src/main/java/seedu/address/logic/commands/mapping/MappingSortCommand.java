package seedu.address.logic.commands.mapping;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.mapping.MappingComparatorByAttribute;
import seedu.address.seplendidui.UiUtil;

/**
 * Lists all mappings in the MappingCatalogue.
 */
public class MappingSortCommand extends MappingCommand {
    public static final String ACTION_WORD = "sort";

    public static final String MESSAGE_SUCCESS = "Sorted mappings by %1$s.";

    private final MappingComparatorByAttribute mappingComparator;

    /**
     * Creates a MappingSortCommand to add the specified {@code mappingComparator}
     *
     * @param mappingComparator Search mappingComparator.
     */
    public MappingSortCommand(MappingComparatorByAttribute mappingComparator) {
        super();
        this.mappingComparator = mappingComparator;
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);
        // Inject model functions into mappingComparator
        mappingComparator.initialiseGetLocalPartnercourse(seplendidModel::getLocalCourseIfExists,
                seplendidModel::getPartnerCourseIfExists);
        seplendidModel.updateSortedMappingList(mappingComparator);
        return new CommandResult(
                String.format(MESSAGE_SUCCESS, mappingComparator.getAttribute().toString().toLowerCase()),
                UiUtil.ListViewModel.MAPPING_SORT);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MappingSortCommand)) {
            return false;
        }

        MappingSortCommand otherMappingSortCommand = (MappingSortCommand) other;
        return mappingComparator.equals(otherMappingSortCommand.mappingComparator);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("mappingComparator", mappingComparator)
                .toString();
    }


}
