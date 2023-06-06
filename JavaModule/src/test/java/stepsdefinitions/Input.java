package stepsdefinitions;

import utils.Mails.MailGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Scenario.ScenarioContext;
import static cucumberSetup.CucumberHooks.driver;
import static utils.Mails.MailGenerator.getRandomMail;


public class Input {

    ScenarioContext scenarioContext;
    MailGenerator mailGenerator;

    public Input(ScenarioContext scenarioContext, MailGenerator mailGenerator) {
        this.scenarioContext = scenarioContext;
        this.mailGenerator = mailGenerator;
    }

    @When("I enter my user {string} and {string}")
    public void iEnterMyUserLoginAndPassword(String login, String password) {
        WebElement loginInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }

    @When("I enter my login")
    public void iEnterMyLogin() {
        MailGenerator.setRandomMail();
        String Email = getRandomMail();
        WebElement loginInput = driver.findElement(By.id("reg_email"));
        System.out.println("Ce mail aléatoire a été généré = " + Email);
        loginInput.sendKeys(Email);
        System.out.println("Le sendkey est ok");
    }

    @When("I enter the {string}")
    public void iEnterTheKeyword(String keyword) {
        WebElement searchBar = driver.findElement(By.id("wp-block-search__input-1"));
        searchBar.sendKeys(keyword);
    }

    @And("I click on the search input and validate")
    public void iClickOnTheSearchInputAndValidate() {
        WebElement searchBar = driver.findElement(By.id("wp-block-search__input-1"));
        searchBar.sendKeys(Keys.ENTER);
        System.out.println("search my element OK");
    }
}
