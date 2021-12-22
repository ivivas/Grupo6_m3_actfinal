package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver _driver;

    @FindBy(how=How.ID, using="login2")
    WebElement loginBtn;

    @FindBy(how=How.ID, using="nameofuser")
    WebElement username;

    @FindBy(how=How.CLASS_NAME, using="list-group-item")
    List<WebElement> categories;

    @FindBy(how=How.CLASS_NAME, using="nav-link")
    List<WebElement> navBar;

    @FindBy(how=How.CLASS_NAME, using="hrefch")
    List<WebElement> itemList;

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

    public void clickCategory(String category) {
        for (WebElement cat : categories) {
            System.out.println(cat);
            if (cat.getText().contains(category)) {
                cat.click();
                break;
            }
        }
    }

    public void clickItem(String itemName) {
        for (WebElement item : itemList) {
            if (item.getText().contains(itemName)) {
                item.click();
                break;
            }
        }
    }

    public void clickNavbarElement(String element) {
        for (WebElement el : navBar) {
            if (el.getText().equals(element)) {
                el.click();
                break;
            }
        }
    }
}
