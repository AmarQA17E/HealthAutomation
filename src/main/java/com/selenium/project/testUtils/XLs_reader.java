package com.selenium.project.testUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XLs_reader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\SelJavaInterview\\newHealth\\testUtils\\ExcelWorkbook.xlsx");
		System.out.println(fis);
	   
	}
	
}
