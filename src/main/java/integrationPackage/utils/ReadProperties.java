package integrationPackage.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static final String PATH_URL_PROPERTIES = "\\src\\main\\resources\\Configuration.properties";

    public static String getProperties(String key){
        CreateLogger.info("Read Properties : "+ PATH_URL_PROPERTIES.toString());
        FileReader reader= null;
        try {
            File file =new File(System.getProperty("user.dir")+PATH_URL_PROPERTIES);
            CreateLogger.info("Read Properties : "+ file.getName());
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            CreateLogger.error("Read Properties Failed : "+ e.getMessage());
        }
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            CreateLogger.info("Load Properties Failed : "+ e.getMessage());
        }
        CreateLogger.info("Read Properties : "+ " KEY :"+ key);
        CreateLogger.info("Read Properties : "+ " VALUE :"+ props.getProperty(key));
        return props.getProperty(key);
    }
}
