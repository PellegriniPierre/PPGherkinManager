package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyStepdefs {
    @Given("I call API")
    public void iAmAtTheLoginPageAsAnUserOrAdminSuperAdminRole(){
        Response response = RestAssured.get("http://20.13.162.105:8000/?p=3");
        System.out.println("Status code = " + response.getStatusCode());
        System.out.println("Body = "+ response.getBody().prettyPrint());
    }
}
