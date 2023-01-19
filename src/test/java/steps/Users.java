package steps;

import io.qameta.allure.Step;
import runner.Endpoints;
import utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Users {

    @Step("Создание пользователя")
    public static Response createUser(String fileName) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(TestUtils.getJsonFileAsPrettyString(fileName))
                .when()
                .post(Endpoints.USER)
                .then().log().all()
                .extract().response();
    }

    @Step("Изменение пользователя")
    public static Response updateUser(String userName, String fileName) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(TestUtils.getJsonFileAsPrettyString(fileName))
                .when()
                .put(Endpoints.USER + userName)
                .then().log().all()
                .extract().response();
    }

    @Step("Изменение пользователя")
    public static Response getUser(String userName) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(Endpoints.USER + userName)
                .then().log().all()
                .extract().response();
    }

    @Step("Удаление пользователя")
    public static Response deleteUser(String userName) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(Endpoints.USER + userName)
                .then().log().all()
                .extract().response();
    }
}
