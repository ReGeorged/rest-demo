package pojos;

import lombok.Data;

@Data
public class TokenPojo {
    private String token;
    private String expires;
    private String status;
    private String result;
}
