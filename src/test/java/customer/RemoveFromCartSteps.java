package customer;

import customer.ui.cart.CartPage;
import customer.ui.home.HomePage;
import customer.ui.product.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveFromCartSteps {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @Given("I have an {string} in the cart")
    public void i_have_an_in_the_cart(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.open();
        homePage.clickCategory("Phones");
        homePage.clickItem(string);
        productPage.waitContent();
        productPage.clickAddToCartBtn();

    }
    @When("I remove the {string} from the cart")
    public void i_remove_the_from_the_cart(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickNavbarElement("Cart");
        Thread.sleep(1000);
        cartPage.deleteItemFromCart(string);
        cartPage.waitContent();
    }
    @Then("I should not see any product in the cart")
    public void i_should_not_see_any_product_in_the_cart() {
        ArrayList<String> cartItems2 = cartPage.getCartItems();
        assertThat(cartItems2.size()).isEqualTo(0);
    }
}
