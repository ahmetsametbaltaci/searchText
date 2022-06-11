package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileDefinationUtils {

    private final static Logger log = LogManager.getLogger(FileDefinationUtils.class);

    public static String DEFAULT_PROPERTY_FILE = "\\_propFiles\\default.properties";

    public static String getProjectRootPath() {
        String rVal = "";
        try {
            rVal = new File(".").getCanonicalPath();
        } catch (IOException e) {
           throw new SeleniumExceptionHandle(e.getMessage());
        }
        return rVal;
    }

    public static String getDefaultPropertyFilePath() {
        return getProjectRootPath() + DEFAULT_PROPERTY_FILE;
    }

    public static String getUserPropertyFilePath() {
        return getTestEnvironmentPath().concat("\\user.properties");
    }

    public static String getTestEnvironmentPath(){
        String rootPath = FileDefinationUtils.getProjectRootPath();
        return rootPath+"\\env\\"+PropertyUtils.getPropertyValuesFromPomFile("testEnvironment") + "\\";
    }

    public static String getPocFilePath(){
        return PropertyUtils.getDefaultProperties("poc-file-path");
    }

    public static String getWebDriverPath(){
        return getPocFilePath().concat("\\webdriver\\chromedriver.exe");
    }

    public static String getDataFilesPath(){
        return getPocFilePath().concat("\\dataFiles\\");
    }

}
