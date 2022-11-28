package helpers;

import constants.BookHashMaps;
import constants.EndPoints;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullHelper {

    private static String sendPostWithHeadersAndBody(Map headersHashMap, String body, String endPoint, int expectedStatusCode) {
        String res = given()
                .headers(headersHashMap)
                .body(body)
                .when()
                .post(endPoint).
                then().assertThat().statusCode(expectedStatusCode)
                .extract().response().asString();
        return res;
    }

    public static String sendPostToUser(String jsonBody, int expectedStatusCode) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.API_ENDPOINT, expectedStatusCode);
    }

    public static String sendPostToAuthorize(String jsonBody, int expectedStatusCode) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.AUTHORIZED_ENDPOINT, expectedStatusCode);
    }

    public static String sendPostToGenerateToken(String jsonBody, int expectedStatusCode) {
        return sendPostWithHeadersAndBody(BookHashMaps.headersForBookStore(), jsonBody, EndPoints.GENERATE_TOKEN_ENDPOINT, expectedStatusCode);
    }
}
