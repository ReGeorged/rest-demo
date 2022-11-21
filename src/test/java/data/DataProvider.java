package data;

import helpers.PojoHelper;
import helpers.RestfullHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.BooksApiPojo;
import pojos.RequestPojo;
import pojos.ResponsePojo;
import utils.FileUtils;

import java.util.List;

public class DataProvider {

    @Test(dataProvider = "one")
    public void test2(String userName, String password, String code, String message) {
        RequestPojo sample = new RequestPojo();

        sample.setUserName(userName);
        System.out.println("username: " + userName);
        sample.setPassword(password);
        System.out.println("password: " + password);
        System.out.println("------------");

        String response = RestfullHelper.postToUser(PojoHelper.pojoToJson(sample)).asString();
        String responseCode = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getCode();
        String responseMessage = PojoHelper.jsonToPojoHelper(response, ResponsePojo.class).getMessage();

        Assert.assertEquals(responseCode,code);
        Assert.assertEquals(responseMessage,message);


        System.out.println(responseCode);


    }







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
