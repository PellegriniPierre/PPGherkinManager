package utils.API.livyAPI;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;

import java.io.IOException;

import static utils.Constants.LIVY_URL;

public class LivyAPIBatchFunctions {
    public LivyAPIBatchFunctions() {
    }

    /**
     * Search launched Batch by ID, containing PROJECT within his name on Livy API
     * @param date Date to set by default to search on a specific date of calculation
     * @return batchId return to get the list of available batches on the scope of search
     */
    public static String getBatchLaunchedForDate(String date) {
        JsonNode BatchesList = requestGetLivyAPIBatches().getBody();
        assert BatchesList != null;
        JSONArray LivyBatchSessions = BatchesList.getObject().getJSONArray("sessions");
        assert LivyBatchSessions != null;
        int index;
        int jsonArray = LivyBatchSessions.length();
        String batchId = null;
        for (index = 0; index < jsonArray; index++) {
            String lastLaunchedBatchOnCase = String.valueOf(LivyBatchSessions.getJSONObject(index).get("name"));
            assert lastLaunchedBatchOnCase != null;
            if (lastLaunchedBatchOnCase.contains("PROJECT" + date)) {
                System.out.println("Full line found for PROJECT" + date + " name= " + LivyBatchSessions.getJSONObject(index) + "\n");
                batchId = LivyBatchSessions.getJSONObject(index).get("id").toString();
            }
        }
        System.out.println("batchId within getBatchLaunchedLastWeek " + batchId);
        return batchId;
    }

    /**
     * To check state for previously launched BatchId
     * @param batchID batchId Integer to check simple result of the launch
     */
    public static void getLivyAPIBatchState(int batchID){
        HttpResponse<JsonNode> batchState = requestGetLivyAPIBatchState(batchID);
        System.out.println("Batch state for batch " + batchID + "= " + "\n" + "Batch state body: " + batchState.getBody() + "\n" + "Batch state status text: " + batchState.getStatusText() + "\n" + "Batch state status: " +  batchState.getStatus() + "\n" +  "Batch state parsing errors: " + batchState.getParsingError() + "\n" + "Batch state response headers: " + batchState.getHeaders() + "\n");
    }

    /**
     *
     */
    public static void getLivyAPIBatchesList(){
        HttpResponse<JsonNode> batchesList = requestGetLivyAPIBatches();
        System.out.println("Batches list result = " + "\n" + batchesList.getBody() + "\n" + batchesList.getStatusText() + "\n" + batchesList.getStatus() + "\n" + batchesList.getHeaders() + "\n" + batchesList.getParsingError() + "\n");
    }
    public static void getLivyAPIBatch(int batchId){
        requestGetLivyAPIBatch(batchId).getBody();
    }

    /**
     *  * @author <b>Pierre Pellegrini</b>
     *  * @version <b>0.0.1</b>
     * To stop process of running batch with batchId
     * @param batchID corresponding to Integer to delete
     */
    public static void deleteAPIBatchJob(int batchID){
        HttpResponse<JsonNode> deleteBatch = requestDeleteLivyAPIBatch(batchID);
        System.out.println("Delete batch result for batch " + batchID + " = " + "\n" + "Batch delete body: " + deleteBatch.getBody() + "\n" + "Batch delete status text: " + deleteBatch.getStatusText() + "\n" + "Batch delete status: " +  deleteBatch.getStatus() + "\n" +  "Batch delete parsing errors: " + deleteBatch.getParsingError() + "\n" + "Batch delete response headers: " + deleteBatch.getHeaders() + "\n");
    }

