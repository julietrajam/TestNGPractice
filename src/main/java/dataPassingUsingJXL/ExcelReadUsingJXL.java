package dataPassingUsingJXL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReadUsingJXL {

	String data[][] = null;
	
	public ChromeDriver driver;

	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException
	{
		data=getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException
	{
		FileInputStream excel=new FileInputStream("C:\\E\\Book1.xls");
		
		Workbook workbook=Workbook.getWorkbook(excel);
		
		Sheet sheet=workbook.getSheet(0);
		
		int rowCount=sheet.getRows();
		int columnCount=sheet.getColumns();
		
		String testData[][]=new String[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				testData[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}
		return testData;
			}
		
	
	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
			
	
	@Test(dataProvider="loginData")
	public void loginWithDifferentData(String uname,String pword)
	{
	
	WebElement username=driver.findElement(By.id("txtUsername"));
	username.sendKeys(uname);
	
	WebElement pwd=driver.findElement(By.id("txtPassword"));
	pwd.sendKeys(pword);
	
	
	WebElement btn=driver.findElement(By.id("btnLogin"));
	btn.click();
	
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
}
