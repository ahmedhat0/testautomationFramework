package org.iti.utils;

import java.util.Properties;

public class ReadProperties {

    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
