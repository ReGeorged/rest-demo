package constants;

import utils.FileUtils;

public class EndPoints {
    public static final String API_ENDPOINT = FileUtils.readJsonAsStringFromResources("configData.json", "usersEndPoint");
    public static final String AUTHORIZED_ENDPOINT = FileUtils.readJsonAsStringFromResources("configData.json", "authorizedEndPoint");
    public static final String GENERATE_TOKEN_ENDPOINT = FileUtils.readJsonAsStringFromResources("configData.json", "generateToken");


}
