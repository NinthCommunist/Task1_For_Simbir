package core.steps;

import core.pojo.UserPojo;
import io.qameta.allure.Step;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserStep extends BaseStep {
    private static final String path = "/api/users";

    @Step(value = "Получение списка всех пользователей на одной странице{0}")
    public List<UserPojo> getListOfUsers(String params) {
        return given()
                .spec(requestSpec)
                .get(path + params)
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", UserPojo.class);
    }

}
