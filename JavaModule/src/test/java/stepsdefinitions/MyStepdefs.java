package stepsdefinitions;

import cucumberSetup.CucumberHooks;
import io.cucumber.java.en.Given;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import sqlConnector.mariadb;
import utils.API.wordpressAPI.getUrl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static utils.API.wordpressAPI.postUrl.postToWordpress;

public class MyStepdefs {

    @Given("I launch a {string} request")
    public void iLaunchADbRequest( String arg0) throws SQLException, IOException {
        if(Objects.equals(arg0, "mariadb")){
            ResultSet resultatDeRequete = mariadb.mariadbConnector();
            System.out.println(resultatDeRequete);
        }
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

    @Given("I check elements on the frontend")
    public void iCheckElementsOnTheFrontend() {
        String wordpressWebsiteUrl = "";
        CucumberHooks.driver.get(wordpressWebsiteUrl);
    }
}
