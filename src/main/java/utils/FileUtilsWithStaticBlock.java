package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;

import java.util.*;

public class FileUtilsWithStaticBlock {


    private static Map<String, Map> instanceStaticMap;


    static {
        HashMap<String, Map> map = new HashMap<>();
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
                    Map<Object, Object> data = mapper.readValue(fileObj, new TypeReference<>() {
                    });
                    map.put(file.getName(), data);

                } catch (MismatchedInputException ignored) {

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        instanceStaticMap = map;

    }

    public static void main(String[] args) {

        System.out.println(getResourcesJsonValue("configData.json", "generateToken"));


    }

    public static String getResourcesJsonValue(String key1, String key2) {
        Map<String, Map> allMapsFromStaticBlock = instanceStaticMap;

        Map newMap = allMapsFromStaticBlock.get(key1);
        return (String) newMap.get(key2);

    }
}
