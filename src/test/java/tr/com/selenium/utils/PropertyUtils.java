package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    private final static Logger log = LogManager.getLogger(PropertyUtils.class);

    private static Properties defaultProperties;
    private static Properties userProperties;


    public static Properties initPropertyFile(String propertyFileFullPath) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(propertyFileFullPath);

        } catch (FileNotFoundException e) {
            throw new SeleniumExceptionHandle(e.getMessage());
        }
        return readPropertyFile(inputStream, propertyFileFullPath);
    }

    private static Properties readPropertyFile(InputStream inputStream, String fileFullPath) {
        Properties props = new Properties();
        try {
            log.info("Reading Property file... File Name: " + fileFullPath);
            if (inputStream != null) {
                try {
                    props.load(new InputStreamReader(inputStream));
                    log.info("Property file has been loaded. File Name: " + fileFullPath);
                } catch (Exception e) {
                    log.error("Failed to read from " + fileFullPath + " file. " + e.getMessage());
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException exc) {
                        log.warn("Failed to close InputStream: " + exc.getMessage());
                    }
                }
            } else {
                throw new SeleniumExceptionHandle("Property File NOT FOUND!! FileName: " + fileFullPath);
            }
        } catch (Exception e) {
            throw new SeleniumExceptionHandle(e.getMessage());
        }
        return props;
    }

    public static String getPropertyValuesFromPomFile(String propertyKey) {
        Model model = null;
        FileReader reader = null;
        MavenXpp3Reader mavenreader = new MavenXpp3Reader();
        try {
            String pomFileName = "pom.xml";
            reader = new FileReader(pomFileName);
            model = mavenreader.read(reader);
            model.setPomFile(new File(pomFileName));
        } catch (Exception ex) {
        }
        return model.getProperties().getProperty(propertyKey);
    }

    public static String getCultureCode(){
        return getPropertyValuesFromPomFile("cultureCode");
    }

    public static void initUserProperties() {
        if (userProperties != null)
            return;
        userProperties = initPropertyFile(FileDefinationUtils.getUserPropertyFilePath());
    }

    public static void initDefaultProperties() {
        if (defaultProperties != null)
            return;

        defaultProperties = initPropertyFile(FileDefinationUtils.getDefaultPropertyFilePath());
    }

    public static String getUserProperties(String propertyKey){
        return userProperties.getProperty(propertyKey);
    }

    public static String getDefaultProperties(String propertyKey){
        return defaultProperties.getProperty(propertyKey);
    }
}
