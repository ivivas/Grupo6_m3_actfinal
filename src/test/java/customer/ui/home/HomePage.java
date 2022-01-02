package customer.ui.home;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import net.thucydides.core.annotations.*;
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




}
