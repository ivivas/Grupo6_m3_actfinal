package customer.browseSteps;

import customer.actions.AuthActions;
import customer.actions.NavigationActions;
import customer.ui.home.CategoriesEnum;
import customer.ui.home.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowseSteps {

    @Steps
    NavigationActions navigationActions;
    @Steps
    AuthActions authenticationActions;

    int[] elements = new int[3];

    @Given("I want to browse products")
    public void i_want_to_browse_products() {
        // Write code here that turns the phrase above into concrete actions
        navigationActions.openHomePage();
    }
    @When("I want to visualize the three different categories")
    public void i_want_to_visualize_the_three_different_categories() throws Exception {
        // Write code here that turns the phrase above into concrete actions
         navigationActions.selectCategory(CategoriesEnum.PHONES);
         var products = navigationActions.getProducts();
         elements[0]= products.size();
        navigationActions.selectCategory(CategoriesEnum.LAPTOPS);
        products = navigationActions.getProducts();
        elements[1]= products.size();
        navigationActions.selectCategory(CategoriesEnum.MONITORS);
         products = navigationActions.getProducts();
        elements[2]= products.size();

    }
    @Then("I should see the products in each category")
    public void i_should_see_the_products_in_each_category() {
        // Write code here that turns the phrase above into concrete actions
        assertThat(elements[0]).isGreaterThan(0);
        assertThat(elements[1]).isGreaterThan(0);
        assertThat(elements[2]).isGreaterThan(0);

    }
}
