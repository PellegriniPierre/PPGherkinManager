package utils.APIRestClasses;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class getURL {
    public static HttpResponse<JsonNode> appelUrl(){
        return Unirest.get("http://20.13.162.105:8000/?p=3")
                .asJson();
    }
}
