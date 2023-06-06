package seleniumClasses.URL;

import org.openqa.selenium.WebElement;

import static cucumberSetup.CucumberHooks.driver;

public class WordpressURL {
    public WordpressURL(){

    }

    static String urlMonCompte = "http://20.13.162.105:8000/mon-compte/";

    public static String getUrlMonCompte() {
        return urlMonCompte;
    }
}
