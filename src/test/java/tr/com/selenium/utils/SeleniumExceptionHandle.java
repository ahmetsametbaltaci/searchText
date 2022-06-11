package tr.com.selenium.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SeleniumExceptionHandle extends RuntimeException {
    private static final Logger log = LogManager.getLogger(SeleniumExceptionHandle.class);
    private static String errorMessage = "";

    public static String getErrorMessage() {
        return errorMessage;
    }

    public static void setErrorMessage(String message) {
        errorMessage = message;
    }


    public SeleniumExceptionHandle() {
    }

    public SeleniumExceptionHandle(String message) {
        super(message);
    }



}
