package CriteriosDeAceptacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginModal;

import static org.assertj.core.api.Assertions.assertThat;

public class Criterio2 {
    private WebDriver _driver;
    private String _HOMEPAGE = "https://www.demoblaze.com/index.html";
    private String _USERNAME = "Master_Grupo6";
    private String _PASSWORD = "1234";

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chrome/chromedriver.exe");
        _driver = new ChromeDriver();
    }

    @Test
    // COMO usuario QUIERO ser capaz de iniciar sesión en la Tienda Online.
    public void criterio2() throws InterruptedException {
        //GIVEN
        HomePage homePage = new HomePage(_driver);
        homePage.getHomePage(_HOMEPAGE);
        LoginModal loginmodal = new LoginModal(_driver);

        //WHEN
        homePage.loginBtnClick();
        loginmodal.waitContent();
        loginmodal.setUsername(_USERNAME);
        loginmodal.setPassword(_PASSWORD);
        Thread.sleep(1000);
        loginmodal.clickLoginBtn();

        //THEN
        Thread.sleep(2000);
        String username = homePage.getUsername();
        assertThat(username).containsIgnoringCase("Welcome " + _USERNAME);
    }

    @After
    public void tearDown() {
        _driver.quit();
    }
}
