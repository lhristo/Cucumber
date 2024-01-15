package org.example.API;
import static io.restassured.RestAssured.given;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstApiTest {
    String loginToken;
    String baseUrl = "http://training.skillo-bg.com:3100";
    int userId;


    RequestSpecification spec;


    @BeforeClass
    public void login() {
        LoginPojo login = new LoginPojo();
        login.setUsernameOrEmail("lyudmil1207");
        login.setPassword("123123");

        ValidatableResponse response =
                given()
                        .baseUri(baseUrl)
                        .header("Content-Type", "application/json")
                        .basePath("/users/login")
                        .body(login)
                        .when()
                        .post()
                        .then()
                        .statusCode(201);
        loginToken = response.extract().jsonPath().get("token");
        userId = response.extract().jsonPath().get("user.id");
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization", "Bearer " + loginToken)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    public void getPublicPostsById() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .pathParam("userId", userId)
                        .queryParam("postStatus", "public")
                        .queryParam("take", 10)
                        .queryParam("skip", 0)
                        .when()
                        .get("/users/{userId}/posts")
                        .then()
                        .statusCode(200);
        String responseBody = response.extract().asString();
        JsonArray responseArray = JsonParser.parseString(responseBody).getAsJsonArray();

        Assert.assertTrue(responseArray.size() == 10, "It should contain exactly 10 posts");
        System.out.println(responseBody);
    }

    @Test
    public void patchLikePost() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .basePath("posts/7887")
                        .body("{\n" +
                                "  \"action\": \"likePost\"\n" +
                                "}")
                .when()
                        .patch()

                .then()
                        .statusCode(200);
        String responseBody = response.extract().asString();
        System.out.println(responseBody);

    }

    @Test
    public void deletePost() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .basePath("posts/7888")
                .when()
                        .delete()

                .then()
                        .statusCode(200);
        String responseBody = response.extract().asString();
        System.out.println(responseBody);

    }

    @Test
    public void postComment() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .basePath("posts/7866/comment")
                        .body("{\n" +
                                "  \"content\": \"myComment\"\n" +
                                "}")
                .when()
                        .post()
                .then()
                        .statusCode(201);
        String responseBody = response.extract().asString();
        System.out.println(responseBody);

    }

    @Test
    public void getComments() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .basePath("posts/7866/comments")

                .when()
                        .get()
                .then()
                        .statusCode(200);
        String responseBody = response.extract().asString();
        System.out.println(responseBody);

    }

    @Test
    public void postPublicPost() {
        ValidatableResponse response =
                given()
                        .spec(spec)
                        .basePath("posts")
                        .body("{\n" +
                                "  \"caption\": \"Nice pic!\",\n" +
                                "  \"coverUrl\": \"https://imgur.com/gallery/U3yRiZV\",\n" +
                                "  \"postStatus\": \"public\"\n" +
                                "}")
                .when()
                        .post()
                .then()
                        .statusCode(201);
        String responseBody = response.extract().asString();
        System.out.println(responseBody);
    }
}
