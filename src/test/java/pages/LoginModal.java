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

public class LoginModal {
    private WebDriver _driver;
    private WebDriverWait _wait;
    private JavascriptExecutor _js;

    @FindBy(how= How.ID, using="logInModal")
    WebElement modalContent;

    @FindBy(how= How.ID, using="loginusername")
    WebElement usernameInput;

    @FindBy(how= How.ID, using="loginpassword")
    WebElement passwordInput;

    @FindBy(how= How.CLASS_NAME, using="btn-primary")
    WebElement loginSubmitBtn;

    public LoginModal(WebDriver driver) {
        this._driver = driver;
        this._wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
        this._js = (JavascriptExecutor)_driver;
        PageFactory.initElements(_driver, this);
    }

    public void waitContent() {
        _wait.until(ExpectedConditions.visibilityOf(modalContent));
    }

    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        _js.executeScript("document.getElementsByClassName(\"btn-primary\")[2].click();");
    }
}
