package customer.ui.product;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class ProductPage extends PageObject {
    private WebDriverWait _wait;
    private JavascriptExecutor _js;
    private Robot _robot;

    @FindBy(how= How.CLASS_NAME, using="product-content")
    WebElement productContent;

    @FindBy(how=How.CLASS_NAME, using="nav-link")
    List<WebElement> navBar;

    public ProductPage() throws AWTException {
        this._wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        this._js = (JavascriptExecutor)getDriver();
        this._robot = new Robot();
        PageFactory.initElements(getDriver(), this);
    }

    public void waitContent() throws InterruptedException {
        _wait.until(ExpectedConditions.visibilityOf(productContent));
        Thread.sleep(2000);
    }

    public void clickAddToCartBtn() throws InterruptedException {
        _js.executeScript("document.getElementsByClassName(\"btn-lg\")[0].click();");
        Thread.sleep(1000);
        _robot.keyPress(KeyEvent.VK_ENTER);
        _robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        _clickNavbarElement("Home");
    }

    private void _clickNavbarElement(String element) {
        for (WebElement el : navBar) {
            if (el.getText().contains(element)) {
                el.click();
                break;
            }
        }
    }
}
