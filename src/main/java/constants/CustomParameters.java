package constants;

import static utils.FileUtils.readJsonAsStringFromResources;

public class CustomParameters {

    public static final String DEFAULT_USERNAME = readJsonAsStringFromResources("defaultTestData.json", "username");
    public static final String PWD = readJsonAsStringFromResources("defaultTestData.json", "password");

}
