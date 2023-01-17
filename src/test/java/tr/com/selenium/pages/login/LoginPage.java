package tr.com.selenium.pages.login;


import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableCell;
import com.thoughtworks.gauge.TableRow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import tr.com.selenium.customFramework.ProjectSeleniumWebDriverImpl;
import tr.com.selenium.utils.PropertyUtils;
import tr.com.selenium.utils.SeleniumExceptionHandle;
import tr.com.selenium.utils.TranslationUtils;

import java.util.List;


public class LoginPage extends ProjectSeleniumWebDriverImpl implements LoginPageElement, LoginPageLanguageDefinitions {
    private final static Logger log = LogManager.getLogger(LoginPage.class);
    private static LoginPage instance;

    public static LoginPage getInstance() {
        if (instance == null)
            instance = new LoginPage();
        return instance;
    }

    protected void openWebSite() {
        log.info("OPENING web site");
        if (webDriver == null)
            setup();
        String url = PropertyUtils.getDefaultProperties("app-url");
        log.info("PropertyDataEntity.applicationURL : " + url);
        webDriver.get(url);
        if (!isElementPresent(TranslationUtils.translateAndFormat(BTN_LOGIN,LANG_LOGIN), 60))
            throw new SeleniumExceptionHandle("Fatal ERROR: !!! Application could NOT be OPENED !!!");
        else
            waitAndClick(BTN_POPUP_CLOSE,15);


        String title = webDriver.getTitle();
        log.info("Title: " + title);
    }

    protected void clickLogin(){
        log.info("CLICKING Login Button");
        waitAndClick(TranslationUtils.translateAndFormat(BTN_LOGIN,LANG_LOGIN),10);
        if (!isDisplayed(INPUT_PASSWORD,20))
            throw new SeleniumExceptionHandle("!!! Login Form is not OPENED !!!");
    }

    protected void  fillLoginForm(Table table){
        log.info("ENTERING Login form and submit");
        List<TableRow> rows = table.getTableRows();
        rows.forEach(row->{
            List<TableCell> cells = row.getTableCells();
            cells.forEach(cell->{
                if (cell.getColumnName().equals("EMAIL")) {
                    WebElement email = findElement(INPUT_EMAIL,20);
                    email.clear();
                    email.sendKeys(cell.getValue());
                }
                if (cell.getColumnName().equals("PASSWORD")) {
                    WebElement password = findElement(INPUT_PASSWORD,20);
                    password.clear();
                    password.sendKeys(cell.getValue());
                }
            });
        });
        findElement(BTN_SUBMIT).submit();
    }

    public void checkSuccessLogin(){
        log.info("CHECKING Success Login");
        if (!isDisplayed(TranslationUtils.translateAndFormat(BTN_MY_BASKET,LANG_MY_BASKET),15))
            throw new SeleniumExceptionHandle("Login is FAILED");
    }



}
