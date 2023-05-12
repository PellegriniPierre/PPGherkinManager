package utils.APIRestClasses;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;

import static utils.Json.JsonUtilities.jsonReplaceJsonDataWithInputData;

public class postUrl {
    public static HttpResponse<JsonNode> postToWordpress() throws IOException {
        /* TODO: mapper l'api avec classes + url */
        String urlPostToWordpress =  "http://20.13.162.105:8000/wp-toto";
        String pathToTemplate = "src/test/resources/JsonTemplates/WordpressAJC/template1.json";
        Object body = jsonReplaceJsonDataWithInputData(pathToTemplate);
        return Unirest.post(urlPostToWordpress)
                .body(body)
                .asJson();
    }
}
