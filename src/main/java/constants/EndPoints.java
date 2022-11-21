package constants;

import utils.FileUtils;

public class EndPoints {
    public static final String API_ENDPOINT = FileUtils.readJsonAsStringFromResources("configData.json","usersEndPoint");

}
