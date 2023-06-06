package stepsdefinitions;

import utils.API.wordpressAPI.ApiUnirestGet;
import utils.API.wordpressAPI.ApiUnirestPost;
import utils.Mails.MailGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import utils.Scenario.ScenarioContext;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;


public class MyStepDefinitions {

    ScenarioContext scenarioContext;
    MailGenerator mailGenerator;

    public MyStepDefinitions(ScenarioContext scenarioContext, MailGenerator mailGenerator) {
        this.scenarioContext = scenarioContext;
        this.mailGenerator = mailGenerator;
    }
    @Given("I call Api Get to Wordpress")
    public void iCallApiGetToWordpress() {
        HttpResponse<JsonNode> responseGet = ApiUnirestGet.appelUrl();
        System.out.println("body responseGet = " + responseGet.getBody());
        System.out.println("Status responseGet = " + responseGet.getStatus());
        System.out.println("Headers responseGet = " + responseGet.getHeaders());
    }

    @Given("I call Api Post to Wordpress")
    public void iCallApiPostToWordpress() throws IOException {
        HttpResponse<JsonNode> responsePost = ApiUnirestPost.postToWordpress();
        System.out.println("body responsePost = " + responsePost.getBody());
    }

    @Given("I call Api Generator Image Post")
    public void iCallApiGeneratorImagePost() throws IOException {
        HttpResponse<JsonNode> responsePost = ApiUnirestPost.postToApiGeneratorImage();
        System.out.println("body responsePost = " + responsePost.getBody());
    }

    @Then("I delete the user created")
    public void iDeleteTheUserCreated() {
        String MailCreated = mailGenerator.getRandomMail();
        System.out.println("MailCreated dans iDeleteTheUserCreated ="+ MailCreated);
        assertEquals("Have fun with the Delete continuation, you have now the generated mail on the other class @Tiffany ;)","Un assert qui sera toujours faux",MailCreated);
    }

}
