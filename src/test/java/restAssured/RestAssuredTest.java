package restAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    private final static String URL = "http://localhost:8080";

    @Test
    public void getTest() {
        given().get(URL + "/menu").then().statusCode(200).log().all();
    }

    @Test
    public void getItem13Test() {
        Response response = given()
                .when()
                .get(URL + "/menu/13")
                .then().log().all()
                .extract().response();
        Assert.assertTrue(response.body().asString().contains("Cheesecake"));
        Assert.assertTrue(response.body().asString().contains("20.0"));
    }

    @Test
    public void postTest() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("name", "Pizza");
        request.put("price", "28");
        Response response = given().accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/menu")
                .then().log().all()
                .statusCode(200)
                .extract().response();
        String responseAsString = response.getBody().asString();
        Assert.assertTrue(responseAsString.contains("Pizza"));
        Assert.assertTrue(responseAsString.contains("28.0"));
    }

    @Test
    public void putTest() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("name", "Matcha");
        request.put("price", "7.00");
        given()
                .body(request.toString())
                .when()
                .put(URL + "/menu/35")
                .then().log().all()
                .statusCode(405);
    }

    @Test
    public void deleteMenuItemTest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .delete(URL + "/menu/38")
                .then().log().all()
                .statusCode(200);
    }
}
