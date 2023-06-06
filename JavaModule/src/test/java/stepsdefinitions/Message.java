package stepsdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Scenario.ScenarioContext;

import static cucumberSetup.CucumberHooks.driver;
import static org.junit.Assert.assertTrue;

public class Message {
    ScenarioContext scenarioContext;

    public Message(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("An error message appear")
    public void anErrorMessageAppear() {
        WebElement errorMessage = driver.findElement(By.className("woocommerce-error"));
        assertTrue("I have not receive any error message", errorMessage.isDisplayed());
    }
}
