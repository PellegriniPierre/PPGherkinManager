package utils;

import helper.ZeppelinProxyHelper;
import io.cucumber.java.Scenario;

public class ScenarioContext {

    static String cookie;
    private Scenario scenario;

    public Scenario getScenario() {
        return scenario;
    }
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public static String getCookie() {
        return cookie;
    }
    public static void setCookie() {
        cookie = (ZeppelinProxyHelper.frontEndLoginToZeppelin());
    }
}
