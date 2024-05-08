package managers;

import dataProviders.JSONFileReader;
import dataProviders.PropertiesFileReader;

public class FileReaderManager {

    private static final FileReaderManager fileReaderManager = new FileReaderManager();

    private static PropertiesFileReader propertiesFileReader;
    private static JSONFileReader jsonFileReader;

    private FileReaderManager() {

    }

    public static PropertiesFileReader getPropertiesFileReader() {
        return (propertiesFileReader == null) ? propertiesFileReader = new PropertiesFileReader() : propertiesFileReader;
    }

    public static JSONFileReader getJsonFileReader() {
        return (jsonFileReader == null) ? jsonFileReader = new JSONFileReader() : jsonFileReader;
    }
}
