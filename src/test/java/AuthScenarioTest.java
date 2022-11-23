import constants.CustomParameters;
import helpers.PojoHelper;
import helpers.RestfullHelper;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.Request;
import pojos.Response;
import pojos.Token;

import java.util.List;

public class AuthScenarioTest {

    @Description("executing scenario two: checking user creation and validation....")
    @Parameters({"user-name"})
    @Test
    public void scenario2(@Optional String param) {
        // თუ არ მივაწვდით კონკრეტულ იუზერნეიმს დეფაულტად დაისეტება იუზერნეიმი ჯეისონ ფაილიდან
        String userName = CustomParameters.DEFAULT_USERNAME;
        if (!(param == null) && !param.equals("${user-name}")) {
            userName = param;
        }
        Request testRequest = new Request();
        testRequest.setUserName(userName);
        testRequest.setPassword(CustomParameters.PWD);

        String pojoToString = PojoHelper.pojoToJson(testRequest);
        String response = RestfullHelper.sendPostToUser(pojoToString).asString();

        String responseUsername = PojoHelper.jsonToPojoHelper(response, Response.class).getUsername();

        List responseBooksList = PojoHelper.jsonToPojoHelper(response, Response.class).getBooks();

        Assert.assertNotNull(responseUsername, "Response username is null");
        Assert.assertNotNull(responseBooksList, "Response book list is null");
        Assert.assertEquals(responseUsername, testRequest.getUserName(), "Usernames do not match!");
        Assert.assertTrue(responseBooksList.isEmpty(), "Books list is not null!");

        boolean isAuthorized = Boolean.parseBoolean(RestfullHelper.sendPostToAuthorize(pojoToString).asString());
        Assert.assertFalse(isAuthorized, "User authorized value should be false!");

        String tokenResponse = RestfullHelper.sendPostToGenerateToken(pojoToString).asString();
        Token token = PojoHelper.jsonToPojoHelper(tokenResponse, Token.class);
        Assert.assertEquals(token.getStatus(), "Success", "Token status is not Successful!");
        Assert.assertEquals(token.getResult(), "User authorized successfully.", "Authorization unsuccessful!");

        isAuthorized = Boolean.parseBoolean(RestfullHelper.sendPostToAuthorize(pojoToString).asString());
        Assert.assertTrue(isAuthorized, "User authorized value should be true!");
    }
}
