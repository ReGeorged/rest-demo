package helpers;

import constants.EndPoints;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullHelper {

    private static Response postWithHeadersAndBody(Map headersHashMap, String body, String endPoint, int expectedCode) {
        Response res = given()
                .headers(headersHashMap)
                .body(body)
                .when()
                .post(endPoint).
                then()
                .assertThat().statusCode(expectedCode).extract().response();
        return res;
    }

    public static Response postToUser(String userJsonBody, int responseCode) {
        return postWithHeadersAndBody(BookHashMaps.headersForBooks(), userJsonBody, EndPoints.API_ENDPOINT, responseCode);
    }
}
