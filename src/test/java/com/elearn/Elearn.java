package com.elearn;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Elearn {
	public static String getData(int row, int cell) throws Exception {
		
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Frames\\InputSheet\\TestData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		
		Row r = s.getRow(row); Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		System.out.println(cellType);
		
		String value = null;
		
		if (cellType==1) { value = c.getStringCellValue();
			System.out.println(value);}
		else if (cellType==0) { if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			System.out.println(dateCellValue);
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			value = sim.format(dateCellValue);
			System.out.println(value);
			} else { double numericCellValue = c.getNumericCellValue();
				long l =  (long) numericCellValue;
				value = String.valueOf(l);
				System.out.println(value);
				}}
		return value;}}			
				
				

			
		
		
		
		
		
		
		
		
		
		
		
		
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(1);
//		System.out.println(cell);

