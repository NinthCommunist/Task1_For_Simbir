package tests;

import core.pojo.UserPojo;
import core.steps.UserStep;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class UserTest {

    UserStep userStep;

    @BeforeTest
    public void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        userStep = new UserStep();
    }

    @Test(dataProvider = "parseData", description = "Проверка соответсвия email имени и фамилии пользователя")
    public void test(UserPojo parseUser, String params) {
        List<UserPojo> usersAfterFilter = userStep.getListOfUsers(params).stream()
                .filter(x -> x.getFirstName().equals(parseUser.getFirstName())
                        && x.getLastName().equals(parseUser.getLastName()))
                .collect(Collectors.toList());
        UserPojo user = usersAfterFilter.get(0);
        Assert.assertEquals(user.getEmail(), parseUser.getEmail());
    }

    @DataProvider
    public Object[][] parseData() {
        return new Object[][]{{
                UserPojo.builder()
                        .firstName("George").lastName("Bluth")
                        .email("george.bluth@reqres.in")
                        .build(), ""},
                {UserPojo.builder()
                        .firstName("Michael").lastName("Lawson")
                        .email("michael.lawson@reqres.in")
                        .build(), "?page=2"}};
    }
}

