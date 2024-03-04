package stepsdefinitions;

import cucumberSetup.CucumberHooks;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import sqlConnector.mariadb;
import utils.APIRestClasses.getUrl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MyStepdefs {

    @Given("I launch a {string} request")
    public void iLaunchADbRequest( String arg0) throws SQLException, IOException {
        if(Objects.equals(arg0, "mariadb")){
            ResultSet resultatDeRequete = mariadb.mariadbConnector();
            System.out.println(resultatDeRequete);
        }
        if(Objects.equals(arg0, "get")){
            Response response = getUrl.appelUrlInexistante();
            System.out.println("Body = "+ response.getBody());
            System.out.println("StatusText = " + response);
        }
        if(Objects.equals(arg0, "post")){
            Response response = getUrl.appelUrlInexistante();
            System.out.println("Status code = " + response.andReturn());
            System.out.println("Body = "+ response.getBody());
            System.out.println("StatusText = " + response.andReturn());
        }
    }

    @Given("I check elements on the frontend")
    public void iCheckElementsOnTheFrontend() {
        String wordpressWebsiteUrl = "";
        CucumberHooks.driver.get(wordpressWebsiteUrl);
    }
}
