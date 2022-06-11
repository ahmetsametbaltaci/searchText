package tr.com.selenium.customFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tr.com.selenium.utils.WebDriverFactory;


public class ProjectSeleniumWebDriverImpl extends WebDriverFactory {
    private final static Logger log = LogManager.getLogger(ProjectSeleniumWebDriverImpl.class);

    /**
     * @param element            WebElement paramtresi gecilir.
     * @param waitingTimeSeconds WebElement clickable olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isClickable(WebElement element, int waitingTimeSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, waitingTimeSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param by                 WebElement'in locator parametresi By turunden verilir.
     * @param waitingTimeSeconds WebElement DOM'a yuklenip kullanilabilir olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isElementPresent(By by, int waitingTimeSeconds) {
        boolean isPresent=false;
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, waitingTimeSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            isPresent=true;
        } catch (Exception exc) {
            log.warn("Element is not present : ".concat(String.valueOf(by)));
        }
       return isPresent;
    }


    /**
     * @param by                 WebElement'in locator parametresi By turunden verilir.
     * @param waitingTimeSeconds WebElement ekranda gorunur olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isDisplayed(By by, int waitingTimeSeconds) {
        boolean retValue = false;
        if (isElementPresent(by, waitingTimeSeconds)) {
            WebElement element = findElementByLocator(by,waitingTimeSeconds);
            retValue = element.isDisplayed();
        }
        return retValue;
    }

    /**
     * @param by bulunmak istenen webelement'in locator bilgisi By turunde verilir.
     * @param waitingTimeSeconds  WebElement bulunana kadar beklencek max. sure(sn)
     * @return WebElement turunde veri donulur.
     */
    public WebElement findElementByLocator(By by, int waitingTimeSeconds) {
        isElementPresent(by, waitingTimeSeconds);
        return webDriver.findElement(by);
    }

}
