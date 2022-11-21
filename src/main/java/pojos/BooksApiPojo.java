package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.Map;

@Data
public class BooksApiPojo {

    private RequestPojo request;
    private ResponsePojo response;

    @SuppressWarnings("unchecked")
    @JsonProperty("$")
    public void unpackMail(Map<String, Object> usersApi) {
        this.request = (RequestPojo) usersApi.get("request");
        this.response = (ResponsePojo) usersApi.get("response");
    }
}
