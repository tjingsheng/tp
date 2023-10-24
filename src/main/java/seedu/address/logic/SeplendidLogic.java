package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyMappingCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.mapping.Mapping;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.university.University;
import seedu.address.seplendidui.Ui;

/**
 * API of the SeplendidLogic component.
 */
public interface SeplendidLogic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException   If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    void setUi(Ui ui);

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    //=========== LocalCourseCatalogue ================================================================================

    /**
     * Returns the LocalCourseCatalogue.
     *
     * @see SeplendidModel#getLocalCourseCatalogue()
     */
    ReadOnlyLocalCourseCatalogue getLocalCourseCatalogue();

    /**
     * Returns an unmodifiable view of the filtered list of persons
     */
    ObservableList<LocalCourse> getFilteredLocalCourseCatalogue();

    /**
     * Returns the user prefs' LocalCourseCatalogue file path.
     */
    Path getLocalCourseCatalogueFilePath();

    //=========== PartnerCourseCatalouge ============================================================================
    ReadOnlyPartnerCourseCatalogue getPartnerCourseCatalogue();

    ObservableList<PartnerCourse> getFilteredPartnerCourseCatalogue();

    Path getPartnerCourseCatalogueFilePath();

    //=========== Universityatalouge ============================================================================
    ObservableList<University> getFilteredUniversityCatalogue();

    //=========== NoteCatalouge ============================================================================
    ObservableList<Note> getFilteredNoteCatalogue();

    //=========== MappingCatalouge ============================================================================
    ReadOnlyMappingCatalogue getMappingCatalogue();

    ObservableList<Mapping> getFilteredMappingCatalogue();

    Path getMappingCatalogueFilePath();
}

