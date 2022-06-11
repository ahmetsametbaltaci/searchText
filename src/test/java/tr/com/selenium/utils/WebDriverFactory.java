package tr.com.selenium.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver webDriver;


    public ChromeOptions setChromeOption(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        if (PropertyUtils.getPropertyValuesFromPomFile("runChromeHeadlessMode").equals("TRUE"))
            chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-gpu");
        return chromeOptions;
    }

    public WebDriver getWebDriver(){
        return webDriver = new ChromeDriver(setChromeOption());
    }


    public void setup(){
        System.setProperty("webdriver.chrome.driver",FileDefinationUtils.getWebDriverPath());
        webDriver = getWebDriver();
    }

    public void teardown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
