package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.Map;

@Data
public class BooksApi {

    private Request request;
    private Response response;


    public void unpackMail(Map<String, Object> usersApi) {
        this.request = (Request) usersApi.get("request");
        this.response = (Response) usersApi.get("response");
    }
}
