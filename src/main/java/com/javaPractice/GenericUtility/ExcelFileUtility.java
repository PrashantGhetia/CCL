package com.javaPractice.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This method will return Cell Type of input cell of the Excel Sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public CellType cellType(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum);
		CellType cellType = cell.getCellType();
		wb.close();
		return cellType;
	}
	/**
	 * This method will read the data from the Excel sheet and return the value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcel(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		//String value = "";
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum);
		String value = cell.getStringCellValue();
		wb.close();
		return value;
		}
	
	/**
	 * This method will read the data from the Excel sheet and return the value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readStringDataFromExcel(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		//String value = "";
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum);	
		String value = cell.getStringCellValue();
		wb.close();
		return value;
		}
	
	/**
	 * This method will read the Numeric data from the Excel sheet and return the value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readNumericDataFromExcel(String sheetName, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum);
		DataFormatter dataFormatter = new DataFormatter();
		String value = dataFormatter.formatCellValue(cell);
		wb.close();
		return value;
		}
	/**
	 * This method will return the last row number in particular sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		wb.close();
		return lastRow;
	}
	/**
	 * This method will write data into the Excel sheet
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String sheetName, int rownum, int cellnum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public void writeDataIntoNewExcel(String sheetName, int rownum, int cellnum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public void writeIntegerDataIntoExcel(String sheetName, int rownum, int cellnum, int value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(cellnum);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method is used for a test script with multiple set of data
	 * Hence it will return 2 dimensional object[][] so that it can be directly used in Data Provider
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return data;	
	}

}
