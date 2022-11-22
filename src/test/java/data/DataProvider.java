package data;

import helpers.PojoHelper;
import pojos.BooksApiPojo;
import utils.FileUtils;

import java.util.List;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "one")
    public Object[][] getDataParameters() {
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<BooksApiPojo> list = PojoHelper.fromJsonToPojoList(jsonString, BooksApiPojo.class);
        Object[][] testScenariosArray = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            testScenariosArray[i][0] = list.get(i).getRequest().getUserName();
            testScenariosArray[i][1] = list.get(i).getRequest().getPassword();
            testScenariosArray[i][2] = list.get(i).getResponse().getCode();
            testScenariosArray[i][3] = list.get(i).getResponse().getMessage();
        }
        return testScenariosArray;
    }
}
