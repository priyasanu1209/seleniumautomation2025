package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
	public static void main() throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//XSSFSheet sheet=workbook.getSheet("sheet1");
		XSSFSheet sheet=workbook.getSheetAt(0);
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();
		System.out.println("number of rows"+totalRows);
		System.out.println("number of cells"+totalCells);
	}

}
