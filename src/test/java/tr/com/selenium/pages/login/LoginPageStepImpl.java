package tr.com.selenium.pages.login;


import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import tr.com.selenium.pages.master.MasterPage;

public class LoginPageStepImpl {

    private static final LoginPage loginPage = LoginPage.getInstance();

    @Step("Uygulamayi ac")
    public void openWebSite(){
        loginPage.openWebSite();
    }

    @Step("Login Butonuna tikla")
    public void loginApp(){
        loginPage.clickLogin();
    }

    @Step("Kullanici adi ve sifre bilgisini gir <table>")
    public void fillForm(Table table){
        loginPage.fillLoginForm(table);
    }

    @Step("Basarili olarak login oldugunu dogrula")
    public void checkSuccessLogin(){
        loginPage.checkSuccessLogin();
    }



}