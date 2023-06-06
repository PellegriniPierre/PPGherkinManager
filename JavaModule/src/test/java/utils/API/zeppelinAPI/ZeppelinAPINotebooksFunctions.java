package utils.API.zeppelinAPI;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;
import static utils.API.zeppelinAPI.ZeppelinAPIToolsFunctions.SearchNotebookIDInList;
import static utils.API.zeppelinAPI.ZeppelinAPIToolsFunctions.SearchParagraphID;
import static utils.Constants.*;
import static utils.Json.JsonUtilities.jsonReplaceJsonDataWithInputData;
import static utils.ScenarioContext.getCookie;

public class ZeppelinAPINotebooksFunctions {

    public ZeppelinAPINotebooksFunctions() {
    }
    public static HttpResponse<JsonNode> getParagraphRunStatusResult(int index, String notebookName){
        assertNotEquals("resultString is null in getParagraphRunStatusResult", null, getParagraphStatus(index, notebookName));
        return getParagraphStatus(index, notebookName);
    }
    public static HttpResponse<JsonNode> getParagraphInformationStatus(int index, String notebookName){
        assertNotEquals("resultString is null in getParagraphInformation", null, getParagraphInformation(index, notebookName));
        return getParagraphInformation(index,notebookName);
    }
    public static String getAllParagraphConfigurationUpdateStatus(String notebookName) throws IOException {
        int indexLength = getAllParagraphs(notebookName).getBody().getObject().getJSONArray("body").length();
        int index;
        for(index = 0; index < indexLength; index++){
            updateParagraphConfiguration(index, notebookName);
        }
        return "Paragraphs are updated for " + notebookName;
    }
    public static String getAllParagraphConfigurationStatus(String notebookName) throws IOException {
        int indexLength = getAllParagraphs(notebookName).getBody().getObject().getJSONArray("body").length();
        int index;
        String notebookTemplate = "notebookConfig.json";
        String path = "src/test/resources/JsonListToCompare/" + notebookTemplate;
        String requestBody = jsonReplaceJsonDataWithInputData(path);
        int CountOk = 0;
        int CountKO = 0;

        int IndexKO = 0;
        for(index = 0; index < indexLength; index++){
            if(getParagraphInformationStatus(index, notebookName).getBody().getObject().getJSONObject("body").getJSONObject("config").similar(requestBody.strip())){
                CountOk++;
            }else {
                CountKO++;
                IndexKO = index;
            }
        }
        if(CountOk == indexLength){
            System.out.println("Config in paragraph are set correctly for " + notebookName);
        } else {
            System.out.println("There are " + CountKO + " KO in paragraph configuration");
            System.out.println("Error in paragraph configuration at index " + IndexKO + ": " + getParagraphInformationStatus(IndexKO, notebookName).getBody().getObject().getJSONObject("body").getJSONObject("config") + " expected: " + requestBody.strip());
        }
        return "OK";
    }

