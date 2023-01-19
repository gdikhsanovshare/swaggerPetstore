package runner;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setBaseUrl (){
        RestAssured.baseURI = Endpoints.BASE_URL;
        RestAssured.filters(new AllureRestAssured());
    }

}
