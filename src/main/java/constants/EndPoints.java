package constants;

import static utils.FileUtils.readJsonAsStringFromResources;

public class EndPoints {
    public static final String API_ENDPOINT = readJsonAsStringFromResources("configData.json", "usersEndPoint");
    public static final String AUTHORIZED_ENDPOINT = readJsonAsStringFromResources("configData.json", "authorizedEndPoint");
    public static final String GENERATE_TOKEN_ENDPOINT = readJsonAsStringFromResources("configData.json", "generateToken");


}
