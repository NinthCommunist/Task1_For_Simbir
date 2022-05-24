package core.steps;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static core.Constants.BASE_URL;

public class BaseStep {

    protected static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .addFilter(new AllureRestAssured())
            .setContentType(ContentType.JSON)
            .build();


}
