package utils.APIRestClasses;


import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utils.Json.DoNotShare;

import java.util.Base64;

import static com.google.common.io.BaseEncoding.base64;
import static io.restassured.RestAssured.given;

public class getUrl {

    public static Response appelUrlJira(String suiteUrl) {
        RestAssured.baseURI = "https://ajcformationdecembre2023.atlassian.net/rest/api/3";
        System.out.println("Valeur de suite URL = " + suiteUrl);
        String UserName = DoNotShare.getbase64EncodedKey();
//       System.out.println("Valeur de EncodeString= " + encodedString);
        Response response = RestAssured.given()
                .when()
                .get(suiteUrl)
                .then()
                .extract().response();

        return response;
    }

    public static Response appelUrlInexistante() {
        RestAssured.baseURI = "";
        Response response = given()
        .contentType(ContentType.JSON)
        .param("postId", "2")
        .when()
        .get("/comments")
        .then()
        .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
        return response;
    }
}
