package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestTest {

    @Test(priority = 1)
    public void validateGetPosts() {
        APITest apiTest = new APITest();
        int statusCode = apiTest.testGetPosts(); // Calling the method from APITest and checking the status code
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 2)
    public void validateCreatePost() {
        APITest apiTest = new APITest();
        apiTest.testCreatePost(); // This runs the test and asserts the status code inside the method
    }

    @Test(priority = 3)
    public void validateUpdatePost() {
        APITest apiTest = new APITest();
        apiTest.testUpdatePost(); // This runs the test and asserts the status code inside the method
    }

    @Test(priority = 4)
    public void validateDeletePost() {
        APITest apiTest = new APITest();
        apiTest.testDeletePost(); // This runs the test and asserts the status code inside the method
    }
}
