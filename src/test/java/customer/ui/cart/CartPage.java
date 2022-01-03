package customer.ui.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageObject {
    private WebDriverWait _wait;
    private JavascriptExecutor _js;

    @FindBy(how= How.ID, using="page-wrapper")
    WebElement cartContent;

    @FindBy(how= How.CSS, using="td:nth-child(2)")
    List<WebElement> cartList;

    @FindBy(how= How.CLASS_NAME, using="success")
    List<WebElement> cartElements;

    public CartPage() {
        this._wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        this._js = (JavascriptExecutor)getDriver();
        PageFactory.initElements(getDriver(), this);
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

    public void clickPlaceOrderBtn() throws InterruptedException {
        _js.executeScript("document.getElementsByClassName(\"btn-success\")[0].click();");
        Thread.sleep(1000);
    }
}
