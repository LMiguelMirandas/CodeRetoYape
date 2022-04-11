package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public String GetProperty(String propertyName) throws IOException {
        Properties prop = new Properties();
        //prop.load(new FileInputStream("src/serenity.properties"));
        prop.load(new FileInputStream("D:/AUTOMATIZACIONInteliJ/RETO/YapeAnexo2/serenity.properties"));
        return prop.getProperty(propertyName).replace("\"","").replace(";", "");
    }
}
