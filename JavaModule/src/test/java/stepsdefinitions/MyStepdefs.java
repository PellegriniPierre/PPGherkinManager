package stepsdefinitions;

import io.cucumber.java.en.Given;
import kong.unirest.*;

import java.io.IOException;

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
}
