import runner.BaseTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static steps.Asserts.*;
import static steps.Users.*;


public class UsersTest extends BaseTest {

    private static final String USER_NAME = "Greg2";

    @Test(priority = 0, description = "Создание пользователя")
    public void createUserTest() {

        Response response = createUser("createUserRequest.json");

        assertStatusCode(response, 200);
        assertUserJsonValues(response, "message", "1234567");
    }

    @Test(dependsOnMethods = "createUserTest", description = "Изменение пользователя")
    public void updateUserTest() {

        Response response = updateUser(USER_NAME, "updateUserRequest.json");

        assertStatusCode(response, 200);
        assertUserJsonValues(response, "message", "1234567");
    }

    @Test(dependsOnMethods = "updateUserTest", description = "Получение пользователя")
    public void getUserByUserNameTest() {

        Response response = getUser(USER_NAME);

        assertStatusCode(response, 200);
        assertUserJsonValues(response, "id", "1234567");
        assertUserJsonValues(response, "username", "Greg2");
        assertUserJsonValues(response, "email", "verygood@good.com");
        assertUserJsonValues(response, "phone", "88888888");
    }

    @Test(dependsOnMethods = "getUserByUserNameTest", description = "Удаление пользователя")
    public void deleteUserByUserNameTest() {

        Response response = deleteUser(USER_NAME);

        assertStatusCode(response, 200);
        assertUserJsonValues(response, "message", USER_NAME);
    }
}