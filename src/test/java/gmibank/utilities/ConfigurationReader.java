package gmibank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * To retrieve data from configuration.properties file.
     */
    private static Properties configFile;

    static {



        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

    public static void writeProperty(String value) throws IOException {
        Properties prop = new Properties();
        InputStream in = ConfigurationReader.class.getResourceAsStream("/Users/coderman/Desktop/GMIBankFramework/configuration.properties");
        prop.load(in);
        prop.setProperty("api_bearer_token",value);
    }

}