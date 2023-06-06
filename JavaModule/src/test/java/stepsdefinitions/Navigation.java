package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumClasses.WebElements.Button;
import utils.Scenario.ScenarioContext;

import java.util.Objects;

import static cucumberSetup.CucumberHooks.driver;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static seleniumClasses.URL.WordpressURL.getUrlMonCompte;

public class Navigation {
    ScenarioContext scenarioContext;

    public Navigation(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("I am on the {string} page")
    public void iAmOnTheAccountPage(String arg0) {
        assertNotNull(arg0);
        System.out.println("La valeur de ARG0 avant les if dans iAmOnTheAccountPage : " + arg0);
        if(Objects.equals(arg0, "account")){
            String urlCompte = getUrlMonCompte();
            System.out.println("Url de mon compte est: " + urlCompte);
            driver.get(urlCompte);
        }
    }

    @Then("My personal account appear")
    public void myPersonalAccountAppear() {
        WebElement detailAccount = Button.getDetailAccount();
        assertTrue("I am not on My Personal account", detailAccount.isDisplayed());
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver.get("http://20.13.162.105:8000/");
    }

    @Then("The searching page appear with the result of my search")
    public void theSearchingPageAppearWithTheResultOfMySearch() {
        WebElement searchResult = driver.findElement(By.linkText("Elixir de jouvence saveur cookie"));
        assertTrue("I am not on the search result page", searchResult.isDisplayed());
    }
}


