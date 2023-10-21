package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.seplendidui.UiUtil;

/**
 * Lists all partner courses in the PartnerCourseCatalogue
 */
public class PartnerCourseListCommand extends PartnerCourseCommand {
    public static final String PARTNER_COURSE_LIST_MESSAGE_USAGE = COMMAND_WORD
            + "list: Lists all partner courses.";
    public static final String ACTION_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all partner courses";

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
        seplendidModel.updateFilteredPartnerCourseList(SeplendidModel.PREDICATE_SHOW_ALL_PARTNER_COURSES);
        return new CommandResult(MESSAGE_SUCCESS, UiUtil.ListViewModel.PARTNER_COURSE_LIST);
    }
}

