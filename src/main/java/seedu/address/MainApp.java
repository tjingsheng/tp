package seedu.address;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import seedu.address.commons.core.Config;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Version;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.logic.SeplendidLogic;
import seedu.address.logic.SeplendidLogicManager;
import seedu.address.model.AddressBook;
import seedu.address.model.LocalCourseCatalogue;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.PartnerCourseCatalogue;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyLocalCourseCatalogue;
import seedu.address.model.ReadOnlyPartnerCourseCatalogue;
import seedu.address.model.ReadOnlyUniversityCatalogue;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UniversityCatalogue;
import seedu.address.model.UserPrefs;
import seedu.address.model.util.SampleDataUtil;
import seedu.address.storage.AddressBookStorage;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonLocalCourseCatalogueStorage;
import seedu.address.storage.JsonPartnerCourseCatalogueStorage;
import seedu.address.storage.JsonUniversityCatalogueStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.LocalCourseCatalogueStorage;
import seedu.address.storage.PartnerCourseCatalogueStorage;
import seedu.address.storage.Storage;
import seedu.address.storage.StorageManager;
import seedu.address.storage.UniversityCatalogueStorage;
import seedu.address.storage.UserPrefsStorage;
import seedu.address.ui.Ui;
import seedu.address.ui.UiManager;

/**
 * Runs the application.
 */
public class MainApp extends Application {

    public static final Version VERSION = new Version(0, 2, 2, true);

    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    protected Ui ui;
    // Deprecate after morphing
    protected Logic ab3Logic;
    // New logic class
    protected SeplendidLogic seplendidLogic;
    protected Storage storage;
    // Deprecate after morphing
    protected Model model;
    // New model class
    protected SeplendidModel seplendidModel;
    protected Config config;

    @Override
    public void init() throws Exception {
        logger.info("=============================[ Initializing AddressBook ]===========================");
        super.init();

        AppParameters appParameters = AppParameters.parse(getParameters());
        config = initConfig(appParameters.getConfigPath());
        initLogging(config);

        UserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(config.getUserPrefsFilePath());
        UserPrefs userPrefs = initPrefs(userPrefsStorage);
        AddressBookStorage addressBookStorage = new JsonAddressBookStorage(userPrefs.getAddressBookFilePath());
        LocalCourseCatalogueStorage localCourseCatalogueStorage =
                new JsonLocalCourseCatalogueStorage(userPrefs.getLocalCourseCatalogueFilePath());
        UniversityCatalogueStorage universityCatalogueStorage =
                new JsonUniversityCatalogueStorage(userPrefs.getUniversityCatalogueFilePath());

        PartnerCourseCatalogueStorage partnerCourseCatalogue =
                new JsonPartnerCourseCatalogueStorage(userPrefs.getPartnerCourseCatalogueFilePath());
        storage = new StorageManager(addressBookStorage, localCourseCatalogueStorage, userPrefsStorage,
                partnerCourseCatalogue, universityCatalogueStorage);
        // AB3 model
        model = initAddressBookModelManager(storage, userPrefs);
        // SEPlendid model
        seplendidModel = initSeplendidModelManager(storage, userPrefs);

        ab3Logic = new LogicManager(model, storage);
        // Developer's note: UI is able to use seplendidLogic to execute commands
        seplendidLogic = new SeplendidLogicManager(seplendidModel, storage);

        ui = new UiManager(ab3Logic);
    }

    /**
     * Returns a {@code ModelManager} with the data from {@code storage}'s address book and {@code userPrefs}. <br>
     * The data from the sample address book will be used instead if {@code storage}'s address book is not found,
     * or an empty address book will be used instead if errors occur when reading {@code storage}'s address book.
     */
    private Model initAddressBookModelManager(Storage storage, ReadOnlyUserPrefs userPrefs) {
        logger.info("Using data file : " + storage.getAddressBookFilePath());

        Optional<ReadOnlyAddressBook> addressBookOptional;
        ReadOnlyAddressBook initialData;
        try {
            addressBookOptional = storage.readAddressBook();
            if (!addressBookOptional.isPresent()) {
                logger.info("Creating a new data file " + storage.getAddressBookFilePath()
                        + " populated with a sample AddressBook.");
            }
            initialData = addressBookOptional.orElseGet(SampleDataUtil::getSampleAddressBook);
        } catch (DataLoadingException e) {
            logger.warning("Data file at " + storage.getAddressBookFilePath() + " could not be loaded."
                    + " Will be starting with an empty AddressBook.");
            initialData = new AddressBook();
        }

        return new ModelManager(initialData, userPrefs);
    }

