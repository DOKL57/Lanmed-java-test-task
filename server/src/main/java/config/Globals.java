package config;

import java.util.Properties;

public class Globals {
    private static final Properties properties = new Properties();

    public static final int SERVER_PORT = Integer.valueOf(properties.getProperty("port"));
    public static final int SENDING_FREQUENCY = Integer.valueOf(properties.getProperty("seconds"));
}
