package constants;

import utils.FileUtils;
import utils.FileUtilsWithStaticBlock;

public class CustomParameters {

    public static final String DEFAULT_USERNAME = FileUtilsWithStaticBlock.readJsonAsStringFromResources("defaultTestData.json", "username");
    public static final String PWD = FileUtilsWithStaticBlock.readJsonAsStringFromResources("defaultTestData.json", "password");

}
