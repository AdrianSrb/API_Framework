package ui;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
    RequestSpecification req;
    public RequestSpecification requestSpecification() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        PrintStream log;
        try {
            log = new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();

        return req;

    }
}
