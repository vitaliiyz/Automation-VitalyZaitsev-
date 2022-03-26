package Lecture_17;

import Lecture_17.PojoListOfUsers.Root;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Lecture_17 {

    String headerContentType;
    String headerObject;
    SimpleDateFormat df;
    String currentDate;

    @BeforeTest
    public void precondition() {
        headerContentType = "Content-Type";
        headerObject = "application/json";
        baseURI = "https://reqres.in/";
        df = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = df.format(new Date());
    }

    @Test(priority = 1)
    public void getTest() {
        Response response = given().when().get("api/users?page=2");

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().getInt("data.id[0]"), 7);
        Assert.assertEquals(response.then().extract().jsonPath().getString("support.url"), "https://reqres.in/#support-heading");

        Assert.assertEquals(response.as(Root.class).total, 12);
        Assert.assertEquals(response.as(Root.class).data.get(1).email, "lindsay.ferguson@reqres.in");
        Assert.assertEquals(response.as(Root.class).support.text, "To keep ReqRes free, contributions towards server costs are appreciated!");
    }

    @Test(priority = 2)
    public void postTest() {
        Response response = given().when().header(headerContentType, headerObject).and().body(getRequest("create.json")).post("api/users");

        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "leader");
    }

    @Test(priority = 3)
    public void putTest() {
        Response response = given().when().header(headerContentType, headerObject).and().body(getRequest("update.json")).put("api/users/2");

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "zion resident");
    }

    @Test(priority = 4)
    public void deleteTest() {
        Response response = given().when().delete("api/users/2");

        response.then().assertThat().statusCode(204);
    }

    @Test(priority = 5)
    public void patchTest() {
        Response response = given().when().header(headerContentType, headerObject).and().body(getRequest("update.json")).patch("api/users/2");

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().jsonPath().get("name"), "morpheus");
        Assert.assertEquals(response.then().extract().jsonPath().get("job"), "zion resident");
        Assert.assertTrue(response.then().extract().jsonPath().getString("updatedAt").contains(currentDate));
    }

    @Test(priority = 6)
    public void headTest() {
        Response response = given().when().head("api/users/2");

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().contentType(), "application/json; charset=utf-8");
    }

    private String getRequest(String requestName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src" + File.separator + "test" + File.separator +
                    "java" + File.separator + "Lecture_17" + File.separator + "Requests" + File.separator + requestName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
