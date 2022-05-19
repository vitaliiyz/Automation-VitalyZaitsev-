package Configuration;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;
    private String propertyName;

    public PropertyReader(String propertyName) {
        this.propertyName = propertyName;
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propertyName + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }

}