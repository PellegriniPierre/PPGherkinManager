package utils.APIRestClasses;

import io.restassured.RestAssured;
import org.openqa.selenium.json.Json;
public class getURL {
    public Json appelUrl(){
        return (Json) RestAssured.get("http://20.13.162.105:8000/?p=3");
    }
}
