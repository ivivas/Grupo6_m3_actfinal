package customer.ui.home.modals;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginModal extends PageObject {
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

    public LoginModal() {
        this._wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        this._js = (JavascriptExecutor)getDriver();
        PageFactory.initElements(getDriver(), this);
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
