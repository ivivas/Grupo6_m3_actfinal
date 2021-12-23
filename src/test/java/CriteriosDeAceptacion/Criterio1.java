package CriteriosDeAceptacion;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Criterio1 {

    private WebDriver _browser;
    private WebDriverWait _wait;
    private JavascriptExecutor _js;

    @Before

    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chrome/chromedriver.exe");
        _browser = new ChromeDriver();
        _wait = new WebDriverWait(_browser, Duration.ofSeconds(5));
        _js = (JavascriptExecutor)_browser;
    }




    @Test
    public void should_open_url() throws InterruptedException {
        //GIVEN
        _browser.get("https://www.demoblaze.com");

        //WHEN
        //_browser.findElement(By.id("sb_form_q")).sendKeys("CHEESECAKE" + Keys.ENTER);
        _wait.until(presenceOfElementLocated(By.id("signin2")));
        _browser.findElement(By.id("signin2")).click();
        _wait.until(visibilityOfElementLocated(By.id("sign-username")));
        findTextFieldAndWrite("sign-username","u-testing");
        findTextFieldAndWrite("sign-password","u-testing");
        Thread.sleep(1000);                          // Put this sleep command.
        _wait.until(elementToBeClickable(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"))).click();
        Thread.sleep(1000);
        Alert alert = _browser.switchTo().alert();// Put this sleep command.
        var text = alert.getText();
        alert.accept();
        var actions = new Actions(_browser);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        //THEN
        assertThat(text).isIn("This user already exist.","Sign up successful.");
    }
    private void findTextFieldAndWrite(String id, String content) {
        var username = _browser.findElement(By.id(id));
        username.sendKeys(content);


    }


    @After
    public void tearDown() {
        _browser.quit();
    }
}
