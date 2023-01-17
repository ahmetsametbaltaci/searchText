package tr.com.selenium.pages.login;


public interface LoginPageElement {

    String BTN_LOGIN ="//div[@id='account-navigation-container']//p[text()='%s']//ancestor::div[@class='account-nav-item user-login-container']";
    String BTN_MY_BASKET ="//div[@id='account-navigation-container']//p[text()='%s']";
    String INPUT_EMAIL = "//div//input[@id='login-email']";
    String INPUT_PASSWORD = "//div//input[@id='login-password-input']";
    String BTN_SUBMIT = "//div//button[@type='submit']";
    String BTN_POPUP_CLOSE = "//div[@class='modal-content']//div[@class='modal-close']";



}
