package customer.actions;

import customer.ui.home.CategoriesEnum;
import customer.ui.home.HomePage;
import customer.util.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ResourceType;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static customer.ui.home.HomePage.PRODUCTS;
import static customer.ui.home.HomePage.SIGNUP_MODAL;


public class NavigationActions extends UIInteractionSteps {

    HomePage homePage;



    @Step("Open the homePage")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Open SignUp modal")
    public void openSignupModal(){
        $(HomePage.SIGNUP_BTN_ACTIVATE).click();
        var visible = $(SIGNUP_MODAL).isCurrentlyVisible();
        if(!visible)
            $(SIGNUP_MODAL).waitUntilVisible();
    }
    public String retrieveAlertMessage() {
        Alert alert = homePage.getAlert();
        return alert.getText();
    }

    public boolean selectCategory(CategoriesEnum category) throws Exception {
        var devtools = getDevTools();
        devtools.createSessionIfThereIsNotOne();
        devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        var categoryRequested = onRequestCompleted();
        Future isCorrect = checkCategoryReceived(categoryRequested,category);
        $(HomePage.category(category)).click();
        boolean correct = (boolean) isCorrect.get();
        return correct;
    }

    private Future checkCategoryReceived(Future<CategoriesEnum> categoryRequested,CategoriesEnum expected) {
        CompletableFuture completableFuture = new CompletableFuture<>();

        getDevTools().addListener(Network.responseReceived(),(data)->{
            if(categoryRequested.isDone() && data.getResponse().getUrl().matches(".*/bycat")){

                String  responseBody = getDevTools().send(Network.getResponseBody( data.getRequestId())).getBody();
                JSONParser parser = new JSONParser();
                try {
                 JSONObject parsed = (JSONObject) parser.parse(responseBody);
                 JSONArray items = (JSONArray) parsed.get("Items");
                 JSONObject item = (JSONObject) items.get(0);
                 String category = (String) item.get("cat");
                 var receivedCategory = Utils.stringToCategory(category);
                 if(receivedCategory == expected){
                     completableFuture.complete(true);
                 }else
                     completableFuture.complete(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    completableFuture.complete(false);
                }
            }
        });
        return completableFuture;
    }

    private Future<CategoriesEnum> onRequestCompleted() {
        CompletableFuture<CategoriesEnum> completableFuture = new CompletableFuture<>();
        var devtools = getDevTools();
        devtools.addListener(Network.requestWillBeSent(),(data)->{
            if(data.getRequest().getMethod().matches("POST") && !completableFuture.isDone()) {
                String postData = data.getRequest().getPostData().get();
                Pattern pattern = Pattern.compile(".\"(.*)\":\"(.*)\".");
                Matcher matcher = pattern.matcher(postData);
                if(!matcher.matches()){
                    completableFuture.cancel(true);
                }
                try {
                    completableFuture.complete(Utils.stringToCategory(matcher.group(2)));
                } catch (Exception e) {
                    e.printStackTrace();
                    completableFuture.cancel(true);
                }
            }
        });
        return completableFuture;
    }

    public List<String> getProducts(){
        var products = $$(PRODUCTS);
        List<String> array = new LinkedList<>();
        for(var product : products){
            var title = product.findElement(By.className("card-title"));
            array.add(title.getText());
        }
        return array;

    }

}
