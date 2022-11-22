package pojos;

import lombok.Data;

@Data
public class Token {
    private String token;
    private String expires;
    private String status;
    private String result;
}
