package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

public class FileUtils {
    public static String readFromJsonAsString(String jsonNameInResources, String key) {
        ObjectMapper mapper = new ObjectMapper();
        File fileObj = new File("src/main/resources/" + jsonNameInResources);
        try {
            Map<String, Object> data = mapper.readValue(
                    fileObj, new TypeReference<Map<String, Object>>() {
                    });
            return data.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
