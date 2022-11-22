package constants;

import utils.FileUtils;

public class CustomParameters {

    public static final String DEFAULT_USERNAME = FileUtils.readJsonAsStringFromResources("defaultTestData.json", "username");
    public static final String PWD = FileUtils.readJsonAsStringFromResources("defaultTestData.json", "password");

}
