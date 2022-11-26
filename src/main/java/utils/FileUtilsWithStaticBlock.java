package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileUtilsWithStaticBlock {



//    static{
//        System.out.println("STATIC BLOCK");
//        ObjectMapper mapper = new ObjectMapper();
//        String path = "src/main/resources/configData.json";
//
//        File fileObj = new File(path);
//
//        try {
//            map = mapper.readValue(fileObj, new TypeReference<>() {});
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    private static Map<Object, Object> map;


    public static String readJsonAsStringFromResources(String key) {

        return map.get(key).toString();

    }


    public static Map getKindaAllMaps() {
        HashMap<String, Object> map = new HashMap<>();
        File testResourcesDir = new File("src/test/resources");
        File mainResourcesDir = new File("src/main/resources");
        File testContents[] = testResourcesDir.listFiles();
        File mainContents[] = mainResourcesDir.listFiles();
        File bigArray[] = ArrayUtils.concatWithCollection(testContents,mainContents);
        for (File file : bigArray ) {
            if (file.getName().endsWith(".json")) {


                ObjectMapper mapper = new ObjectMapper();
                String path = file.getAbsolutePath();
                File fileObj = new File(path);
                try {
                    Map<String, Object> data = mapper.readValue(fileObj, new TypeReference<>() {
                    });
                    map.put(file.getName(), data);

                } catch (MismatchedInputException x) {

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return map;

//
//        System.out.println("TESTING TWO MAPS");
//
//        Map<String, String> map1 = new HashMap<>();
//        Map<String, String> map2 = new HashMap<>();
//        map1.put("firstMap1","one");
//        map1.put("firstMap2","two");
//
//        map1.put("firstMap3","three");
//
//        map1.put("firstMap4","four");
//
//        map2.put("secondMap1","one");
//        map2.put("secondMap2","two");
//        map2.put("secondMap3","three");
//        map2.put("secondMap4","four");
//
//        Map<Object,Object> thirdMap = new HashMap<>();
//        thirdMap.put("map1",map1);
//        thirdMap.put("map2",map2);
//
//        Map result = (Map) thirdMap.get("map1");
//        System.out.println(result.get("firstMap1"));
    }

//    public static String test2(String key){
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        File fileObj = new File("path");
//
//        try {
//            Map<String, Object> data = mapper.readValue(fileObj, new TypeReference<>() {});
//            return data.get(key).toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }

    public static void main(String[] args) {
//        System.out.println(getKindaAllMaps());
//
//        System.out.println("asda");
        System.out.println(getKindaAllMaps());

        System.out.println(getNestedMapContents("defaultTestData.json", "username"));


    }

    public static String getNestedMapContents(String key1, String key2) {
        Map<Object, Object> getKindaAllMaps = getKindaAllMaps();

        Map<Object, Object> newMap = (Map<Object, Object>) getKindaAllMaps.get(key1);
        return (String) newMap.get(key2);

    }
}
