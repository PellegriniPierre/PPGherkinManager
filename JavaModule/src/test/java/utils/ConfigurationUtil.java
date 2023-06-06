package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigurationUtil {
    private static final String ID_ALLOCATION_CN_SERVICE_HEALTH_INFOS = "idAllocation.cn.service.health.infos";
    private static final Map<String, String> configuration = new HashMap<>();
    public static String environment;

    static {
        loadConfigurationMap();
    }

    private static void loadConfigurationMap() {
        Logger logger = Logger.getLogger("Logger");
        try {
            String environmentToUse = System.getProperty("environment", "QA");
            InputStream pathApplicationNameToUse = null;
            Properties properties = new Properties();

            logger.info("Environment to use : " + environmentToUse);
            environment = environmentToUse;
            if (environmentToUse.equalsIgnoreCase("QA")) {
                logger.info("here QA");
                pathApplicationNameToUse = ConfigurationUtil.class.getClassLoader()
                        .getResourceAsStream("Config/appNames_QA2.properties");
            }

            properties.load(pathApplicationNameToUse);

            for (String propertyKey : properties.stringPropertyNames()) {
                configuration.put(propertyKey, properties.getProperty(propertyKey));
            }
        } catch (IOException e) {
            throw new RuntimeException("Exception caught during property initialization : %s" + e.getMessage());
        }
    }
    public static String getChinaServiceIdAllocationHealthInfos() {
        return configuration.get(ID_ALLOCATION_CN_SERVICE_HEALTH_INFOS);
    }
}
