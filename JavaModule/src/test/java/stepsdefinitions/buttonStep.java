package stepsdefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumClasses.WebElements.Button;
import utils.Scenario.ScenarioContext;

import java.util.Objects;

import static cucumberSetup.CucumberHooks.driver;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class buttonStep {

    ScenarioContext scenarioContext;
    Button button;
    public buttonStep(ScenarioContext scenarioContext, Button button) {
        this.scenarioContext = scenarioContext;
        this.button = button;
    }

    @And("I click on the button {string}")
    public void iClickOnTheButton(String arg0) {
        System.out.println("La valeur de arg0 dans iClickOnTheButton = " + arg0);
        if (Objects.equals(arg0, "identification")) {
            System.out.println("On passe dans la boucle if pour identification");
            String loginText = Button.getLoginButton();
            WebElement loginButton = driver.findElement(By.id(loginText));
            assertTrue("Le bouton identification n'est pas affiché", loginButton.isDisplayed());
            loginButton.click();
            System.out.println("iClickOnTheButton " + arg0 + " successfully launched");
        }
        if (Objects.equals(arg0, "s'enregistrer")) {
            System.out.println("On passe dans la boucle if pour s'enregistrer");
            String registerTextButton = Button.getRegisterButton();
            WebElement registerButton = driver.findElement(By.xpath(registerTextButton));
            assertNotNull("La valeur getRegisterButton() ne récupère pas le bouton s'enregistrer",registerButton);
            assertTrue("Le bouton register n'est pas affiché", registerButton.isDisplayed());
            registerButton.click();
        }
    }
}
