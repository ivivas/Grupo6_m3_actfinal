package CriteriosDeAceptacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Criterio3 {


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
    public void should_navigate_through_categories() throws InterruptedException {
        //GIVEN
        _browser.get("https://www.demoblaze.com");
        Set<String> categories = new HashSet(Arrays.asList("Phones","Laptops","Monitors"));

        //WHEN
        var elements = _wait.until(presenceOfAllElementsLocatedBy((By.className("list-group-item"))));
        Set<String> firstElements = new HashSet<>();
        for(var element : elements){
            if(categories.contains(element.getText())){
                element.click();
                Thread.sleep(1000);
                var product = _wait.until(presenceOfElementLocated((By.xpath("//*[@id=\"tbodyid\"]/div[1]/div"))));
                var DomTitleElement = product.findElement(By.className("card-title"));
                var title = DomTitleElement.getText();
                firstElements.add(title);
            }
        }

     //THEN
        assertThat(firstElements.size()).isEqualTo(3);
    }



    @After
    public void tearDown() {
        _browser.quit();
    }


}
