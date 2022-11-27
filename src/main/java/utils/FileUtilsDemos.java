package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileUtilsDemos {


    static {
//        instanceStaticMap =mapAllJsonFilesInResources();
        instanceStaticMap = varArgsJsonMapper("src/test/resources/defaultTestData.json","src/main/resources/configData.json");

    }




    @Deprecated
    private static Map<String, Map> mapAllJsonFilesInResources(){


        HashMap<String, Map> mapOfFilesAndJsons = new HashMap<>();
        File testResourcesDir = new File("src/test/resources");
        File mainResourcesDir = new File("src/main/resources");
        File[] testContents = testResourcesDir.listFiles();
        File[] mainContents = mainResourcesDir.listFiles();
        File[] bigArray = ArrayUtils.concatWithCollection(testContents, mainContents);
        for (File file : bigArray) {
            System.out.println(file);
            if (file.getName().endsWith(".json")) {
                ObjectMapper mapper = new ObjectMapper();
                String path = file.getAbsolutePath();
                File fileObj = new File(path);
                try {
                    Map<String, String> jsonDataMap = mapper.readValue(fileObj, new TypeReference<>() {
                    });
                    mapOfFilesAndJsons.put(file.getName(), jsonDataMap);

                } catch (MismatchedInputException ignored) {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return mapOfFilesAndJsons;
    }

    private static Map<String,Map> varArgsJsonMapper(String... pathsOfJsonFiles){
        HashMap<String, Map> mapOfFilesAndJsons = new HashMap<>();
        for (String  paths : pathsOfJsonFiles) {
            System.out.println(paths);
            ObjectMapper mapper = new ObjectMapper();
            File fileObj = new File(paths);
            try {
                Map<String, String> jsonDataMap = mapper.readValue(fileObj, new TypeReference<>() {
                });
                mapOfFilesAndJsons.put(fileObj.getName(), jsonDataMap);

            } catch (MismatchedInputException ignored) {

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

    public static void main(String[] args) {
        String response = readJsonAsStringFromResources("defaultTestData.json","username");
        System.out.println(response);
    }
}
