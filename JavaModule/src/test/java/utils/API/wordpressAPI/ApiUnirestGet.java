package utils.API.wordpressAPI;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class ApiUnirestGet {

    public static HttpResponse<JsonNode> appelUrl(){
        String apiPostsUrl = "wp-json/wp/v2";
        String siteWeb = "http://20.13.162.105:8000/";
        return Unirest.get(siteWeb + apiPostsUrl)
                .asJson();
    }

    public static HttpResponse<JsonNode> appelUrlMyAccount(){
        String apiPostsUrl = "wp-json/wp/v2";
        String siteWeb = "http://20.13.162.105:8000/mon-compte/";
        HttpResponse<JsonNode> getJsonResponse = Unirest.get(siteWeb + apiPostsUrl)
                .asJson();
        return getJsonResponse;
    }
}
