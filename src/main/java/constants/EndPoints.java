package constants;

import utils.FileUtils;
import utils.FileUtilsWithStaticBlock;

public class EndPoints {
    public static final String API_ENDPOINT = FileUtilsWithStaticBlock.readJsonAsStringFromResources("configData.json", "usersEndPoint");
    public static final String AUTHORIZED_ENDPOINT = FileUtilsWithStaticBlock.readJsonAsStringFromResources("configData.json", "authorizedEndPoint");
    public static final String GENERATE_TOKEN_ENDPOINT = FileUtilsWithStaticBlock.readJsonAsStringFromResources("configData.json", "generateToken");


}
