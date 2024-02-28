package com.javaPractice.javaPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class MatchTableDatas {
	@Test
	public void matchTableDatasTest() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\MatchTableDatas.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<=lastRow;i++) {
			boolean flag=true;
			long data1 = (long) sheet.getRow(i).getCell(0).getNumericCellValue();
			//System.out.println(data1);
			for(int j=1;j<lastRow;j++) {
				long data2 = (long) sheet.getRow(j).getCell(1).getNumericCellValue();
				if(data1==data2) {
					//System.out.println("Common: "+data1);
					flag=false;
				}
			}
			if(flag) {
				System.out.println("Uncommon: "+data1);
			}
			else{
				System.out.println("Common: "+data1);
			}
		}
	}

}
