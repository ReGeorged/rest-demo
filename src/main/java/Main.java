import helpers.RestfullHelper;

public class Main {
    public static void main(String[] args) {
        String response = RestfullHelper.postToUser("{\n" +
                "  \"userName\": \"automation\",\n" +
                "  \"password\": \"Automation@!@123\"\n" +
                "}").asString();
    }
}
