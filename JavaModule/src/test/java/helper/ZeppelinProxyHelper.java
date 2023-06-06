package helper;

import kong.unirest.*;
import kong.unirest.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesLoader;
import java.time.Duration;
import java.util.Objects;

import static cucumberSetup.CucumberHooks.driver;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static utils.API.zeppelinAPI.ZeppelinAPIToolsFunctions.SearchNotebookIDInList;
import static utils.API.zeppelinAPI.ZeppelinAPIToolsFunctions.SearchParagraphID;
import static utils.Constants.*;
import static utils.ScenarioContext.getCookie;
import static utils.Time.CalendarDates.getYesterdayDate;
import static utils.Time.CalendarDates.getYesterdayDateFormatWithDash;

public class ZeppelinProxyHelper {
    public ZeppelinProxyHelper() {
    }
    public static String LoginForm="loginfmt";
    public static String LoginFormNextButton="idSIButton9";
    public static String LoginFormPassword="input36";
    public static String LoginFormSubmit="//input[@type=\"submit\"]";
    public static String LoginFormAccept="idSIButton9";
    public static String ZeppelinHomePage="welcome";
    public static String ZEPPELINURL="https://zeppelin.datalake.dev4apps.io/";

    public static String frontEndLoginToZeppelin() {
        assertNotEquals("Driver should not be null value",null , driver);
        driver.get(ZEPPELINURL);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        assert LoginForm != null;
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(LoginForm))));
        driver.findElement(By.name(LoginForm)).sendKeys(PropertiesLoader.getLogin());
        driver.findElement(By.id(LoginFormNextButton)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(LoginFormPassword))));
        driver.findElement(By.id(LoginFormPassword)).sendKeys(PropertiesLoader.getPassword());
        driver.findElement(By.xpath(LoginFormSubmit)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(LoginFormAccept))));
        driver.findElement(By.id(LoginFormAccept)).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(ZeppelinHomePage))));
        return driver.manage().getCookieNamed("JSESSIONID").getValue();
    }
    public static String getDateFromOutputResultFromParagraph(String notebookName, int index) {
        String date;
        HttpResponse<JsonNode> getDateFromOutputResultResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        getDateFromOutputResultResponse = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        // TODO : Change date with today's value (results in output)
        date = getDateFromOutputResultResponse.getStatusText();
        return date;
    }
    public static HttpResponse<JsonNode> updateBrandNameInParagraph(String BrandName, int index, String notebookName) {
        HttpResponse<JsonNode> setBrandNameInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val brandName ="+ "\"" + BrandName + "\"" );
        setBrandNameInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setBrandNameInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateCustTypeInParagraph(int index, String notebookName, String CUSTOMER_TYPE) {
        HttpResponse<JsonNode> setCustTypeInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val CustomerType ="+ "\"" + CUSTOMER_TYPE + "\"" );
        setCustTypeInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setCustTypeInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateZoneDescInParagraph(int index, String notebookName, String arg1){
        System.out.println("Index + notebookName + Arg1" + index + " " + notebookName + " " + arg1 );
        HttpResponse<JsonNode> setZoneDescInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val zone_desc ="+ "\"" + arg1 + "\"" );
        setZoneDescInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setZoneDescInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateColumnNameInParagraph(int index, String notebookName, String arg1){
        System.out.println(index + notebookName + arg1 );
        HttpResponse<JsonNode> setColumnNameInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val column_name ="+ "\"" + arg1 + "\"" );
        setColumnNameInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setColumnNameInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateStoreCodeInParagraph(int index, String notebookName, String arg1){
        System.out.println(index + notebookName + arg1 );
        HttpResponse<JsonNode> setStoreCodeInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val store_code ="+ "\"" + arg1 + "\"" );
        setStoreCodeInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setStoreCodeInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateProfessionValueInParagraph(int index, String notebookName, String arg1){
        System.out.println(index + notebookName + arg1 );
        HttpResponse<JsonNode> setProfessionValueInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val profession_value ="+ "\"" + arg1 + "\"" );
        setProfessionValueInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setProfessionValueInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateStoreSubTypeDescInParagraph(int index, String notebookName, String arg1){
        System.out.println(index + notebookName + arg1 );
        HttpResponse<JsonNode> setStoreSubTypeDescInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val store_subtype_desc ="+ "\"" + arg1 + "\"" );
        setStoreSubTypeDescInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setStoreSubTypeDescInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateDateToYesterdayInParagraph(int index, String notebookName){
        String arg1 = getYesterdayDate();
        System.out.println("Date within updateDateToYesterdayInParagraph = " + arg1);
        System.out.println(index + notebookName + arg1);
        HttpResponse<JsonNode> setYesterdayDateInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val date ="+ "\"" + arg1 + "\"" );
        setYesterdayDateInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setYesterdayDateInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateDateToYesterdayDashedInParagraph(int index, String notebookName){
        String arg1 = getYesterdayDateFormatWithDash();
        System.out.println("Date within updateDateToYesterdayInParagraph = " + arg1);
        System.out.println(index + notebookName + arg1);
        HttpResponse<JsonNode> setYesterdayDateInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val dashedDate ="+ "\"" + arg1 + "\"" );
        setYesterdayDateInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setYesterdayDateInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateAttributeInParagraph(int index, String notebookName, String arg1){
        System.out.println("Attribute to update = " + arg1);
        HttpResponse<JsonNode> setPreferredStoreInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val attributeName ="+ "\"" + arg1 + "\"" );
        setPreferredStoreInParaGraphResponse = Unirest.put(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .body(requestBody)
                .asJson();
        return setPreferredStoreInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateBucketNameInParagraph(int index, String notebookName, String arg1){
        System.out.println("BucketName set to = " + arg1);
        HttpResponse<JsonNode> setPreferredStoreInParaGraphResponse = null;
        if(Objects.equals(arg1, "prod")){
            String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
            JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val prod_bucketName ="+ "\"" + "kering-datalake-" + arg1 + "-data" + "\"" );
            setPreferredStoreInParaGraphResponse = Unirest.put(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .body(requestBody)
                    .asJson();
            return setPreferredStoreInParaGraphResponse;
        } else if (Objects.equals(arg1, "qa")) {
            String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
            JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val qa_bucketName ="+ "\"" + "kering-datalake-" + arg1 + "-data" + "\"" );
            setPreferredStoreInParaGraphResponse = Unirest.put(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .body(requestBody)
                    .asJson();
            return setPreferredStoreInParaGraphResponse;
        } else if(Objects.equals(arg1, "dev")){
            String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
            JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val dev_bucketName ="+ "\"" + "kering-datalake-" + arg1 + "-data" + "\"" );
            setPreferredStoreInParaGraphResponse = Unirest.put(url)
                    .cookie(ZEPPELIN_COOKIE, getCookie())
                    .body(requestBody)
                    .asJson();

        } else{
            assertNotNull("Value should not be null for bucket environment",arg1);
        }

        return setPreferredStoreInParaGraphResponse;
    }
    private static HttpResponse<JsonNode> getJsonInParagraph(String notebookName, int index) {
        HttpResponse<JsonNode> getParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        getParaGraphResponse = Unirest.get(url)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        return getParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateAgeRangeLowerBoundInParagraph(String ageRangeLowerBound, int index, String notebookName) {
        HttpResponse<JsonNode> setAgeRangeLowerBoundInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val age_range_lower_bound ="+ ageRangeLowerBound);
        setAgeRangeLowerBoundInParaGraphResponse = Unirest.put(url)
                .body(requestBody)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        return setAgeRangeLowerBoundInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateAgeRangeUpperBoundInParagraph(String ageRangeUpperBound,int index, String notebookName) {
        HttpResponse<JsonNode> setAgeRangeUpperBoundInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val age_range_upper_bound =" + ageRangeUpperBound );
        setAgeRangeUpperBoundInParaGraphResponse = Unirest.put(url)
                .body(requestBody)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        return setAgeRangeUpperBoundInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateAgeRangeNameInParagraph(String AgeRangeName, int index, String notebookName) {
        HttpResponse<JsonNode> setAgeRangeNameInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val age_range_name ="+ "\"" + AgeRangeName + "\"" );
        setAgeRangeNameInParaGraphResponse = Unirest.put(url)
                .body(requestBody)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        return setAgeRangeNameInParaGraphResponse;
    }
    public static HttpResponse<JsonNode> updateYearUpperBound(String YearUpperBound, int index, String notebookName) {
        HttpResponse<JsonNode> setAgeRangeNameInParaGraphResponse;
        String url = ZEPPELIN_API_URL + ZEPPELIN_NOTEBOOK + "/" + SearchNotebookIDInList(notebookName) + ZEPPELIN_PARAGRAPH + "/" + SearchParagraphID(index, notebookName);
        JSONObject requestBody = getJsonInParagraph(notebookName, index).getBody().getObject().getJSONObject("body").put("text", "val age_range_upper_bound =" + YearUpperBound );
        setAgeRangeNameInParaGraphResponse = Unirest.put(url)
                .body(requestBody)
                .cookie(ZEPPELIN_COOKIE, getCookie())
                .asJson();
        return setAgeRangeNameInParaGraphResponse;
    }
}


