import data.DataProvider;
import helpers.PojoHelper;
import helpers.RestfullHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.RequestPojo;
import pojos.ResponsePojo;
import pojos.TokenPojo;

import java.util.List;

public class MainTest {


    @Test(dataProvider = "one", dataProviderClass = DataProvider.class)
    public void test1(String userName, String password, String code, String message) {
        RequestPojo testRequest = new RequestPojo();

        testRequest.setUserName(userName);
        testRequest.setPassword(password);

        String response = RestfullHelper.postToUser(PojoHelper.pojoToJson(testRequest)).asString();
        String responseCode = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getCode();
        String responseMessage = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getMessage();
        Assert.assertEquals(responseCode, code, "Response Codes dont match");
        Assert.assertEquals(responseMessage, message, "Response Messages dont match");
    }

    @Test
    public void test2() {
        RequestPojo testRequest = new RequestPojo();

        testRequest.setUserName("qqVq2qe2r2213232123323c3oolUser231231");
        testRequest.setPassword("ThisIsVery123Strong/#/");

        String pojoToString = PojoHelper.pojoToJson(testRequest);
        String response = RestfullHelper.postToUser(pojoToString).asString();

        String responseUsername = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getUsername();
        System.out.println("username is: " + responseUsername);
        List responseBooksList = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getBooks();
        boolean isEmpty = responseBooksList.isEmpty();

        Assert.assertEquals(responseUsername, testRequest.getUserName(), "UserNames do not match!");
        Assert.assertTrue(isEmpty, "List is not null!");

        Boolean isAuthorized = Boolean.valueOf(RestfullHelper.postToAuthorized(pojoToString).asString());
        Assert.assertFalse(isAuthorized, "User is Authorized!");

        String tokenResponse = RestfullHelper.postToGenerateToken(pojoToString).asString();
        TokenPojo tokenPojo = PojoHelper.jsonToPojoHelper(tokenResponse, TokenPojo.class);
        Assert.assertEquals(tokenPojo.getStatus(), "Success", "Statuses dont match!");
        Assert.assertEquals(tokenPojo.getResult(), "User authorized successfully.", "Results do not match!");

        isAuthorized = Boolean.valueOf(RestfullHelper.postToAuthorized(pojoToString).asString());
        Assert.assertTrue(isAuthorized, "User is not authorized!");
    }

    public void test3() {


    }
}