    /**
     * To retrieve logs for previously launched BatchId
     * @param batchID corresponding to Integer to search logs
     */
    public static void getLivyAPIBatchLog(int batchID){
        HttpResponse<JsonNode> batchLog = requestGetLivyAPIBatchLog(batchID);
        System.out.println("Batch logs result for batch " + batchID + " = " + "\n" + "Batch logs body: " + batchLog.getBody() + "\n" + "Batch logs status text: " + batchLog.getStatusText() + "\n" + "Batch logs status: " +  batchLog.getStatus() + "\n" +  "Batch logs parsing errors: " + batchLog.getParsingError() + "\n" + "Batch logs response headers: " + batchLog.getHeaders() + "\n");
    }
    public static void launchBatch(String attributeGroupName, String jsonTemplate, String LaunchDate, String brandName, String sysdate, String convertionYear) throws IOException {
        System.out.println("LaunchDate within launchBatch = " + LaunchDate);
        HttpResponse<JsonNode> batchResult = requestPostLivyAPIBatches(attributeGroupName, jsonTemplate, LaunchDate, brandName, sysdate, convertionYear);
        System.out.println("Batch launch result for "+ LaunchDate + " = \n" + batchResult.getBody() + "\n" + batchResult.getStatusText() + "\n" + batchResult.getStatus() + "\n" + batchResult.getHeaders() + "\n" + batchResult.getParsingError() + "\n");
    }

    private static HttpResponse<JsonNode> requestGetLivyAPIBatches(){
        int fromListBatch = 0;
        int sizeListBatch = 9999999;
        System.out.println("Be carefull because SizeListBatch is set by default to 9999999 in requestGetLivyAPIBatches function!");
        String url = LIVY_URL+ "/batches?from="+ fromListBatch + "&size=" + sizeListBatch;
        HttpResponse<JsonNode> getBatches = null;
        try {
            getBatches = Unirest.get(url)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert getBatches != null;

        return getBatches;
    }
    private static HttpResponse<JsonNode> requestPostLivyAPIBatches(String attributeGroupName, String jsonTemplate, String launchDate, String brandName, String sysdate, String convertionYear) throws IOException {
        System.out.println("launchDate within requestPostLivyAPIBatches= " + launchDate);
        long timestamp = System.currentTimeMillis();
        String stringTimeStamp = String.valueOf(timestamp);
        String url = LIVY_URL+ "/batches";
        HttpResponse<JsonNode> launchBatchWithParameters = null;
        String path = "src/test/resources/Templates/Batches/" + jsonTemplate;
        String changedJson = (path).replace("{launchDate}", launchDate)
                .replace("{brand_lowerCase}", brandName)
                .replace("{timestamp}", stringTimeStamp)
                .replace("{sysdate}", sysdate)
                .replace("{attributeGroupName}", attributeGroupName)
                .replace("{ConvertionYear}", convertionYear);
        System.out.println("ChangedJson : " + changedJson);
        try {
            launchBatchWithParameters = Unirest.post(url)
                    .body(changedJson)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }

        return launchBatchWithParameters;
    }
    private static HttpResponse<JsonNode> requestGetLivyAPIBatch(int batchID) {
        String url = LIVY_URL+ "/batches/" + batchID;
        HttpResponse<JsonNode> getBatchInfo = null;

        try {
            getBatchInfo = Unirest.get(url)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert getBatchInfo != null;

        return getBatchInfo;
    }
    private static HttpResponse<JsonNode> requestGetLivyAPIBatchState(int batchID){ //*** Returns the state of batch session
        String url = LIVY_URL+ "/batches/" + batchID + "/state";
        HttpResponse<JsonNode> getBatchState = null;

        try {
            getBatchState = Unirest.get(url)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert getBatchState != null;

        return getBatchState;
    }
    private static HttpResponse<JsonNode> requestDeleteLivyAPIBatch(int batchID){ // To kill the batch job
        String url = LIVY_URL+ "/batches/" + batchID;
        HttpResponse<JsonNode> deleteBatchJob = null;

        try {
            deleteBatchJob = Unirest.delete(url)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert deleteBatchJob != null;

        return deleteBatchJob;
    }
    private static HttpResponse<JsonNode> requestGetLivyAPIBatchLog(int batchID){
        String url = LIVY_URL+ "/batches/" + batchID + "/log";
        HttpResponse<JsonNode> getBatchLog = null;

        try {
            getBatchLog = Unirest.get(url)
                    .asJson();

        } catch (UnirestException notebooksEx) {
            notebooksEx.printStackTrace();
        }
        assert getBatchLog != null;

        return getBatchLog;
    }
}
