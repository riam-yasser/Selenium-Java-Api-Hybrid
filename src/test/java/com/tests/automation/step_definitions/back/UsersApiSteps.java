package com.tests.automation.step_definitions.back;

import com.github.javafaker.Faker;
import com.tests.automation.api.ApiRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.http.Headers;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UsersApiSteps {

    private Response response;
    private final Faker faker = new Faker();

    @Given("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint)
    {
       response = ApiRequest.get(endpoint, null);
    }

    @Then("The response status should be {int}")
    public void theResponseStatusShouldBe(int status) {
        assertEquals(status, response.statusCode());
    }

    @Given("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String endpoint) {

        Map<String, Object> user = new LinkedHashMap<>();
        user.put("id", faker.number().randomNumber());
        user.put("name", faker.name().fullName());
        user.put("username", faker.name().username());
        user.put("email", faker.internet().emailAddress());

        Map<String, Object> address = new LinkedHashMap<>();
        address.put("street", faker.address().streetName());
        address.put("suite", faker.address().secondaryAddress());
        address.put("city", faker.address().city());
        address.put("zipcode", faker.address().zipCode());

        Map<String, Object> geo = new LinkedHashMap<>();
        geo.put("lat", String.valueOf(faker.number().randomDouble(4, -90, 90)));
        geo.put("lng", String.valueOf(faker.number().randomDouble(4, -180, 180)));

        address.put("geo", geo);
        user.put("address", address);
        user.put("phone", faker.phoneNumber().phoneNumber());
        user.put("website", faker.internet().domainName());

        Map<String, Object> company = new LinkedHashMap<>();
        company.put("name", faker.company().name());
        company.put("catchPhrase", faker.company().catchPhrase());
        company.put("bs", faker.company().bs());

        user.put("company", company);
        response = ApiRequest.postJson(endpoint, new Headers(), user);
    }
}


