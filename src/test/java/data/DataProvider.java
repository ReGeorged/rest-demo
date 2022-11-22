package data;

import helpers.PojoHelper;
import pojos.BooksApiPojo;
import utils.FileUtils;

import java.util.List;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "one")
    public Object[][] getDataParameters() {
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<BooksApiPojo> testDataList = PojoHelper.fromJsonToPojoList(jsonString, BooksApiPojo.class);
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
