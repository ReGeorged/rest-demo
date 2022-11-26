package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;

import java.util.*;

public class FileUtilsWithStaticBlock {
    static {
        HashMap<String, Map> mapOfFilesAndJsons = new HashMap<>();
        File testResourcesDir = new File("src/test/resources");
        File mainResourcesDir = new File("src/main/resources");
        File[] testContents = testResourcesDir.listFiles();
        File[] mainContents = mainResourcesDir.listFiles();
        File[] bigArray = ArrayUtils.concatWithCollection(testContents, mainContents);

        for (File file : bigArray) {
            if (file.getName().endsWith(".json")) {
                ObjectMapper mapper = new ObjectMapper();
                String path = file.getAbsolutePath();
                File fileObj = new File(path);
                try {
                    Map<Object, Object> jsonDataMap = mapper.readValue(fileObj, new TypeReference<>() {
                    });
                    mapOfFilesAndJsons.put(file.getName(), jsonDataMap);

                } catch (MismatchedInputException ignored) {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        instanceStaticMap = mapOfFilesAndJsons;

    }

    private static Map<String, Map> instanceStaticMap;

    public static String readJsonAsStringFromResources(String jsonFileNameInResources, String key) {
        Map<String, Map> allMapsFromStaticBlock = instanceStaticMap;
        Map newMap = allMapsFromStaticBlock.get(jsonFileNameInResources);
        return (String) newMap.get(key);
    }
}
