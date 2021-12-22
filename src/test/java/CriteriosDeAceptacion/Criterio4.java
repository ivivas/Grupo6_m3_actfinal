package CriteriosDeAceptacion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import java.awt.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Criterio4 {
    private WebDriver _driver;
    private String _HOMEPAGE_URL = "https://www.demoblaze.com/index.html";

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chrome/chromedriver.exe");
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
    }

    @Test
    // COMO usuario QUIERO añadir al carrito un Samsung galaxy s7, Samsung galaxy s6 y un Sony vaio i7.
    public void criterio4() throws InterruptedException, AWTException {
        //GIVEN
        String item1 = "galaxy s7";
        String item2 = "galaxy s6";
        String item3 = "vaio i7";
        HomePage homePage = new HomePage(_driver);
        homePage.getHomePage(_HOMEPAGE_URL);
        ProductPage productPage = new ProductPage(_driver);
        CartPage cartPage = new CartPage(_driver);

        //WHEN
        // Add item 1 to cart
        homePage.clickCategory("Phones");
        Thread.sleep(2000);
        homePage.clickItem(item1);
        productPage.waitContent();
        Thread.sleep(2000);
        productPage.clickAddToCartBtn();

        // Add item 2 to cart
        Thread.sleep(2000);
        homePage.clickItem(item2);
        productPage.waitContent();
        productPage.clickAddToCartBtn();
        Thread.sleep(2000);

        // Add item 3 to cart
        homePage.clickCategory("Laptops");
        Thread.sleep(2000);
        homePage.clickItem(item3);
        productPage.waitContent();
        Thread.sleep(2000);
        productPage.clickAddToCartBtn();

        //THEN
        homePage.clickNavbarElement("Cart");
        cartPage.waitContent();
        ArrayList<String> cartItems = cartPage.getCartItems();
        int count = 0;
        for (String item : cartItems) {
            if (item.contains(item1) || item.contains(item2) || item.contains(item3)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(3);

    }
}
