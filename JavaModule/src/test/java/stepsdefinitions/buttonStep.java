package stepsdefinitions;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import seleniumClasses.WebElements.Button;
import utils.Scenario.ScenarioContext;

import java.util.Objects;

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
            System.out.println("Je passe dans la boucle if pour identification");
            WebElement loginButton = Button.getLoginButton();
            assertTrue("Le bouton identification n'est pas affiché", loginButton.isDisplayed());
            loginButton.click();
            System.out.println("iClickOnTheButton " + arg0 + " successfully launched");
        }
        if (Objects.equals(arg0, "s'enregistrer")) {
            System.out.println("Je passe dans la boucle if pour s'enregistrer");
            WebElement registerButton = Button.getRegisterButton();
            assertNotNull("La valeur getRegisterButton() ne récupère pas le bouton s'enregistrer",registerButton);
            assertTrue("Le bouton register n'est pas affiché", registerButton.isDisplayed());
            registerButton.click();
        }
    }
}
