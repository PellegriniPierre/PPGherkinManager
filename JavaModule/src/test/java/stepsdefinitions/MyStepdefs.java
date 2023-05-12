package stepsdefinitions;

import cucumberSetup.CucumberHooks;
import io.cucumber.java.en.Given;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import sqlConnector.mariadb;
import utils.APIRestClasses.getUrl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static utils.APIRestClasses.postUrl.postToWordpress;

public class MyStepdefs {
    @Given("I do a {string} request to API")
    public void iAmAtTheLoginPageAsAnUserOrAdminSuperAdminRole(String arg0) throws IOException {

        if(Objects.equals(arg0, "get")){
            HttpResponse<JsonNode> response = getUrl.appelUrl();
            System.out.println("Status code = " + response.getStatus());
            System.out.println("Body = "+ response.getBody());
            System.out.println("StatusText = " + response.getStatusText());
        }
        if(Objects.equals(arg0, "post")){
            HttpResponse<JsonNode> response = postToWordpress();
            System.out.println("Status code = " + response.getStatus());
            System.out.println("Body = "+ response.getBody());
            System.out.println("StatusText = " + response.getStatusText());
        }
    }

    @Given("I launch a db request")
    public void iLaunchADbRequest() throws SQLException {
        ResultSet resultatDeRequete = mariadb.mariadbConnector();
        System.out.println(resultatDeRequete);
    }

    @Given("I check elements on the frontend")
    public void iCheckElementsOnTheFrontend() {
        String wordpressWebsiteUrl = "";
        CucumberHooks.driver.get(wordpressWebsiteUrl);
    }
}
