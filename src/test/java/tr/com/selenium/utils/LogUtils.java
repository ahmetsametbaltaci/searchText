package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogUtils {

    private final static Logger log = LogManager.getLogger(LogUtils.class);
    public static final String pLine = "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";

    public static void printLogWithTabSpace(String str1, int charLen1, String str2, int charLen2, String str3, int charLen3, String str4) {
        String format = "%-" + charLen1 + "s%-" + charLen2 + "s%-" + charLen3 + "s%s";
        log.info(String.format(format, str1, str2, str3, str4));
    }

    public static void printPropertyHeader(String header1, int len1, String header2, int len2, String header3, int len3, String header4) {
        printLogWithTabSpace(header1, len1, header2, len2, header3, len3, header4);
        log.info(pLine);
    }


    public static void printPropertyFooter() {
        log.info(pLine);
    }


}