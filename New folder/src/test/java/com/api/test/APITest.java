package com.api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {

    // Base URL for API requests
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeClass
    public void setup() {
        // Configure base URI for RestAssured
        RestAssured.baseURI = BASE_URL;
    }

    // Test GET Request
    @Test(priority = 1)
    public int testGetPosts() {
        Response response = RestAssured.given().get("/posts");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.body().asString().contains("userId"));
        return response.getStatusCode(); // Return the status code
    }

    // Test POST Request
    @Test(priority = 2)
    public void testCreatePost() {
        String newPost = "{\n" +
                "\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"userId\": 1\n" +
                "}";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(newPost)
                .post("/posts");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    // Test PUT Request
    @Test(priority = 3)
    public void testUpdatePost() {
        String updatedPost = "{\n" +
                "\"id\": 1,\n" +
                "\"title\": \"foo updated\",\n" +
                "\"body\": \"bar updated\",\n" +
                "\"userId\": 1\n" +
                "}";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(updatedPost)
                .put("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    // Test DELETE Request
    @Test(priority = 4)
    public void testDeletePost() {
        Response response = RestAssured.given().delete("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
