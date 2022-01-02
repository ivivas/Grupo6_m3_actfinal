package customer;

import customer.actions.AuthActions;
import customer.actions.NavigationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

public class SignupSteps {

    @Steps
    NavigationActions navigationActions;
    @Steps
    AuthActions authenticationActions;


    @Given("I want to Sign up")
    public void i_want_to_sign_up() {
        // Write code here that turns the phrase above into concrete actions
        navigationActions.openHomePage();
        navigationActions.openSignupModal();
    }
    @When("I sign up with the user {string} and password {string}")
    public void i_sign_up_with_the_user_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        authenticationActions.typeUsernameAndPassword(string,string2);
    }
    @Then("I should see a success message")
    public void i_should_see_a_success_message() throws InterruptedException {
        Thread.sleep(1000);
        assertThat(navigationActions.retrieveAlertMessage()).isIn("This user already exist.","Sign up successful.");
    }

}
