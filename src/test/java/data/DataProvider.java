package data;

import helpers.PojoHelper;
import org.testng.annotations.Test;
import pojos.BooksApiPojo;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "1")
    public Object[][] dataSet(){
        Object[][] dataset = {{"userName1","password1","code1","message1"},
                {"userName2","password2","code2","message2"},
                {"userName3","password3","code3","message3"},
                {"userName4","password4","code4","message4"}};

        System.out.println(dataset[3][1]);

        return dataset;
    }

    @Test(dataProvider = "one" )
    public void testDataProvider(String userName, String password,String code, String message){
        System.out.println("username: "+userName);


        System.out.println("------------");
        System.out.println("password: "+password);
        System.out.println("------------");
        System.out.println("code: "+code);
        System.out.println("------------");
        System.out.println("message: "+message);

        System.out.println("\n END OF FIRST DIMENSION");

//        System.out.println(FileUtils.readJsonAsStringFromResources("testData.json","userName"));

    }


    @Test
    public void tryThis(){
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<BooksApiPojo> list=  PojoHelper.fromJsonToPojoList(jsonString,BooksApiPojo.class);
        for (int j =0; j<list.size();j++){
            System.out.println(list.get(j).getResponse().getMessage());
        }
    }


    @Test
    public Object[][] jsonArray(){
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<BooksApiPojo> list=  PojoHelper.fromJsonToPojoList(jsonString,BooksApiPojo.class);
        int listSize = list.size();
        Object[][] array = new Object[listSize][listSize];
        for(int i=0;i<listSize;i++){

        }

        System.out.println(list.get(0));
        return array;
    }

    @org.testng.annotations.DataProvider(name ="one")
    public Object[][] test(){
        String jsonString = FileUtils.convertFileIntoString("src/test/resources/testData.json");
        List<BooksApiPojo> list=  PojoHelper.fromJsonToPojoList(jsonString,BooksApiPojo.class);
        Object[][] wait = new Object[list.size()][4];
        int attributeSize = 0;
        for (int i =0; i<list.size();i++){
            ArrayList newCase = new ArrayList<>();
            newCase.add(list.get(i).getRequest().getUserName());
            newCase.add(list.get(i).getRequest().getPassword());
            newCase.add(list.get(i).getResponse().getCode());
            newCase.add(list.get(i).getResponse().getMessage());

            attributeSize =newCase.size();
            for (int j=0;j<attributeSize;j++){
                wait[i][j] = newCase.get(j);

            }
        }
        return wait;


    }
}
