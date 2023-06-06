package utils.API.zeppelinAPI;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.assertNotEquals;
import static utils.API.zeppelinAPI.ZeppelinAPINotebooksFunctions.*;
import static utils.Constants.*;
import static utils.ScenarioContext.getCookie;

public class ZeppelinAPIToolsFunctions {
    public ZeppelinAPIToolsFunctions(){
    }
    public static String SearchNotebookIDInList(String notebookName) {
        HttpResponse<JsonNode> getNoteBookList = getNotebookList();
        JSONObject NotebookBody = null;
        JSONArray body = null;
        String NotebookID = null;

        if (getNoteBookList.getBody() != null) {
            NotebookBody = getNoteBookList.getBody().getObject();
        }
        if (NotebookBody != null) {
            body = NotebookBody.getJSONArray("body");
        }
        if (NotebookBody != null) {
            int jsonArray = body.length();
            String ColumnName = "name";
            String ColumnId = "id";
            for (int i = 0; i < jsonArray; i++) {
                JSONObject bodyIndex = body.getJSONObject(i);
                if (bodyIndex.getString(ColumnName).contains(notebookName)) {
                    NotebookID = bodyIndex.getString(ColumnId);
                }
            }
        }
        return NotebookID;
    }

    public static String SearchParagraphID(int index, String notebookName) {
        HttpResponse<JsonNode> paragraphIDRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName);
        paragraphIDRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> paragraphIDResponse = paragraphIDRequest;
        assertNotEquals("Null body on paragraphIDResponse", null, paragraphIDResponse.getBody());
        return String.valueOf(paragraphIDResponse.getBody().getObject().getJSONObject("body").getJSONArray("paragraphs").getJSONObject(index).get("id"));
    }
    public static int getPermissionHttpStatus(String notebookName){
        return getNotePermissionInformation(notebookName).getStatus();
    }
    public static int setPermissionHttpStatus(String notebookName) throws IOException {
        return setNotePermission(notebookName).getStatus();
    }
    public static int getCreateNewNoteHttpStatus(String notebookName) throws IOException {
        return createNewNote(notebookName).getStatus();
    }
    public static int
    runParagraphStatus(int index, String notebookName){
        return runParagraphSynchronously(index, notebookName).getStatus();
    }
    public static int runAllParagraphsStatus(String notebookName){
        return runAllParagraphs(notebookName).getStatus();
    }
    public static int getNotebookRunStatus(String notebookName){
        return getExistingNoteInformation(notebookName).getStatus();
    }
    public static String getParagraphResultCodeByIndex(int index, String notebookName) {
        System.out.println("Index in getParagraphResultCodeByIndex = " + index);
        System.out.println("notebookName in getParagraphResultCodeByIndex = " + notebookName);
        assertNotEquals("Null on index integer", null, index);
        assertNotEquals("Null on notebookName string", null, notebookName);
        String status = getParagraphRunStatusResult(index, notebookName).getBody().getObject().getJSONObject("body").getString("status");
        assertNotEquals("Null on status string", null, status);
        int progress = getParagraphRunStatusResult(index, notebookName).getBody().getObject().getJSONObject("body").getInt("progress");
        assertNotEquals("Null on progress int", null, progress);
        String returnString;
        if (Objects.equals(status, "FINISHED")) {
            returnString = status;
        } else {
            if(Objects.equals(status, "PENDING") || Objects.equals(status, "RUNNING")){
                for(progress = 0 ;progress < 100;progress = getParagraphRunStatusResult(index, notebookName).getBody().getObject().getJSONObject("body").getInt("progress")){
                    System.out.println("progress in getParagraphResultCodeByIndex =" + progress + "\nstatus in getParagraphResultCodeByIndex = " + getParagraphRunStatusResult(index, notebookName).getBody().getObject().getJSONObject("body").getString("status") );
                }
            }
            returnString = getParagraphRunStatusResult(index, notebookName).getBody().getObject().getJSONObject("body").getString("status");
        }
        System.out.println("status in returnString = " + returnString);
        return returnString;
    }
    public static JSONObject getParagraphResultDataByIndex(int index, String notebookName){
        return getParagraphInformationStatus(index, notebookName).getBody().getObject().getJSONObject("body");
    }
}
