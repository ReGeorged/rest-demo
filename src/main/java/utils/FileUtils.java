package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {
    static {
        instanceStaticMap = varArgsJsonMapper("src/test/resources/defaultTestData.json",
                "src/main/resources/configData.json");
    }

    private static <T> Map<String, Map> varArgsJsonMapper(String... pathsOfJsonFiles) {
        HashMap<String, Map> mapOfFilesAndJsons = new HashMap<>();
        for (String paths : pathsOfJsonFiles) {
            ObjectMapper mapper = new ObjectMapper();
            File fileObj = new File(paths);
            try {
                Map<String, String> jsonDataMap = mapper.readValue(fileObj, new TypeReference<Map<String, String>>() {
                });
                mapOfFilesAndJsons.put(fileObj.getName(), jsonDataMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapOfFilesAndJsons;
    }

    private static Map<String, Map> instanceStaticMap;

    public static String readJsonAsStringFromResources(String jsonFileNameInResources, String key) {
        Map<String, Map> allMapsFromStaticBlock = instanceStaticMap;
        Map newMap = allMapsFromStaticBlock.get(jsonFileNameInResources);
        return (String) newMap.get(key);
    }

    public static String convertFileIntoString(String filePath) {
        String result;

        try {
            result = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
