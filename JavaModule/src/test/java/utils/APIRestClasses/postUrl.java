package utils.APIRestClasses;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;

import static utils.Json.JsonUtilities.jsonReplaceJsonDataWithInputData;

public class postUrl {
    public static HttpResponse<JsonNode> postToWordpress() throws IOException {
        Object body = jsonReplaceJsonDataWithInputData("../resources/JsonTemplates/WordpressAJC/template1.json");
        return Unirest.post("http://20.13.162.105:8000/?p=3")
                .body(body)
                .asJson();
    }
}
