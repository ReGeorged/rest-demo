package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileUtils {
    public static String readJsonAsStringFromResources(String jsonNameInResources, String key) {
        ObjectMapper mapper = new ObjectMapper();
        String path = "src/main/resources/" + jsonNameInResources;

        File fileObj = new File(path);
        if (!fileObj.exists()) {
            path = "src/test/resources/" + jsonNameInResources;
            fileObj = new File(path);
        }

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


    public static String convertFileIntoString(String file) {
        String result;

        try {
            result = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
