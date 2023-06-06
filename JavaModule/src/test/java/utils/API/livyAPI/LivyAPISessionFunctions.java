package utils.API.livyAPI;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import static utils.Constants.LIVY_URL;

public class LivyAPISessionFunctions {
    public LivyAPISessionFunctions(){

    }
    public static HttpResponse<JsonNode> requestGetLivyAPISession(){
        String sessionID = "975";
        String url = LIVY_URL+ "/sessions" + sessionID;
        System.out.println("URL for requestGetLivyAPISession: " + url);
        HttpResponse<JsonNode> getBatchInformations = null;

        try {
            getBatchInformations = Unirest.get(url)
                    .asJson();
        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert getBatchInformations != null;

        return getBatchInformations;
    }
    private static String requestGetLivyAPISessionState(){
        return null;
    }
    private static String requestDeleteLivyAPISession(){
        return null;
    }
    private static String requestGetLivyAPISessionLog(){
        return null;
    }
    private static String requestGetLivyAPISessionStatement(){
        return null;
    }
    private static String requestPostLivyAPISessionStatement(){
        return null;
    }
    private static String requestPostLivyAPISessionStatementCancel(){
        return null;
    }
    private static String requestPostLivyAPISessionCompletion(){
        return null;
    }
    private static String requestGetLivyAPISessions() {
        return null; }
    private static HttpResponse<JsonNode> requestPostLivyAPISessions(){
        return null;
    }
}
