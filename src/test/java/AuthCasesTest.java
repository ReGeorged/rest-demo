import helpers.DataProvider;
import helpers.PojoHelper;
import helpers.RestfullHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.Request;
import pojos.Response;

public class AuthCasesTest {


    @Step("Using username:( {0} ) -- and password ( {1} ); response code should be ( {2} ) -- and message should be ( {3} );")
    @Description("Checking different user cases")
    @Test(dataProvider = "requestAndResponseDataProvider", dataProviderClass = DataProvider.class)
    public void scenario1(String userName, String password, String code, String message) {
        SoftAssert softAssert = new SoftAssert();
        Request testRequest = new Request();

        testRequest.setUserName(userName);
        testRequest.setPassword(password);

        String response = RestfullHelper.sendPostToUser(PojoHelper.pojoToJson(testRequest)).asString();
        String responseCode = PojoHelper.jsonToPojoHelper(response, Response.class).getCode();
        String responseMessage = PojoHelper.jsonToPojoHelper(response, Response.class).getMessage();
        softAssert.assertEquals(responseCode, code, "Response Codes dont match");
        softAssert.assertEquals(responseMessage, message, "Response Messages dont match");
        softAssert.assertAll();
    }


}
