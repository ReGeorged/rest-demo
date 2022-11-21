import helpers.PojoHelper;
import helpers.RestfullHelper;
import org.testng.annotations.Test;
import pojos.RequestPojo;
import pojos.ResponsePojo;

public class MainTest {

    @Test
    public void testUsers(){
        RequestPojo sample = new RequestPojo();

        sample.setUserName("automation");
        sample.setPassword("Automation@!@123");

        String response = RestfullHelper.postToUser(PojoHelper.pojoToJson(sample)).asString();
        String responseCode = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getCode();
        String responseMessage = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getMessage();


        System.out.println(responseCode);

    }
}
