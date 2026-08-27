package dataProvider;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;

public class DataProviderClass {
    @DataProvider(name="loginData")
    public static Object[][] getLoginData(){
            String filePath="src/main/resources/testdata.xlsx";
            ExcelUtility excel=new ExcelUtility(filePath,"Sheet1");
             int rowCount= excel.getRowCount();
             int coloumnCount= excel.getColoumnCount();

        Object[][] data=new Object[rowCount][coloumnCount];
        System.out.println("==============Excel data============");
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<coloumnCount;j++){
                    data[i][j]=excel.getCellData(i+1,j);
                    System.out.println("Row: "+i+" | Column "+j+" | value: "+data[i][j]);
            }

        }
        System.out.println("==================================");
        excel.closeWorkbook();
        return data;
    }

}
