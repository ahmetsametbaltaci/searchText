package tr.com.selenium.pages.master;


import com.thoughtworks.gauge.Step;
import tr.com.selenium.enums.ValidationMsg;

public class GeneralStepImpl {

    private static final MasterPage masterPage = MasterPage.getInstance();

    @Step("<validationMsg> Validasyon mesajini dogrula")
    public void checkValidation(ValidationMsg validationMsg){
        masterPage.checkValidationMsg(validationMsg);
    }


}