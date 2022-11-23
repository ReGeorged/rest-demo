package helpers;

import pojos.RequestAndResponse;
import utils.FileUtils;

import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "userCasesFromJson")
    public static Object[][] requestAndResponseDataProvider() {
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<RequestAndResponse> testDataList = PojoHelper.fromJsonToPojoList(jsonString, RequestAndResponse.class);
        /*
        testData ლისტს აქვს N -რაოდენობის ელემენტები(ამ შემთხვევაში მოგვაქვს ჯეისონიდან - ყველაფერი დაყვანილია პოჯოზე)
        თითოეული ელემენტი არის bookApi კლასის ტიპის რომლებსაც თავად აქვთ ორი ატრიბუტი request და response
        - თითოეულ მათგანს აქვთ ორ ორი ელემენტი ჯამში 4 - მეორე განზომილება არის 4 ელემენტიანი
        პირველი განზომილება დამოკიდებულია თუ ჯეისონიდან რამდენი BookApi კლასის ელემენტი დაიპარსება
        ჯეისონ ფაილიდან ყველა ელემენტი ემატება testDataLists - შესაბამისად პირველი განზომილება დინამიურია
        */
        Object[][] testScenariosArray = new Object[testDataList.size()][4];
        for (int i = 0; i < testDataList.size(); i++) {
            testScenariosArray[i][0] = testDataList.get(i).getRequest().getUserName();
            testScenariosArray[i][1] = testDataList.get(i).getRequest().getPassword();
            testScenariosArray[i][2] = testDataList.get(i).getResponse().getCode();
            testScenariosArray[i][3] = testDataList.get(i).getResponse().getMessage();
        }
        return testScenariosArray;
    }
}
