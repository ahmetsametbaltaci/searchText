package tr.com.selenium.pages.master;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tr.com.selenium.customFramework.ProjectSeleniumWebDriverImpl;
import tr.com.selenium.utils.LogUtils;
import tr.com.selenium.utils.SeleniumExceptionHandle;

import java.util.List;


public class MasterPage extends ProjectSeleniumWebDriverImpl implements MasterPageElement, MasterPageLanguageDefinitions {
    private final static Logger log = LogManager.getLogger(MasterPage.class);
    private static MasterPage instance;

    public static MasterPage getInstance() {
        if (instance == null)
            instance = new MasterPage();
        return instance;
    }

    /**
     *
     * @param url -> Islam yapilacak web site url bilgisi
     */
    public void openWebSite(String url) {
        log.info("OPENING web site");
        if (webDriver == null)
            setup();
        log.info("PropertyDataEntity.applicationURL : " + url);
        webDriver.get(url);
        if (!isElementPresent(IMG_LOGO, 60)) {
            throw new SeleniumExceptionHandle("Fatal ERROR: !!! Application could NOT be OPENED !!!");
        }

        String title = webDriver.getTitle();
        log.info("Title: " + title);
    }

    /**
     * Data karsilastirma yapilir.
     * Web sayfalarinda gezerek istenen kelimeler aranir sonuclar ise string array olarak bir list'in icersine aktarilir
     * @param strArr String[] turunde bir parametredir. Icerisinde url,SearchText,CompareType,Result verileri bulunur.
      */
    public void compareArray(List<String[]> strArr) {
        log.info("COMPARING Data");
        String url = "",searchText = "",compareType = "",result = "";
        boolean isValid = true;
        int len1 = 70, len2 = 50, len3 = 50;
        LogUtils.printPropertyFooter();
        LogUtils.printPropertyHeader("Url:", len1, "SearhText:", len2, "Is Contains:", len3, "Result");
        for (String[] strings : strArr) {
            url = strings[0];
            searchText = strings[1];
            compareType = strings[2];
            result = strings[3];
            LogUtils.printLogWithTabSpace(url, len1, searchText, len2, compareType, len3, result);
            if (result.equals("FALSE"))
                isValid = false;
        }
        LogUtils.printPropertyFooter();
        strArr.clear();
        if (!isValid) {
            throw new SeleniumExceptionHandle("One or more item(s) not matched. Please check item(s)...!!!");
        }
    }


}
