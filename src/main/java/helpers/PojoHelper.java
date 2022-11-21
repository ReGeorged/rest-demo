package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoHelper {

    public static <T> T jsonPojoHelper(String whatToRead, Class<T> whatClass) {
        try {
            T pojo = new ObjectMapper()
                    .readerFor(whatClass)
                    .readValue(whatToRead);
            return pojo;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
