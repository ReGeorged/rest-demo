package helpers;

import java.util.HashMap;
import java.util.Map;

public class BookHashMaps {
    public static Map headersForBooks(){
        HashMap<String, String> bookHeaders = new HashMap();
        bookHeaders.put("accept","application/json");
        bookHeaders.put("Content-Type","application/json");
        return bookHeaders;
    }
}
