package service;


import java.util.ResourceBundle;


public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
            System.getProperty("environment"),
            new Utf8ResourceBundleControl()
    );

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}