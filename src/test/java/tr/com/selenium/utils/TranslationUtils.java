package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;

public class TranslationUtils {
    private final static Logger log = LogManager.getLogger(TranslationUtils.class);

    public static Properties properties = null;

    public static void setLanguage(String cultureCode) {
        if (cultureCode.equals("") || cultureCode.toUpperCase(Locale.ROOT).equalsIgnoreCase("DEFAULT")) {
            cultureCode = PropertyUtils.getCultureCode();
            log.info("Culture not set. Default Culture: " + cultureCode);
        } else if (cultureCode.length() > 0 && !cultureCode.contains("_")) {
            log.info("Invalid Lang File Format. Expected Format: tr_TR or en_US. Result: " + cultureCode);
        } else {
            log.info("Culture Code: " + cultureCode);
        }
        String langFilePath = FileDefinationUtils.getProjectRootPath()+ "/_propFiles/translations/" + PropertyUtils.getCultureCode() + ".properties";
        properties = PropertyUtils.initPropertyFile(langFilePath);
    }

    public static String getTranslation(String translationKey) {
        return properties.get(translationKey).toString();
    }

    public static String translateAndFormat(String textToTranslate, String translationKey, Object... additionalValues) {
        Object[] allValues = Arrays.copyOf(additionalValues, additionalValues.length + 1);
        for (int i = allValues.length - 1; i > 0; i--)
            allValues[i] = allValues[i - 1];
        allValues[0] = getTranslation(translationKey);
        return String.format(textToTranslate, allValues);
    }
}
