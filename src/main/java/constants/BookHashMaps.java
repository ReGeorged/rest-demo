package constants;

import java.util.HashMap;
import java.util.Map;

public class BookHashMaps {
    public static final Map headersForBookStore() {
        HashMap<String, String> bookHeaders = new HashMap();
        bookHeaders.put("accept", "application/json");
        bookHeaders.put("Content-Type", "application/json");
        return bookHeaders;
    }
}
