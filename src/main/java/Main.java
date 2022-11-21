import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.PojoHelper;
import helpers.RestfullHelper;
import pojos.RequestPojo;
import pojos.ResponsePojo;

public class Main {
    public static void main(String[] args){
        RequestPojo sample = new RequestPojo();

        sample.setUserName("automation");
        sample.setPassword("Automation@!@123");

        String response = RestfullHelper.postToUser(PojoHelper.pojoToJson(sample)).asString();
        String responseCode = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getCode();
        System.out.println(responseCode);

    }
}
