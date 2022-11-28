import constants.CustomParameters;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Request;
import pojos.Response;
import pojos.Token;

import static helpers.PojoHelper.*;
import static helpers.RestfullHelper.*;

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

        String pojoToString = pojoToJson(testRequest);
        String response = sendPostToUser(pojoToString, 201);

        String responseUsername = jsonToPojoHelper(response, Response.class).getUsername();

        List responseBooksList = jsonToPojoHelper(response, Response.class).getBooks();

        Assert.assertNotNull(responseUsername, "Response username is null");
        Assert.assertNotNull(responseBooksList, "Response book list is null");
        Assert.assertEquals(responseUsername, testRequest.getUserName(), "Usernames do not match!");
        Assert.assertTrue(responseBooksList.isEmpty(), "Books list is not null!");

        boolean isAuthorized = Boolean.parseBoolean(sendPostToAuthorize(pojoToString, 200));
        Assert.assertFalse(isAuthorized, "User authorized value should be false!");

        String tokenResponse = sendPostToGenerateToken(pojoToString, 200);
        Token token = jsonToPojoHelper(tokenResponse, Token.class);
        Assert.assertEquals(token.getStatus(), "Success", "Token status is not Successful!");
        Assert.assertEquals(token.getResult(), "User authorized successfully.", "Authorization unsuccessful!");

        isAuthorized = Boolean.parseBoolean(sendPostToAuthorize(pojoToString, 200));
        Assert.assertTrue(isAuthorized, "User authorized value should be true!");
    }
}
