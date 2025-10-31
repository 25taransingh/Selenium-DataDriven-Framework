package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriven {
	
	// By using DataFormatter object we can convert the data type as desired
    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id) {
        System.out.println(greeting + " " + communication + " " + id);
    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\excelDriven.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
       
        //We used 0 as a index bcoz we know data is available in first sheet.
        XSSFSheet sheet = wb.getSheetAt(0);
        // By using the sheet ref we will get the how many filled rows are present in sheet which contain value
        // rowCount tell how many row present
        int rowCount = sheet.getPhysicalNumberOfRows();
        // By using sheet ref we get the access of first row and from that access we get the column count.
        XSSFRow row = sheet.getRow(0);
     // colCount tell how many column present
        int colCount = row.getLastCellNum();
        
        

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                // this convert the read data from excel to string type, No matter which data type is present.
                data[i][j] = formatter.formatCellValue(cell);
            }
        }

        wb.close();
        fis.close();
        return data;
    }
}
