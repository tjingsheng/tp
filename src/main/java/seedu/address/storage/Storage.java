package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, LocalCourseCatalogueStorage, UserPrefsStorage,
        PartnerCourseCatalogueStorage {

    // ================ UserPrefs methods ==============================
    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    // ================ AddressBook methods ==============================
    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataLoadingException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

    // ================ LocalCourseCatalogue methods ==============================
    @Override
    Path getLocalCourseCatalogueFilePath();

    @Override
    Optional<ReadOnlyLocalCourseCatalogue> readLocalCourseCatalogue() throws DataLoadingException;

    @Override
    void saveLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) throws IOException;

    // ================ PartnerCourseCatalogue methods ==============================
    @Override
    Path getPartnerCourseCatalogueFilePath();

    @Override
    Optional<ReadOnlyPartnerCourseCatalogue> readPartnerCourseCatalogue() throws DataLoadingException;

    @Override
    void savePartnerCourseCatalogue(ReadOnlyPartnerCourseCatalogue partnerCourseCatalogue) throws IOException;
}
