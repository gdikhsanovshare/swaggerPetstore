package utils;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static JSONObject getJSONObject2(String fileName) {
        try {
            return new JSONObject(Files.readAllBytes(Paths.get("src/test/resources/" + fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getJsonFileAsPrettyString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode getJSONObject1(String fileName) throws IOException {

        return new ObjectMapper().readTree(new File("src/test/resources/requests/" + fileName));
    }
}
