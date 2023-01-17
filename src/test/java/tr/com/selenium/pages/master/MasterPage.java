package tr.com.selenium.pages.master;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tr.com.selenium.customFramework.ProjectSeleniumWebDriverImpl;
import tr.com.selenium.enums.ValidationMsg;
import tr.com.selenium.utils.SeleniumExceptionHandle;


public class MasterPage extends ProjectSeleniumWebDriverImpl implements MasterPageElement, MasterPageLanguageDefinitions {
    private final static Logger log = LogManager.getLogger(MasterPage.class);
    private static MasterPage instance;

    protected static MasterPage getInstance() {
        if (instance == null)
            instance = new MasterPage();
        return instance;
    }

    public void checkValidationMsg(ValidationMsg validationMsg){
        log.info("CHECKING validation message");
        if (!isDisplayed(String.format(MODAL_SPAN,validationMsg.toString()),15))
            throw new SeleniumExceptionHandle("Validation Message is not CHECKED");
    }



}
