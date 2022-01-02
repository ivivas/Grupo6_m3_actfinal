package customer;

import customer.ui.home.HomePage;
import customer.ui.home.modals.LoginModal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {
    HomePage homePage;
    LoginModal loginmodal;
    String _username;
    @Given("I want to login")
    public void i_want_to_login() {

        homePage = new HomePage();
        loginmodal = new LoginModal();
        homePage.open();
    }
    @When("I login with the user {string} and password {string}")
    public void i_login_with_the_user_and_password(String string, String string2) throws InterruptedException {
        homePage.loginBtnClick();
        loginmodal.waitContent();
        _username = string;
        loginmodal.setUsername(string);
        loginmodal.setPassword(string2);
        Thread.sleep(1000);
        loginmodal.clickLoginBtn();
    }
    @Then("I should see the welcome message in the page")
    public void i_should_see_the_welcome_message_in_the_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        String username = homePage.getUsername();
        assertThat(username).containsIgnoringCase("Welcome " +_username );
    }

}
