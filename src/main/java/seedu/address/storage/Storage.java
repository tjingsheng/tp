package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.*;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, LocalCourseCatalogueStorage, UserPrefsStorage, UniversityCatalogueStorage{

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataLoadingException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

    @Override
    Path getLocalCourseCatalogueFilePath();

    @Override
    Optional<ReadOnlyLocalCourseCatalogue> readLocalCourseCatalogue() throws DataLoadingException;

    @Override
    Optional<ReadOnlyUniversityCatalogue> readUniversityCatalogue() throws DataLoadingException;

    @Override
    void saveLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) throws IOException;

    @Override
    void saveUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) throws IOException;

}
