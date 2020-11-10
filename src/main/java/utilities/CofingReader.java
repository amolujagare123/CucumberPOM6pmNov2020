package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CofingReader {

    static Properties getPropObject() throws IOException {
        FileInputStream fp = new FileInputStream("resources\\config.properties");

        Properties prop = new Properties();

        prop.load(fp);

        return prop;
    }


    public static String getUrl() throws IOException {

        return getPropObject().getProperty("url");
    }

}
