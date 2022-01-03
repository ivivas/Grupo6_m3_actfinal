package customer.actions;

import customer.ui.home.HomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class AuthActions extends UIInteractionSteps {
    @Step("Type credentials to signup")
    public void typeUsernameAndPassword(String string, String string2) {
        $(HomePage.SIGNUP_FIELD_USERNAME).waitUntilClickable();
        $(HomePage.SIGNUP_FIELD_USERNAME).type(string);
        $(HomePage.SIGNUP_FIELD_PASSWORD).type(string);
        $(HomePage.SIGNUP_BTN_ACCEPT).click();
    }


    public void shoudSeeASuccessMessage() {



    }

}
