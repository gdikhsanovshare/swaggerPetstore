package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.TestUtils;

public class Asserts {
    @Step("Проверка статус-кода")
    public static void assertStatusCode (Response response, int statusCode){
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Step("Проверка значений ключей пользователя")
    public static void assertUserJsonValues (Response response, String jsonPathKey, String value){
        Assert.assertEquals(response.jsonPath().get(jsonPathKey).toString(), value);
    }
}
