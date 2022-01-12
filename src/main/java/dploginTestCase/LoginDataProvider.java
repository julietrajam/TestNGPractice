package dploginTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDataProvider {
	
	String data[][] = {
			{"Admin","admin123"},
			{"Admin123","admin1232"},
			{"Admin","admin1234"},
			{"Admin123","admin123"}
	};

	@DataProvider(name="loginData")
	public String[][] loginDataProvider()
	{
		return data;
	}
	
	@Test(dataProvider="loginData")
	public void loginWithDifferentData(String uname,String pword)
	{
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	WebElement username=driver.findElement(By.id("txtUsername"));
	username.sendKeys(uname);
	
	WebElement pwd=driver.findElement(By.id("txtPassword"));
	pwd.sendKeys(pword);
	
	
	WebElement btn=driver.findElement(By.id("btnLogin"));
	btn.click();
	driver.quit();
	}
}
