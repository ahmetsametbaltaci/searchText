package tr.com.selenium.enums;

import tr.com.selenium.utils.TranslationUtils;

public enum ValidationMsg {

    EMAIL_OR_MAIL_INCORRECT ("Txt.eMail.Password.Incorrect");



    private final String text;


    ValidationMsg(String text) {
        this.text = text;
    }


    public String toString() {
        return TranslationUtils.getTranslation(text);
    }

}
