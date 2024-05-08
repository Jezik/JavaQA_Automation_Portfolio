package dataProviders;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    private Properties properties;

    public PropertiesFileReader() {
        String propertiesFilePath = new File("").getAbsolutePath().concat("\\src\\test\\resources\\configs\\application.properties");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertiesFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                System.out.println("Can't read properties file. " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find properties file at " + propertiesFilePath);
        }
    }

    public String getBaseURL() {
        String baseURL = properties.getProperty("baseURL");
        if (baseURL != null) {
            return baseURL;
        } else {
            throw new RuntimeException("baseURL property is not specified in the application.properties file");
        }
    }

    public String getLoginPageURL() {
        String loginPageURL = properties.getProperty("loginPageURL");
        if (loginPageURL != null) {
            return loginPageURL;
        } else {
            throw new RuntimeException("loginPageURL property is not specified in the application.properties file");
        }
    }

    public String getRegistrationPageURL() {
        String registrationPageURL = properties.getProperty("registrationPageURL");
        if (registrationPageURL != null) {
            return registrationPageURL;
        } else {
            throw new RuntimeException("registrationPageURL property is not specified in the application.properties file");
        }
    }

    public int getImplicitlyWaitSeconds() {
        String seconds = properties.getProperty("implicitlyWaitInSeconds");
        if (seconds != null) {
            return Integer.parseInt(seconds);
        } else {
            throw new RuntimeException("implicitlyWaitInSeconds property is not specified in the application.properties file");
        }
    }
}
