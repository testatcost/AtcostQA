package pom.atcost.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;


	private static XSSFRow Row;

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		FileInputStream ExcelFile = new FileInputStream(
				"D://AtcostAuto//AtcostQA//src//main//java//pom//atcost//testdata//Book1.xlsx");
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheetAt(0);
		int z = ExcelWSheet.getLastRowNum();

		System.out.println("no of rows:" + z);
		Cell Cell1 = ExcelWSheet.getRow(RowNum).getCell(ColNum);
//		Cell1.setCellType(Cell.CELL_TYPE_STRING);
//		/*
//		 * if (Cell != null) { switch (Cell.getCellType()) { case
//		 * XSSFCell.CELL_TYPE_BLANK: return null; case XSSFCell.CELL_TYPE_BOOLEAN:
//		 * CellData = String.valueOf( Cell.getBooleanCellValue() ); case
//		 * XSSFCell.CELL_TYPE_NUMERIC: CellData = String.valueOf( ( int )
//		 * Cell.getNumericCellValue() ); case XSSFCell.CELL_TYPE_STRING: CellData =
//		 * Cell.getRichStringCellValue().toString();
//		 * 
//		 * } }
//		 */
		String CellData =
				 Cell1.getStringCellValue();;
		return CellData;

	}

//This method is to write in the Excel cell, Row num and Col num are the parameters

	/*
	 * public static void setCellData(String Result, int RowNum, int ColNum) throws
	 * Exception {
	 * 
	 * try {
	 * 
	 * Row = ExcelWSheet.getRow(RowNum);
	 * 
	 * Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
	 * 
	 * if (Cell == null) {
	 * 
	 * Cell = Row.createCell(ColNum);
	 * 
	 * Cell.setCellValue(Result);
	 * 
	 * } else {
	 * 
	 * Cell.setCellValue(Result);
	 * 
	 * }
	 * 
	 * // Constant variables Test Data path and Test Data file name
	 * 
	 * // FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData +
	 * // Constant.File_TestData);
	 * 
	 * // ExcelWBook.write(fileOut);
	 * 
	 * // fileOut.flush();
	 * 
	 * //fileOut.close();
	 
		} catch (Exception e) {

			throw (e);

		}
*/
	}