    public static HttpResponse<JsonNode> getNotebookList() {
        HttpResponse<JsonNode> NotebookListRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK;
        NotebookListRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> NotebookListResponse = NotebookListRequest;
        assertNotEquals("Response returned error on getNotebookList, please be sure you are authenticated on Zeppelin API", null, NotebookListResponse);
        return NotebookListResponse;
    }
    public static HttpResponse<JsonNode> createNewNote(String notebookName) throws IOException {
        System.out.println("Cookie in createNewNote =" + getCookie());
        String notebookTemplate = notebookName + ".json";
        String path = "src/test/resources/Templates/TestTemplates/" + notebookTemplate;
        String requestBody = jsonReplaceJsonDataWithInputData(path);
        HttpResponse<JsonNode> CreateNoteRequest;
        HttpResponse<JsonNode> CreateNoteResponse = null;
        try {
            if (requestBody == null) {
                throw new UnirestException("requestBody's variable in createNewNote can't be null");
            }
            String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK;
            CreateNoteRequest = Unirest.post(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .body(requestBody)
                    .asJson();
            CreateNoteResponse = CreateNoteRequest;
            if (CreateNoteResponse == null) {
                throw new UnirestException("responseCreate's variable in createZeppelinNotebook can't be null");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return CreateNoteResponse;
    }
    private static HttpResponse<JsonNode> getAllParagraphs(String notebookName) {
        String NotebookID = SearchNotebookIDInList(notebookName);
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + ZEPPELIN_NOTEBOOK_JOB + NotebookID;
        HttpResponse<JsonNode> notebookParagraphsJobStatusRequest;
        HttpResponse<JsonNode> notebookParagraphsJobStatusResponse = null;
        try {
            notebookParagraphsJobStatusRequest = Unirest.get(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .asJson();
            notebookParagraphsJobStatusResponse = notebookParagraphsJobStatusRequest;
        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        return notebookParagraphsJobStatusResponse;
    }
    public static HttpResponse<JsonNode> getExistingNoteInformation(String notebookName) {
        HttpResponse<JsonNode> getExistentRequest;
        HttpResponse<JsonNode> getExistentResponse = null;
        if (SearchNotebookIDInList(notebookName) == null) {
            System.out.println("ID doesn't exist after search Notebook in Zeppelin API");
        } else {
            String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName);
            getExistentRequest = Unirest.get(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .asJson();
            getExistentResponse = getExistentRequest;
        }
        return getExistentResponse;
    }
    public static HttpResponse<JsonNode> runAllParagraphs(String notebookName){
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + ZEPPELIN_NOTEBOOK_JOB + "/" + SearchNotebookIDInList(notebookName);
        HttpResponse<JsonNode> runAllParagraphsRequest;
        runAllParagraphsRequest = Unirest.post(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> runAllParagraphsResponse = runAllParagraphsRequest;
        if (runAllParagraphsResponse == null) {
            throw new UnirestException("runAllParagraphsResponse's variable in runAllParagraphs can't be null");
        }
        return runAllParagraphsResponse;
    }
    private static HttpResponse<JsonNode> getParagraphInformation(int index, String notebookName){
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        HttpResponse<JsonNode> getParagraphInformationRequest;
        getParagraphInformationRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> getParagraphInformationResponse = getParagraphInformationRequest;
        if (getParagraphInformationResponse == null) {
            throw new UnirestException("getParagraphInformationResponse's variable in getParagraphInformation can't be null");
        }
        return getParagraphInformationResponse;
    }

    private static HttpResponse<JsonNode> getParagraphStatus(int index, String notebookName){
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + ZEPPELIN_NOTEBOOK_JOB + SearchNotebookIDInList(notebookName) + "/" + SearchParagraphID(index, notebookName);
        HttpResponse<JsonNode> getParagraphStatusRequest;
        getParagraphStatusRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> getParagraphStatusResponse = getParagraphStatusRequest;
        if (getParagraphStatusResponse == null) {
            throw new UnirestException("getParagraphStatusResponse's variable in getParagraphStatus can't be null");
        }
        return getParagraphStatusResponse;
    }
    private static HttpResponse<JsonNode> updateParagraphConfiguration(int index, String notebookName) throws IOException {
        HttpResponse<JsonNode> updateParagraphConfigurationRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" +  SearchParagraphID(index, notebookName) + ZEPPELIN_CONFIG;
        String notebookTemplate = "notebookConfig.json";
        String path = "src/test/resources/JsonListToCompare/" + notebookTemplate;
        String requestBody = jsonReplaceJsonDataWithInputData(path);
        updateParagraphConfigurationRequest = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        HttpResponse<JsonNode> updateParagraphConfigurationResponse = updateParagraphConfigurationRequest;
        if (updateParagraphConfigurationResponse == null) {
            throw new UnirestException("getParagraphStatusResponse's variable in getParagraphStatus can't be null");
        }
        return updateParagraphConfigurationResponse;
    }
    public static HttpResponse<String> getNotePermissionInformation(String notebookName) throws UnirestException {
        HttpResponse<String> getNotePermissionInformationRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + "/permissions";
        getNotePermissionInformationRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asString();
        HttpResponse<String> getNotePermissionInformationResponse = getNotePermissionInformationRequest;
        if (getNotePermissionInformationResponse == null) {
            throw new UnirestException("getNotePermissionInformationResponse's variable in getNotePermissionInformation can't be null");
        }
        return getNotePermissionInformationResponse;
    }
    public static HttpResponse<JsonNode> setNotePermission(String notebookName) throws IOException {
        HttpResponse<JsonNode> NotePermissionRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PERMISSIONS;
        String notebookTemplate = "permissionList.json";
        String path = "src/test/resources/JsonListToCompare/" + notebookTemplate;
        String requestBody = jsonReplaceJsonDataWithInputData(path);
        NotePermissionRequest = Unirest.put(url)
                .body(requestBody)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> NotePermissionResponse = NotePermissionRequest;
        if (NotePermissionResponse == null) {
            throw new UnirestException("getNotePermissionInformationResponse's variable in getNotePermissionInformation can't be null");
        }
        return NotePermissionResponse;
    }
    public static HttpResponse<JsonNode> runParagraphSynchronously(int index, String notebookName){
        HttpResponse<JsonNode> RunParagraphRequest;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + ZEPPELIN_NOTEBOOK_JOB + SearchNotebookIDInList(notebookName) + "/" + SearchParagraphID(index, notebookName);
        System.out.println("Url within runParagraphSynchronously = " + url);
        RunParagraphRequest = Unirest.post(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> RunParagraphResponse = RunParagraphRequest;
        if (RunParagraphResponse == null) {
            throw new UnirestException("RunParagraphResponse's variable in runParagraphSynchronously can't be null");
        }
        return RunParagraphResponse;
    }
    public static HttpResponse<JsonNode> exportNotebook(String notebookName){
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + ZEPPELIN_NOTEBOOK_EXPORT + SearchNotebookIDInList(notebookName);
        HttpResponse<JsonNode> exportNotebookRequest;
        exportNotebookRequest = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        HttpResponse<JsonNode> exportNotebookResponse = exportNotebookRequest;
        if (exportNotebookResponse == null) {
            throw new UnirestException("clearAllParagraphResultResponse's variable in clearAllParagraphResult can't be null");
        }
        return exportNotebookResponse;
    }

}
