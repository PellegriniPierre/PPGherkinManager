package seleniumClasses.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static cucumberSetup.CucumberHooks.driver;

public class Button {
    public Button(){

    }
    private static final WebElement detailAccount = driver.findElement(By.linkText("Détails du compte"));
    private static final WebElement loginButton = driver.findElement(By.name("login"));
    private static final WebElement registerButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[3]/button"));
    public static WebElement getDetailAccount(){return detailAccount;}
    public static WebElement getLoginButton(){return loginButton;}
    public static WebElement getRegisterButton(){
        System.out.println("On passe dans getRegisterButton");
        return registerButton;}
}
