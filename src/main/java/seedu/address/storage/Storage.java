package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.ReadOnlyNoteCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, LocalCourseCatalogueStorage, UserPrefsStorage,
        PartnerCourseCatalogueStorage, UniversityCatalogueStorage,
        NoteCatalogueStorage {

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
    Optional<ReadOnlyUniversityCatalogue> readUniversityCatalogue() throws DataLoadingException;

    @Override
    void saveLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) throws IOException;

    // ================ PartnerCourseCatalogue methods ==============================
    @Override
    Path getPartnerCourseCatalogueFilePath();

    @Override
    Optional<ReadOnlyPartnerCourseCatalogue> readPartnerCourseCatalogue() throws DataLoadingException;

    @Override
    void savePartnerCourseCatalogue(ReadOnlyPartnerCourseCatalogue partnerCourseCatalogue) throws IOException;

    @Override
    void saveUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) throws IOException;

    @Override
    Path getNoteCatalogueFilePath();

    @Override
    Optional<ReadOnlyNoteCatalogue> readNoteCatalogue() throws DataLoadingException;

    @Override
    void saveNoteCatalogue(ReadOnlyNoteCatalogue noteCatalogue) throws IOException;

}
