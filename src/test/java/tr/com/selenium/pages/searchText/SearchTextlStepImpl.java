package tr.com.selenium.pages.searchText;

import com.thoughtworks.gauge.Step;


public class SearchTextlStepImpl {

  SearchTextPage textFinderPage = SearchTextPage.getInstance();

    @Step({"Uygulamayi ac ve istenen kelimeleri ara"})
    public void findText(){
        textFinderPage.openWebSiteAndSearchText();
    }


}