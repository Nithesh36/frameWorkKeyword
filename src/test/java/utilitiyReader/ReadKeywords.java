package utilitiyReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadKeywords {



	static XSSFWorkbook workbook;
	static Cell cell;
	static Row row ;
	public static ArrayList<String >dataTable  =new ArrayList<String>();
	public static  void getKeyword(int col) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(InitiatePropertyFile.properties.getProperty("ExcelPath")));
		workbook = new XSSFWorkbook(inputStream);
		XSSFSheet workSheet = workbook.getSheetAt(0);
		int noOfRows = workSheet.getLastRowNum() + 1;
		//	int noOfColumns = workSheet.getRow(0).getLastCellNum();




		for(int i=1;i<noOfRows;i++) {
			row = workSheet.getRow(i);

			dataTable.add( new DataFormatter().formatCellValue(row.getCell(col)));

		}


	}


}
