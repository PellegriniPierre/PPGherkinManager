package stepsdefinitions;

import io.cucumber.java.en.Given;
import kong.unirest.*;
import sqlConnector.mariadb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cucumberSetup.CucumberHooks.driver;
import static utils.APIRestClasses.postUrl.postToWordpress;

public class MyStepdefs {
    @Given("I call API")
    public void iAmAtTheLoginPageAsAnUserOrAdminSuperAdminRole() throws IOException {
        HttpResponse<JsonNode> response = utils.APIRestClasses.getURL.appelUrl();
        postToWordpress();
        System.out.println("Status code = " + response.getStatus());
        System.out.println("Body = "+ response.getBody());
        System.out.println("StatusText = " + response.getStatusText());
    }

    @Given("I launch a db request")
    public void iLaunchADbRequest() throws SQLException {
        ResultSet resultatDeRequete = mariadb.mariadbConnector();
        System.out.println(resultatDeRequete);
    }

    @Given("I check elements on the frontend")
    public void iCheckElementsOnTheFrontend() {
        String wordpressWebsiteUrl = "";
        driver.get(wordpressWebsiteUrl);

    }
}
