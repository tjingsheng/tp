package seedu.address;

import static seedu.address.testutil.TypicalObjects.getTypicalLocalCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalPartnerCourseCatalogue;
import static seedu.address.testutil.TypicalObjects.getTypicalUniversityCatalogue;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Config;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.util.ConfigUtil;
import seedu.address.logic.SeplendidLogic;
import seedu.address.logic.SeplendidLogicManager;
import seedu.address.model.SeplendidModel;
import seedu.address.model.SeplendidModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.partnercourse.PartnerCourse;
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

public class PseudoAppTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data",
            "PseudoAppTest");
    protected Config config;
    private SeplendidModel model;
    private SeplendidModel expectedModel;

    private Storage storage;

    private SeplendidLogic logic;

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @BeforeEach
    public void setUp() {
        model = new SeplendidModelManager(getTypicalLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue());
        expectedModel = new SeplendidModelManager(model.getLocalCourseCatalogue(), new UserPrefs(),
                getTypicalPartnerCourseCatalogue(), getTypicalUniversityCatalogue());

        AppParameters appParameters = new AppParameters();
        config = initConfig(appParameters.getConfigPath());


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
        logic = new SeplendidLogicManager(model, storage);
    }

    protected Config initConfig(Path configFilePath) {
        Config initializedConfig;
        Path configFilePathUsed;

        configFilePathUsed = Config.DEFAULT_CONFIG_FILE;

        if (configFilePath != null) {
            configFilePathUsed = configFilePath;
        }

        try {
            Optional<Config> configOptional = ConfigUtil.readConfig(configFilePathUsed);
            initializedConfig = configOptional.orElse(new Config());
        } catch (DataLoadingException e) {
            initializedConfig = new Config();
        }

        //Update config file in case it was missing to begin with or there are new/unused fields
        try {
            ConfigUtil.saveConfig(initializedConfig, configFilePathUsed);
        } catch (IOException e) {
            // do nothing
        }
        return initializedConfig;
    }

    protected UserPrefs initPrefs(UserPrefsStorage storage) {
        Path prefsFilePath = storage.getUserPrefsFilePath();


        UserPrefs initializedPrefs;
        try {
            Optional<UserPrefs> prefsOptional = storage.readUserPrefs();
            if (!prefsOptional.isPresent()) {
                // do nothing
            }
            initializedPrefs = prefsOptional.orElse(new UserPrefs());
        } catch (DataLoadingException e) {
            initializedPrefs = new UserPrefs();
        }

        //Update prefs file in case it was missing to begin with or there are new/unused fields
        try {
            storage.saveUserPrefs(initializedPrefs);
        } catch (IOException e) {
            // do nothing
        }

        return initializedPrefs;
    }

    @Test
    public void test1() {
        try {
            logic.execute("localcourse add [CS2948] [Course 1]");
            logic.execute("localcourse add [CS2235] [Course 2]");
            logic.execute("localcourse list");
            logic.execute("localcourse delete [CS3230]");
            ObservableList<LocalCourse> li = logic.getFilteredLocalCourseCatalogue();
            for (int i = 0; i < li.size(); i++) {
                System.out.println(String.format("Course %d: %s", i + 1, li.get(i)));
            }
            logic.execute("partnercourse add [Harvard College] [HARV123] [Bing bong]");

            ObservableList<PartnerCourse> li2 = logic.getFilteredPartnerCourseCatalogue();
            for (int i = 0; i < li2.size(); i++) {
                System.out.println(String.format("Partner Course %d: %s", i + 1, li2.get(i)));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
