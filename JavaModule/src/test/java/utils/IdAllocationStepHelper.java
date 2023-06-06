package utils;

import com.google.common.collect.ImmutableMap;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.util.Map;

public class IdAllocationStepHelper {

    public static final Map<String, String> STANDARD_HEADERS = ImmutableMap.of(
            "Authorization", "Bearer ",
            "Content-type", "application/json");

    public static HttpResponse idAllocationServiceInfos() throws UnirestException {
        return Unirest.get(ConfigurationUtil.getChinaServiceIdAllocationHealthInfos ())
                .headers(STANDARD_HEADERS)
                .asJson();
    }
}

