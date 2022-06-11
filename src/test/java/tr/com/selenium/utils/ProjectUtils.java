package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


public class ProjectUtils {
    private final static Logger log = LogManager.getLogger(ProjectUtils.class);

    public static List<String> getDataFromFile(String fileName){
        log.info("GETTING data from ".concat(fileName));
        return FileUtils.readFile(FileDefinationUtils.getDataFilesPath()+fileName);
    }


}
