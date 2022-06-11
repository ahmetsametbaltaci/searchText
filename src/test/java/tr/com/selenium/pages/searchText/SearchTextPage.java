package tr.com.selenium.pages.searchText;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tr.com.selenium.pages.master.MasterPage;
import tr.com.selenium.utils.ProjectUtils;

import java.util.ArrayList;
import java.util.List;



public class SearchTextPage extends MasterPage implements SearchTextPageElements, SearchTextPageLanguageDefinitions {
    private final static Logger log = LogManager.getLogger(SearchTextPage.class);
    private static SearchTextPage instance;
    private List<String[]> strArr = new ArrayList<>();

    public static SearchTextPage getInstance() {
        if (instance == null)
            instance = new SearchTextPage();
        return instance;
    }

    /**
     * Web sayalarinda paramtre olarak verilen kelime aranir.
     *
     * @param text aranacak kelime bilgisi string olarak parametre verilir.
     */
    public void checkPageSources(String pageSource, String text) {
        log.info("GETTING Page Source");
        String[] str;
        //Locale trlocale = new Locale("tr", "TR");
        //pageSource.toLowerCase(trlocale).contains(text.toLowerCase(trlocale))
        //boolean isFound= Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE).matcher(pageSource).find();
        boolean isFound = StringUtils.containsIgnoreCase(pageSource, text);
        if (isFound) {
            str = new String[]{webDriver.getCurrentUrl(), text, "CONTAINS", "TRUE"};
        } else {
            str = new String[]{webDriver.getCurrentUrl(), text, "CONTAINS", "FALSE"};
        }
        strArr.add(str);
    }

    /**
     * Web sayfasinin acilmasi ve arama isleminin yapilmasi.
     * urllist.csv icerinde yazili urlleri acar ve searchText.txt icerisinde yazlı olan kelimeler aranir.
     */
    public void openWebSiteAndSearchText() {
        for (String url : ProjectUtils.getDataFromFile("urlList.csv")) {
            openWebSite(url);
            String pageSource = webDriver.getPageSource();
            for (String searchText : ProjectUtils.getDataFromFile("searchText.txt")) {
                checkPageSources(pageSource, searchText);
            }
        }
        compareArray(strArr);
    }


}