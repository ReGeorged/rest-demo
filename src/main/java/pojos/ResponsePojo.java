package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePojo {
    private String code;
    private String message;
    private String userID;
    private String username;
    private List books;
}
