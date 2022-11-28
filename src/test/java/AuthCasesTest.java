import helpers.DataProvider;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.Request;
import pojos.Response;

import static helpers.RestfullHelper.*;
import static helpers.PojoHelper.*;

public class AuthCasesTest {


    @Step("Using username:( {0} ) -- and password ( {1} ); response code should be ( {2} ) -- and message should be ( {3} );")
    @Description("Checking different user cases")
    @Test(dataProvider = "userCasesFromJson", dataProviderClass = DataProvider.class)
    @Parameters()
    public void scenario1(String userName, String password, String code, String message, int expectedHttpStatusCode) {
        SoftAssert softAssert = new SoftAssert();
        Request testRequest = new Request();

        testRequest.setUserName(userName);
        testRequest.setPassword(password);

        String response = sendPostToUser(pojoToJson(testRequest), expectedHttpStatusCode);
        String responseCode = jsonToPojoHelper(response, Response.class).getCode();
        String responseMessage = jsonToPojoHelper(response, Response.class).getMessage();
        softAssert.assertEquals(responseCode, code, "Response Codes dont match");
        softAssert.assertEquals(responseMessage, message, "Response Messages dont match");
        softAssert.assertAll();
    }


}
