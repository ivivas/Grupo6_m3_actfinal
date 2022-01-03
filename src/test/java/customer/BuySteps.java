package customer;

import customer.ui.cart.CartPage;
import customer.ui.cart.modals.PlaceOrderModal;
import customer.ui.home.HomePage;
import customer.ui.product.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BuySteps {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    PlaceOrderModal orderModal;
    @Given("I have a {string} in the cart")
    public void i_have_a_in_the_cart(String string) throws InterruptedException {
        homePage.open();
        homePage.clickCategory("Phones");
        homePage.clickItem(string);
        productPage.waitContent();
        productPage.clickAddToCartBtn();
    }
    @When("I buy the product")
    public void i_buy_the_product() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickNavbarElement("Cart");
        Thread.sleep(1000);
        cartPage.clickPlaceOrderBtn();
        orderModal.waitContent();
        orderModal.setName("Ivan");
        orderModal.setCountry("Chile");
        orderModal.setCity("Santiago");
        orderModal.setCard("0000 1111 2222 3333");
        orderModal.setMonth("Diciembre");
        orderModal.setYear("2021");
        orderModal.clickPurchaseBtn();

    }
    @Then("I should see {string}")
    public void i_should_see_the_success_message(String message) throws InterruptedException {
        String alertText = orderModal.getPurchaseAlertText();
        assertThat(alertText).containsIgnoringCase(message);

    }

}
