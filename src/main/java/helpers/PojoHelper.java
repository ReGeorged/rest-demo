package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

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

    public static String pojoToJson(Object whichObj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(whichObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> List<T> fromJsonToPojoList(String jsonString, Class<T> whatClass) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().
                constructCollectionType(List.class, whatClass);
        try {
            List<T> genericList = mapper.readValue(jsonString, type);
            return genericList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
