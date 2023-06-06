package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    private static final String LOGIN = "LOGIN";
    private static final String BACKEND_PASSWORD = "BACKEND_PASSWORD";
    private static final String PASSWORD = "PASSWORD";
    private static final String CLIENT_ID = "CLIENT_ID";
    private static final Map<String, String> configuration = new HashMap<>();


    static {
        loadProperties();
    }


    private static void loadProperties() {

        try {
            Properties properties = new Properties();
            InputStream propertyFile = PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream("Config/secrets.properties");
            InputStream secretPropertyFile = PropertiesLoader.class.getClassLoader()
                    .getResourceAsStream("Config/application-Dev.properties");
            properties.load(propertyFile);
            properties.load(secretPropertyFile);

            for (String propertyKey : properties.stringPropertyNames()) {
                configuration.put(propertyKey, properties.getProperty(propertyKey));
            }
        } catch (IOException e) {
            throw new RuntimeException("Exception caught during property initialization : %s" + e.getMessage());
        }

    }

    public static String getLogin() {
        return configuration.get(LOGIN);
    }
    public static String getPassword() {
        return configuration.get(PASSWORD);
    }
    public static String getBackendPassword() {
        return configuration.get(BACKEND_PASSWORD);
    }

    public static String getClientId() {
        return configuration.get(CLIENT_ID);
    }
}
