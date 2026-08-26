
package testselenium.utils;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	private static String filePath =
	        System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";
	
	public static String getCelldata(int row, int column)throws IOException
	{
		FileInputStream fs = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		String cellData = sheet.getRow(row).getCell(column).getStringCellValue();
		
		workbook.close();
		fs.close();
		return cellData;
		
		
		
		
		
	}
	
	public static int getRowCount() throws IOException {

        FileInputStream fs = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        workbook.close();
        fs.close();

        return rowCount;
    }

}
