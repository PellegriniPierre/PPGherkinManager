package utils.Json;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonUtilities {
    public static String jsonReplaceJsonDataWithInputData(String path) throws IOException {
        return jsonFileToString(path);
    }
    private static String jsonFileToString(String filePath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}