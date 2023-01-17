package tr.com.selenium.customFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tr.com.selenium.utils.SeleniumExceptionHandle;
import tr.com.selenium.utils.WebDriverFactory;

import java.util.List;


public class ProjectSeleniumWebDriverImpl extends WebDriverFactory {
    private final static Logger log = LogManager.getLogger(ProjectSeleniumWebDriverImpl.class);
    private final static int WAITING_DURATION = 30;

    private Integer getWaitDuration(int... waitingTime) {
        int _waitingTime;
        if (waitingTime.length > 0)
            _waitingTime = waitingTime[0];
        else
            _waitingTime = WAITING_DURATION;
        return _waitingTime;
    }

    private WebDriverWait initWebDriverWait(int... waitingTime) {
        return new WebDriverWait(webDriver, getWaitDuration(waitingTime));
    }

    /**
     * @param element     WebElement paramtresi gecilir.
     * @param waitingTime WebElement clickable olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isClickable(WebElement element, int... waitingTime) {
        try {
            WebDriverWait wait = initWebDriverWait(waitingTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitAndClick(String locator, int... waitingTime) {
        log.info("Clicking -  ".concat(locator));
        try {
            WebDriverWait wait = initWebDriverWait(waitingTime);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            webDriver.findElement(By.xpath(locator)).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param locator     WebElement'in locator parametresi By turunden verilir.
     * @param waitingTime WebElement DOM'a yuklenip kullanilabilir olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isElementPresent(String locator, int... waitingTime) {
        boolean isPresent = false;
        try {
            WebDriverWait wait = initWebDriverWait(waitingTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            isPresent = true;
        } catch (Exception exc) {
            throw new SeleniumExceptionHandle("Element is not present : ".concat(String.valueOf(locator)));
        }
        return isPresent;
    }


    /**
     * @param locator     WebElement'in locator parametresi By turunden verilir.
     * @param waitingTime WebElement ekranda gorunur olana kadar beklenecek sure(sn)
     * @return boolean olarak sonuc donulur.
     */
    public boolean isDisplayed(String locator, int... waitingTime) {
        log.info("isDisplayed -  ".concat(locator));
        boolean retValue = false;
        if (isElementPresent(locator, waitingTime)) {
            WebElement element = findElement(locator, waitingTime);
            retValue = element.isDisplayed();
        }
        return retValue;
    }

    public boolean waitForDisplayed(String locator, int... waitingTime) {
        log.info("Wait element displayed -  ".concat(locator));
        boolean isFound = false;
        int count = 0;
        int retryCount = getWaitDuration(waitingTime) / 5;
        while (!isFound && ++count < 5) {
            if (isElementPresent(locator, retryCount)) {
                WebElement element = findElement(locator, retryCount);
                isFound = element.isDisplayed();
            }
        }
        if (!isFound)
            throw new SeleniumExceptionHandle("Element is not displayed for ".concat(locator));
        return isFound;
    }

    /**
     * @param locator     bulunmak istenen webelement'in locator bilgisi By turunde verilir.
     * @param waitingTime WebElement bulunana kadar beklencek max. sure(sn)
     * @return WebElement turunde veri donulur.
     */
    public WebElement findElement(String locator, int... waitingTime) {
        log.info("FindElement - ".concat(locator));
        isElementPresent(locator, waitingTime);
        return webDriver.findElement(By.xpath(locator));
    }

    public List<WebElement> findElements(String locator, int... waitingTime) {
        log.info("FindElement - ".concat(locator));
        findElement(locator, waitingTime);
        return webDriver.findElements(By.xpath(locator));
    }

}
