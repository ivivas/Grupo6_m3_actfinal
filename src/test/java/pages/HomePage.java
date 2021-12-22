package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver _driver;

    @FindBy(how=How.ID, using="login2")
    WebElement loginBtn;

    @FindBy(how=How.ID, using="nameofuser")
    WebElement username;

    public HomePage(WebDriver driver) {
        this._driver = driver;
        PageFactory.initElements(_driver, this);
    }

    public void getHomePage(String url) {
        this._driver.get(url);
    }

    public void loginBtnClick() {
        loginBtn.click();
    }

    public String getUsername() {
        return username.getText();
    }
}
