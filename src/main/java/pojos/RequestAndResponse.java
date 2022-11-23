package pojos;

import lombok.Data;


import java.util.Map;

@Data
public class RequestAndResponse {

    private Request request;
    private Response response;


    public void unpackRequestAndResponse(Map<String, Object> requestAndResponse) {
        this.request = (Request) requestAndResponse.get("request");
        this.response = (Response) requestAndResponse.get("response");
    }
}
