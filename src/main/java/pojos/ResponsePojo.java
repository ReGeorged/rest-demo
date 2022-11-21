package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@SuppressWarnings("unchecked")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo {
    private String code;
    private String message;
}
