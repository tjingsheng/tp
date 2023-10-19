package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path addressBookFilePath = Paths.get("data", "addressbook.json");
    private Path localCourseCatalogueFilePath = Paths.get("data", "localcoursecatalogue.json");
    private Path universitiesCatalogueFilePath = Paths.get("data", "universitycatalogue.json");
    private Path parterCourseCatalogueFilePath = Paths.get("data", "partnercoursecatalogue.json");
    private Path noteCatalogueFilePath = Paths.get("data", "note.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {
    }

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setAddressBookFilePath(newUserPrefs.getAddressBookFilePath());
        setLocalCourseCatalogueFilePath(newUserPrefs.getLocalCourseCatalogueFilePath());
        setPartnerCourseCatalogueFilePath(newUserPrefs.getPartnerCourseCatalogueFilePath());
        setUniversitiesCatalogueFilePath(newUserPrefs.getUniversityCatalogueFilePath());
        setNoteCatalogueFilePath(newUserPrefs.getNoteCatalogueFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.addressBookFilePath = addressBookFilePath;
    }

    public Path getLocalCourseCatalogueFilePath() {
        return localCourseCatalogueFilePath;
    }

    public void setUniversitiesCatalogueFilePath(Path universitiesCatalogueFilePath) {
        requireNonNull(universitiesCatalogueFilePath);
        this.universitiesCatalogueFilePath = universitiesCatalogueFilePath;
    }

    public Path getUniversityCatalogueFilePath() {
        return universitiesCatalogueFilePath;
    }

    public void setLocalCourseCatalogueFilePath(Path localCourseCatalogueFilePath) {
        requireNonNull(localCourseCatalogueFilePath);
        this.localCourseCatalogueFilePath = localCourseCatalogueFilePath;
    }

    public Path getPartnerCourseCatalogueFilePath() {
        return parterCourseCatalogueFilePath;
    }

    public void setPartnerCourseCatalogueFilePath(Path parterCourseCatalogueFilePath) {
        requireNonNull(parterCourseCatalogueFilePath);
        this.parterCourseCatalogueFilePath = parterCourseCatalogueFilePath;
    }

    public Path getNoteCatalogueFilePath() {
        return noteCatalogueFilePath;
    }

    public void setNoteCatalogueFilePath(Path noteCatalogueFilePath) {
        requireNonNull(noteCatalogueFilePath);
        this.noteCatalogueFilePath = noteCatalogueFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UserPrefs)) {
            return false;
        }

        UserPrefs otherUserPrefs = (UserPrefs) other;
        return guiSettings.equals(otherUserPrefs.guiSettings)
                && addressBookFilePath.equals(otherUserPrefs.addressBookFilePath)
                && localCourseCatalogueFilePath.equals(otherUserPrefs.localCourseCatalogueFilePath)
                && parterCourseCatalogueFilePath.equals(otherUserPrefs.parterCourseCatalogueFilePath)
                && noteCatalogueFilePath.equals(otherUserPrefs.noteCatalogueFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath, localCourseCatalogueFilePath,
                parterCourseCatalogueFilePath, noteCatalogueFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + addressBookFilePath);
        sb.append("\nLocal data file location (LocalCourseCatalogue): " + localCourseCatalogueFilePath);
        sb.append("\nLocal data file location (PartnerCourseCatalogue): " + parterCourseCatalogueFilePath);
        sb.append("\nLocal data file location (UniversityCatalogue): " + universitiesCatalogueFilePath);
        sb.append("\nLocal data file location (NoteCatalogue): " + noteCatalogueFilePath);
        return sb.toString();
    }

}
