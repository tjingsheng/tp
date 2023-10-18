package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private LocalCourseCatalogueStorage localCourseCatalogueStorage;
    private UniversityCatalogueStorage universityCatalogueStorage;
    private PartnerCourseCatalogueStorage partnerCourseCatalogueStorage;
    private UserPrefsStorage userPrefsStorage;
    private NoteCatalogueStorage noteCatalogueStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(AddressBookStorage addressBookStorage,
                          LocalCourseCatalogueStorage localCourseCatalogueStorage,
                          UserPrefsStorage userPrefsStorage,
                          PartnerCourseCatalogueStorage partnerCourseCatalogueStorage,
                          UniversityCatalogueStorage universityCatalogueStorage) {
        this.addressBookStorage = addressBookStorage;
        this.localCourseCatalogueStorage = localCourseCatalogueStorage;
        this.universityCatalogueStorage = universityCatalogueStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.partnerCourseCatalogueStorage = partnerCourseCatalogueStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataLoadingException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }

    // ================ LocalCourseCatalogue methods ==============================

    @Override
    public Path getLocalCourseCatalogueFilePath() {
        return localCourseCatalogueStorage.getLocalCourseCatalogueFilePath();
    }

    @Override
    public Optional<ReadOnlyLocalCourseCatalogue> readLocalCourseCatalogue() throws DataLoadingException {
        return readLocalCourseCatalogue(localCourseCatalogueStorage.getLocalCourseCatalogueFilePath());
    }

    @Override
    public Optional<ReadOnlyLocalCourseCatalogue> readLocalCourseCatalogue(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return localCourseCatalogueStorage.readLocalCourseCatalogue(filePath);
    }

    @Override
    public void saveLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue) throws IOException {
        saveLocalCourseCatalogue(localCourseCatalogue, localCourseCatalogueStorage.getLocalCourseCatalogueFilePath());
    }

    @Override
    public void saveLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue,
                                         Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        localCourseCatalogueStorage.saveLocalCourseCatalogue(localCourseCatalogue, filePath);
    }

    // ================ University methods ==============================
    @Override
    public Path getUniversityCatalogueFilePath() {
        return universityCatalogueStorage.getUniversityCatalogueFilePath();
    }

    @Override
    public Optional<ReadOnlyUniversityCatalogue> readUniversityCatalogue() throws DataLoadingException {
        return readUniversityCatalogue(universityCatalogueStorage.getUniversityCatalogueFilePath());
    }

    @Override
    public Optional<ReadOnlyUniversityCatalogue> readUniversityCatalogue(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return universityCatalogueStorage.readUniversityCatalogue(filePath);
    }

    @Override
    public void saveUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue) throws IOException {
        saveUniversityCatalogue(universityCatalogue, universityCatalogueStorage.getUniversityCatalogueFilePath());
    }

    @Override
    public void saveUniversityCatalogue(ReadOnlyUniversityCatalogue universityCatalogue,
                                         Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        universityCatalogueStorage.saveUniversityCatalogue(universityCatalogue, filePath);
    }
    // ================ PartnerCourseCatalogue methods ==============================
    @Override
    public Path getPartnerCourseCatalogueFilePath() {
        return partnerCourseCatalogueStorage.getPartnerCourseCatalogueFilePath();
    }

    @Override
    public Optional<ReadOnlyPartnerCourseCatalogue> readPartnerCourseCatalogue() throws DataLoadingException {
        return readPartnerCourseCatalogue(partnerCourseCatalogueStorage.getPartnerCourseCatalogueFilePath());
    }

    @Override
    public Optional<ReadOnlyPartnerCourseCatalogue> readPartnerCourseCatalogue(Path filePath)
            throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return partnerCourseCatalogueStorage.readPartnerCourseCatalogue(filePath);
    }

    @Override
    public void savePartnerCourseCatalogue(ReadOnlyPartnerCourseCatalogue partnerCourseCatalogue) throws IOException {
        savePartnerCourseCatalogue(partnerCourseCatalogue, partnerCourseCatalogueStorage
                .getPartnerCourseCatalogueFilePath());
    }

    @Override
    public void savePartnerCourseCatalogue(ReadOnlyPartnerCourseCatalogue partnerCourseCatalogue,
                                         Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        partnerCourseCatalogueStorage.savePartnerCourseCatalogue(partnerCourseCatalogue, filePath);
    }
    // ================ NoteCatalogue methods ==============================

    @Override
    public Path getNoteCatalogueFilePath() {
        return noteCatalogueStorage.getNoteCatalogueFilePath();
    }

    @Override
    public Optional<ReadOnlyNoteCatalogue> readNoteCatalogue() throws DataLoadingException {
        return readNoteCatalogue(noteCatalogueStorage.getNoteCatalogueFilePath());
    }

    @Override
    public Optional<ReadOnlyNoteCatalogue> readNoteCatalogue(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return noteCatalogueStorage.readNoteCatalogue(filePath);
    }

    @Override
    public void saveNoteCatalogue(ReadOnlyNoteCatalogue noteCatalogue) throws IOException {
        saveNoteCatalogue(noteCatalogue, noteCatalogueStorage.getNoteCatalogueFilePath());
    }

    @Override
    public void saveNoteCatalogue(ReadOnlyNoteCatalogue noteCatalogue,
                                         Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        noteCatalogueStorage.saveNoteCatalogue(noteCatalogue, filePath);
    }

}
