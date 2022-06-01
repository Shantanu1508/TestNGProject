package com.SauceDemo.POMClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityPOMClass {
	
	
	private static TakesScreenshot ts;
	private static File source, destination;
	private static Date dt;
	private static String title, date;
	
	static String[] loginData;
	
	
	private static   FileInputStream file;
	private static XSSFWorkbook book;
	
	
	public static void screenshot(WebDriver driver) throws InterruptedException, IOException {
				
		Thread.sleep(5000);
		dt = new Date();
		date = new SimpleDateFormat("MM-dd-yy & HH-mm-ss").format(dt);
		
		//To get Title of the current page		
		 title = driver.getTitle();
		 
		 ts = (TakesScreenshot)driver;
		 source = ts.getScreenshotAs(OutputType.FILE);
		 destination = new File("D:\\Java Testing Project\\Java Screenshots\\SauceDemo\\"+title+"_"+date+".jpg");
		 FileHandler.copy(source, destination);
		
		 System.out.println("Screenshot if taken from "+title+" page");
		
	}
	
	public static String[] parameterization() throws IOException {
		
		System.out.println("Parameterization method is called");
		
		file = new FileInputStream("D:\\Java Testing Project\\Excel Sheet Project\\Java Excel Sheet.xlsx");
		book = new XSSFWorkbook(file);
		loginData = new String[2];
		
		loginData[0] = book.getSheet("Java Excel").getRow(2).getCell(3).getStringCellValue();
		
		loginData[1] = book.getSheet("Java Excel").getRow(3).getCell(3).getStringCellValue();
				
		return loginData;
	}
		
}
