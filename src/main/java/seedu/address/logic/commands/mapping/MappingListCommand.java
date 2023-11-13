package seedu.address.logic.commands.mapping;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.seplendidui.UiUtil;

/**
 * Lists all mappings in the MappingCatalogue.
 */
public class MappingListCommand extends MappingCommand {
    public static final String ACTION_WORD = "list";
    public static final String MESSAGE_SUCCESS = "Listed all mappings";

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
        seplendidModel.updateFilteredMappingList(SeplendidModel.PREDICATE_SHOW_ALL_MAPPINGS);
        return new CommandResult(MESSAGE_SUCCESS,
                UiUtil.ListViewModel.MAPPING_LIST);
    }

}
