package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderModal {
    private WebDriver _driver;
    private WebDriverWait _wait;
    private JavascriptExecutor _js;

    @FindBy(how= How.ID, using="orderModal")
    WebElement orderContent;

    @FindBy(how= How.ID, using="name")
    WebElement nameInput;

    @FindBy(how= How.ID, using="country")
    WebElement countryInput;

    @FindBy(how= How.ID, using="city")
    WebElement cityInput;

    @FindBy(how= How.ID, using="card")
    WebElement cardInput;

    @FindBy(how= How.ID, using="month")
    WebElement monthInput;

    @FindBy(how= How.ID, using="year")
    WebElement yearInput;

    @FindBy(how= How.CLASS_NAME, using="sweet-alert")
    WebElement purchaseAlert;

    public PlaceOrderModal(WebDriver driver) {
        this._driver = driver;
        this._wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
        this._js = (JavascriptExecutor)_driver;
        PageFactory.initElements(_driver, this);
    }

    public void waitContent() throws InterruptedException {
        _wait.until(ExpectedConditions.visibilityOf(orderContent));
        Thread.sleep(1000);
    }

    public void setName(String username) {
        nameInput.sendKeys(username);
    }

    public void setCountry(String country) {
        countryInput.sendKeys(country);
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setCard(String card) {
        cardInput.sendKeys(card);
    }

    public void setMonth(String month) {
        monthInput.sendKeys(month);
    }

    public void setYear(String year) {
        yearInput.sendKeys(year);
    }

    public void clickPurchaseBtn() {
        _js.executeScript("document.getElementsByClassName(\"btn-primary\")[2].click();");
    }

    public String getPurchaseAlertText() throws InterruptedException {
        Thread.sleep(1000);
        return purchaseAlert.getText();
    }
}
