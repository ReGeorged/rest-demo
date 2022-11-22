import constants.CustomParameters;
import helpers.PojoHelper;
import helpers.RestfullHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.RequestPojo;
import pojos.ResponsePojo;
import pojos.TokenPojo;

import java.util.List;

public class AuthTest {

    @Description("executing scenario two: checking user creation and validation....")
    @Parameters({"user-name"})
    @Test
    public void scenario2(@Optional String param) {
        SoftAssert softAssert = new SoftAssert();

        // თუ არ მივაწვდით კონკრეტულ იუზერნეიმს დეფაულტად დაისეტება იუზერნეიმი ჯეისონ ფაილიდან
        String userName = CustomParameters.DEFAULT_USERNAME;
        if (!(param == null) && !param.equals("${user-name}")) {
            userName = param;
        }
        RequestPojo testRequest = new RequestPojo();
        testRequest.setUserName(userName);
        testRequest.setPassword(CustomParameters.PWD);

        String pojoToString = PojoHelper.pojoToJson(testRequest);
        String response = RestfullHelper.postToUser(pojoToString).asString();

        String responseUsername = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getUsername();

        List responseBooksList = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getBooks();

        Assert.assertNotNull(responseUsername, "response Username is null");
        Assert.assertNotNull(responseBooksList, "response Book list is null");
        Assert.assertEquals(responseUsername, testRequest.getUserName(), "UserNames do not match!");
        Assert.assertTrue(responseBooksList.isEmpty(), "List is not null!");

        boolean isAuthorized = Boolean.parseBoolean(RestfullHelper.postToAuthorized(pojoToString).asString());
        Assert.assertFalse(isAuthorized, "User is Authorized!");

        String tokenResponse = RestfullHelper.postToGenerateToken(pojoToString).asString();
        TokenPojo tokenPojo = PojoHelper.jsonToPojoHelper(tokenResponse, TokenPojo.class);
        Assert.assertEquals(tokenPojo.getStatus(), "Success", "Statuses dont match!");
        Assert.assertEquals(tokenPojo.getResult(), "User authorized successfully.", "Results do not match!");

        isAuthorized = Boolean.parseBoolean(RestfullHelper.postToAuthorized(pojoToString).asString());
        Assert.assertTrue(isAuthorized, "User is not authorized!");
    }
}
