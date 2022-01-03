package customer;

import customer.ui.cart.CartPage;
import customer.ui.home.HomePage;
import customer.ui.product.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;;import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AddToCartSteps {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @Given("I want to add a products into the cart")
    public void i_want_to_add_a_products_into_the_cart() {
        // Write code here that turns the phrase above into concrete actions

        homePage.open();
    }
    @When("I add a {string}, {string} and {string}")
    public void i_add_a_galaxy_s7_and_s6_plus_a_sony_vaio_i7(String product1,String product2, String product3) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //WHEN
        // Add item 1 to cart
        homePage.clickCategory("Phones");
        homePage.clickItem(product1);
        productPage.waitContent();
        productPage.clickAddToCartBtn();

        // Add item 2 to cart
        Thread.sleep(2000);
        homePage.clickItem(product2);
        productPage.waitContent();
        productPage.clickAddToCartBtn();

        // Add item 3 to cart
        homePage.clickCategory("Laptops");
        Thread.sleep(2000);
        homePage.clickItem(product3);
        productPage.waitContent();
        productPage.clickAddToCartBtn();
    }
    @Then("I should see {string}, {string} and {string} in the cart")
    public void i_should_see_the_products_in_the_cart(String product1,String product2, String product3) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(1000);
        homePage.clickNavbarElement("Cart");
        cartPage.waitContent();
        ArrayList<String> cartItems = cartPage.getCartItems();
        int count = 0;
        for (String item : cartItems) {
            if (item.contains(product1) || item.contains(product2) || item.contains(product3)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(3);
    }

}
