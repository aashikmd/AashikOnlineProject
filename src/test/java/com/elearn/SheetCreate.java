package com.elearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SheetCreate {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Frames\\InputSheet\\Test2.xlsx");
		FileInputStream fi = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fi);
		
		Sheet st = w.createSheet("Test");
		
		Row r = st.createRow(0);
		Cell c = r.createCell(0); c.setCellValue("Name");
		Cell c1 = r.createCell(1); c1.setCellValue("Phone");
		Cell c4 = r.createCell(2); c4.setCellValue("Address");
		
		Row r1 = st.createRow(1);
		Cell c2 = r1.createCell(0); c2.setCellValue("Aashik");
		Cell c3 = r1.createCell(1); c3.setCellValue("123456789");
		Cell c5 = r1.createCell(2); c5.setCellValue("Chennai");
		
		
		FileOutputStream op = new FileOutputStream(f);
		w.write(op);
		
		System.out.println("Sheet Created");
		
		
		
	}
}
