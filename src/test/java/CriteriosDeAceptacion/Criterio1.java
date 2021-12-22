package CriteriosDeAceptacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

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
    public void should_open_url(){
        //GIVEN
        _browser.get("https://duckduckgo.com/");

        //WHEN
        //_browser.findElement(By.id("sb_form_q")).sendKeys("CHEESECAKE" + Keys.ENTER);
        _wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"pg-index\"]/div")));
        String title = _browser.getTitle();

        //THEN
        assertThat(title).containsIgnoringCase("DuckDuckGo");
    }

    @After
    public void tearDown() {
        _browser.quit();
    }
}
