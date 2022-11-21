package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoHelper {

    public static <T> T jsonToPojoHelper(String whatToRead, Class<T> whatClass) {
        try {
            T pojo = new ObjectMapper()
                    .readerFor(whatClass)
                    .readValue(whatToRead);
            return pojo;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String pojoToJson(Object whichClass) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(whichClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
