package helpers;

import constants.BookHashMaps;
import constants.EndPoints;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullHelper {

    private static Response sendPostWithHeadersAndBody(Map headersHashMap, String body, String endPoint) {
        Response res = given()
                .headers(headersHashMap)
                .body(body)
                .when()
                .post(endPoint).
                then()
                .extract().response();
        return res;
    }

    public static Response sendPostToUser(String jsonBody) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.API_ENDPOINT);
    }

    public static Response sendPostToAuthorize(String jsonBody) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.AUTHORIZED_ENDPOINT);
    }

    public static Response sendPostToGenerateToken(String jsonBody) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.GENERATE_TOKEN_ENDPOINT);
    }
}
