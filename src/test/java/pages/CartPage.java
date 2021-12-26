package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver _driver;
    private WebDriverWait _wait;

    @FindBy(how= How.ID, using="page-wrapper")
    WebElement cartContent;

    @FindBy(how= How.CSS, using="td:nth-child(2)")
    List<WebElement> cartList;

    @FindBy(how= How.CLASS_NAME, using="success")
    List<WebElement> cartElements;

    public CartPage(WebDriver driver) {
        this._driver = driver;
        this._wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
        PageFactory.initElements(_driver, this);
    }

    public void waitContent() throws InterruptedException {
        _wait.until(ExpectedConditions.visibilityOf(cartContent));
        Thread.sleep(2000);
    }

    public ArrayList<String> getCartItems() {
        ArrayList<String> cartItems = new ArrayList<String>();
        for (WebElement el : cartList) {
            cartItems.add(el.getText());
        }

        return cartItems;
    }

    public void deleteItemFromCart(String itemName) {
        for (WebElement el : cartElements) {
            if (el.getText().contains(itemName)) {
                el.findElement(By.cssSelector("td:nth-child(4) a")).click();
                break;
            }

        }
    }
}
