package com.tests.automation.api;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

	public static Response post(String endPoint, Map<String, Object> queryParams, Headers headers, Map<String, Object> formParams, Cookies cookies) {
		return given(getRequestSpec())
				.queryParams(queryParams)
				.headers(headers)
				.formParams(formParams)
				.cookies(cookies)
				.when()
				.post(endPoint)
				.then()
				.spec(getResponseSpec())
				.extract()
				.response();
	}

    public static Response postJson(String endPoint, Headers headers, Object body) {
        return given(getRequestSpec())
                .headers(headers)
                .contentType("application/json")
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response post(String endPoint,
                                Map<String, Object> queryParams,
                                Headers headers,
                                Object body,
                                Cookies cookies) {
        var req = given(getRequestSpec());

        if (queryParams != null) req.queryParams(queryParams);
        if (headers != null) req.headers(headers);
        req.contentType("application/json").body(body);
        if (cookies != null) req.cookies(cookies);

        return req.when()
                .post(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }



    public static Response get(String endPoint, Cookies cookies) {
        var req = given(getRequestSpec());
        if (cookies != null) req.cookies(cookies);

        return req.when()
                .get(endPoint)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

}
