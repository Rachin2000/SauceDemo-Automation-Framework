package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties=new Properties();
    static{
        try{
                     InputStream input= ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (input==null){
                throw  new RuntimeException("config.properties file nto found in the framework");
            }
            properties.load(input);

        }catch (IOException e){
                throw  new RuntimeException("Failed to load the config.properties");
        }

    }
    public static String getProperty(String key){
            return properties.getProperty(key);
    }

}
