package pojos;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private String code;
    private String message;
    private String userID;
    private String username;
    private List books;
    private int httpStatusCode;
}