    /**
     * Returns a {@code SeplendidModelManager} with the data from {@code storage, LocalCourseCatalogue,
     * PartnerCourseCatalogue, UniversityCatalogue, NoteCatalogue, userPrefs}.
     * <br>
     * Sample data will be used instead if {@code storage}'s data is not found,
     * or an empty dataset will be used instead if errors occur when reading {@code storage}'s data.
     */
    private SeplendidModelManager initSeplendidModelManager(Storage storage, ReadOnlyUserPrefs userPrefs) {
        // The below needs to be repeated several times for the different data types

        Optional<ReadOnlyLocalCourseCatalogue> localCourseCatalogueOptional;
        Optional<ReadOnlyPartnerCourseCatalogue> partnerCourseCatalogueOptional;
        Optional<ReadOnlyUniversityCatalogue> universityCatalogueOptional;
        ReadOnlyPartnerCourseCatalogue initialPartnerCourseCatalogue;
        ReadOnlyLocalCourseCatalogue initialLocalCourseCatalogue;
        ReadOnlyUniversityCatalogue initialUniversityCatalogue;
        logger.info("Using data file : " + storage.getLocalCourseCatalogueFilePath());
        try {
            localCourseCatalogueOptional = storage.readLocalCourseCatalogue();
            partnerCourseCatalogueOptional = storage.readPartnerCourseCatalogue();
            universityCatalogueOptional = storage.readUniversityCatalogue();
            if (!localCourseCatalogueOptional.isPresent()) {
                logger.info("Creating a new data file " + storage.getLocalCourseCatalogueFilePath()
                        + " populated with a sample LocalCourseCatalogue.");
            }
            initialLocalCourseCatalogue = localCourseCatalogueOptional.orElseGet(
                    SampleDataUtil::getSampleLocalCourseCatalogue);
            if (!partnerCourseCatalogueOptional.isPresent()) {
                logger.info("Creating a new data file " + storage.getPartnerCourseCatalogueFilePath()
                        + " populated with a sample PartnerCourseCatalogue.");
            }
            initialPartnerCourseCatalogue = partnerCourseCatalogueOptional.orElseGet(
                    SampleDataUtil::getSamplePartnerCourseCatalogue);
            if (!universityCatalogueOptional.isPresent()) {
                logger.info("Creating a new data file " + storage.getUniversityCatalogueFilePath()
                        + " populated with a sample UniversityCatalogue.");
            }
            initialUniversityCatalogue = universityCatalogueOptional.orElseGet(
                    SampleDataUtil::getSampleUniversityCatalogue);
        } catch (DataLoadingException e) {
            logger.warning("Data file at " + storage.getLocalCourseCatalogueFilePath() + " could not be loaded."
                    + " Will be starting with an empty AddressBook.");
            initialLocalCourseCatalogue = new LocalCourseCatalogue();
            initialPartnerCourseCatalogue = new PartnerCourseCatalogue();
            initialUniversityCatalogue = new UniversityCatalogue();
        }
        return new SeplendidModelManager(initialLocalCourseCatalogue, userPrefs, initialPartnerCourseCatalogue,
                                         initialUniversityCatalogue);
    }

    private void initLogging(Config config) {
        LogsCenter.init(config);
    }

    /**
     * Returns a {@code Config} using the file at {@code configFilePath}. <br>
     * The default file path {@code Config#DEFAULT_CONFIG_FILE} will be used instead
     * if {@code configFilePath} is null.
     */
    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            logger.info("Custom Config file specified " + configFilePath);
            configFilePathUsed = configFilePath;
        }

        logger.info("Using config file : " + configFilePathUsed);

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            if (!configOptional.isPresent()) {
                logger.info("Creating new config file " + configFilePathUsed);
            }
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataLoadingException e) {
            logger.warning("Config file at " + configFilePathUsed + " could not be loaded."
                    + " Using default config properties.");
            initializedConfig = new Config();
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }
        return initializedConfig;
    }

    /**
     * Returns a {@code UserPrefs} using the file at {@code storage}'s user prefs file path,
     * or a new {@code UserPrefs} with default configuration if errors occur when
     * reading from the file.
     */
    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();
        logger.info("Using preference file : " + prefsFilePath);

        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            if (!prefsOptional.isPresent()) {
                logger.info("Creating new preference file " + prefsFilePath);
            }
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataLoadingException e) {
            logger.warning("Preference file at " + prefsFilePath + " could not be loaded."
                    + " Using default preferences.");
            initializedPrefs = new UserPrefs();
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            logger.warning("Failed to save config file : " + StringUtil.getDetails(e));
        }

        return initializedPrefs;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The overriding start method for MainApp class. the entry point.
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     */
    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting AddressBook " + MainApp.VERSION);
        ui.start(primaryStage);
    }

    @Override
    public void stop() {
        logger.info("============================ [ Stopping Address Book ] =============================");
        try {
            storage.saveUserPrefs(model.getUserPrefs());
        } catch (IOException e) {
            logger.severe("Failed to save preferences " + StringUtil.getDetails(e));
        }
    }
}
