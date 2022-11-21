package helpers;

import constants.EndPoints;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullHelper {

    private static Response postWithHeadersAndParams(Map headersHashMap, String body, String endPoint, int expectedCode) {
        Response res = given()
                .headers(headersHashMap)
                .body(body)
                .when()
                .post(endPoint).
                then()
                .assertThat().statusCode(expectedCode).extract().response();
        return res;
    }

    public static Response postToUser(String body) {
        return postWithHeadersAndParams(BookHashMaps.headersForBooks(), body, EndPoints.API_ENDPOINT, 406);
    }
}
