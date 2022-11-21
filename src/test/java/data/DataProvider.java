package data;

import org.testng.annotations.Test;
import utils.FileUtils;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "1")
    public Object[][] dataSet(){
        Object[][] dataset = {{"userName1","password1","code1","message1"},
                {"userName2","password2","code2","message2"},
                {"userName3","password3","code3","message3"},
                {"userName4","password4","code4","message4"}};

        return dataset;
    }

    @Test(dataProvider = "1" )
    public void testDataProvider(String userName, String password,String code, String message){
        System.out.println("username: "+userName);


        System.out.println("------------");
        System.out.println("password: "+password);
        System.out.println("------------");
        System.out.println("code: "+code);
        System.out.println("------------");
        System.out.println("message: "+message);

//        System.out.println(FileUtils.readJsonAsStringFromResources("testData.json","userName"));

    }
}
