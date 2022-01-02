package customer.ui.home;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@DefaultUrl("https://www.demoblaze.com")
public class HomePage extends PageObject {

    public static final By SIGNUP_MODAL = By.id("signInModal");
    public  static final By SIGNUP_BTN_ACTIVATE = By.id("signin2");
    public  static final By SIGNUP_BTN_ACCEPT = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public  static final By SIGNUP_FIELD_USERNAME = By.id("sign-username");
    public  static final By SIGNUP_FIELD_PASSWORD = By.id("sign-password");

    public static final By PRODUCTS = By.className("card");


    public static final By category(CategoriesEnum category ) throws Exception {
      switch (category){
          case PHONES -> { return By.xpath("/html/body/div[5]/div/div[1]/div/a[2]");}
          case LAPTOPS -> { return By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"); }
          case MONITORS -> { return By.xpath("/html/body/div[5]/div/div[1]/div/a[4]"); }
          default -> { throw new Exception("Not existent category");}
      }
    };

    //------------------- NO BDD ------------------



    @FindBy(how= How.ID, using="login2")
    WebElement loginBtn;

    @FindBy(how=How.ID, using="nameofuser")
    WebElement username;

    @FindBy(how=How.CLASS_NAME, using="list-group-item")
    List<WebElement> categories;

    @FindBy(how=How.CLASS_NAME, using="nav-link")
    List<WebElement> navBar;

    @FindBy(how=How.CLASS_NAME, using="hrefch")
    List<WebElement> itemList;

    public HomePage() {
        //this._driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

   /* public void getHomePage(String url) {
        this._driver.get(url);
    }
*/
    public void loginBtnClick() {
        loginBtn.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public void clickCategory(String category) throws InterruptedException {
        for (WebElement cat : categories) {
            if (cat.getText().contains(category)) {
                cat.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    public void clickItem(String itemName) throws InterruptedException {
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
