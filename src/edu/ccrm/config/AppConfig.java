package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance;
    private final String appName = "Campus Course & Records Manager";
    private final String dataDir = "test-data";

    // Private constructor (Singleton)
    private AppConfig() {}

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public String getDataDir() {
        return dataDir;
    }
}
