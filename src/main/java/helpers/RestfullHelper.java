package helpers;

import constants.EndPoints;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullHelper {

    private static Response postWithHeadersAndBody(Map headersHashMap, String body, String endPoint) {
        Response res = given()
                .headers(headersHashMap)
                .body(body)
                .when()
                .post(endPoint).
                then()
                .extract().response();
        return res;
    }

    public static Response postToUser(String userJsonBody) {
        return postWithHeadersAndBody(BookHashMaps.headersForBooks(), userJsonBody, EndPoints.API_ENDPOINT);
    }

    public static Response postToAuthorized(String userJsonBody) {
        return postWithHeadersAndBody(BookHashMaps.headersForBooks(), userJsonBody, EndPoints.AUTHORIZED_ENDPOINT);
    }
    public static Response postToGenerateToken(String userJsonBody) {
        return postWithHeadersAndBody(BookHashMaps.headersForBooks(), userJsonBody, EndPoints.GENERATE_TOKEN_ENDPOINT);
    }
}
