package tr.com.selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


public class ProjectUtils {
    private final static Logger log = LogManager.getLogger(ProjectUtils.class);

    /**
     * Data karsilastirma yapilir.
     * Web sayfalarinda gezerek istenen kelimeler aranir sonuclar ise string array olarak bir list'in icersine aktarilir
     * @param strArr String[] turunde bir parametredir. Icerisinde url,havelsanOdev,CompareType,Result verileri bulunur.
     */
    public void compareArray(List<String[]> strArr) {
        log.info("COMPARING Data");
        String url = "",havelsanOdev = "",compareType = "",result = "";
        boolean isValid = true;
        int len1 = 70, len2 = 50, len3 = 50;
        LogUtils.printPropertyFooter();
        LogUtils.printPropertyHeader("Url:", len1, "SearhText:", len2, "Is Contains:", len3, "Result");
        for (String[] strings : strArr) {
            url = strings[0];
            havelsanOdev = strings[1];
            compareType = strings[2];
            result = strings[3];
            LogUtils.printLogWithTabSpace(url, len1, havelsanOdev, len2, compareType, len3, result);
            if (result.equals("FALSE"))
                isValid = false;
        }
        LogUtils.printPropertyFooter();
        strArr.clear();
        if (!isValid) {
            log.error("One or more item(s) not matched. Please check item(s)...!!!");
        }
    }


}
