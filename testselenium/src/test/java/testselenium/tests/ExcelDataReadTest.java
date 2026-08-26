package testselenium.tests;

import java.io.IOException;

import testselenium.utils.ExcelUtils;

public class ExcelDataReadTest {
	public static void main(String args[]) throws IOException {

		System.out.println("Excel open sucessfully");

		int rows = ExcelUtils.getRowCount();
		System.out.println("Rows " + rows);

		System.out.println("Username :" + ExcelUtils.getCelldata(1,0));
		System.out.println("Password :" + ExcelUtils.getCelldata(1,1));
		
		System.out.println("Username :" + ExcelUtils.getCelldata(2,0));
		System.out.println("Password :" + ExcelUtils.getCelldata(2,1));
		
		System.out.println("Username :" + ExcelUtils.getCelldata(3,0));
		System.out.println("Password :" + ExcelUtils.getCelldata(3,1));

	}

}
