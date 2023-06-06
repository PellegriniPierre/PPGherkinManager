package utils.API.wordpressAPI;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.io.IOException;
import static utils.Json.JsonUtilities.jsonReplaceJsonDataWithInputData;

public class ApiUnirestPost {
    public static HttpResponse<JsonNode> postToWordpress() throws IOException {
        String apiKey = "eyJhbGciOiJIUzI1NiJ9.e30.m9DO5q5CvM2UBU-RdbGf2ZSpjfXgLU75kfs0Jvhx_zY";
        Object body = jsonReplaceJsonDataWithInputData("/Users/tiffanybouju/Documents/Maven/AJCFormationProject/src/test/resources/JsonTemplates/OpenAI/template2.json");
        return Unirest.post("http://20.13.162.105:8000/wp-json/wp/v2/")
                .header("Content-Type", "application/json")
                .header("Authorization", "token " + apiKey)
                .body(body)
                .asJson();
    }

    public static HttpResponse<JsonNode> postToApiGeneratorImage() throws IOException {
        String apiKey = "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";
        //String model = "image-alpha-001";
        Object body = jsonReplaceJsonDataWithInputData("/Users/tiffanybouju/Documents/Maven/AJCFormationProject/src/test/resources/JsonTemplates/OpenAI/template1.json");
        return Unirest.post("https://api.openai.com/v1/images/generations")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .body(body)
                .asJson();
    }
}
