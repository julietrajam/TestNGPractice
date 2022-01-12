package loginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BothIncorrect {

	@Test
	@Parameters({"username","password"})
	public void loginWithInCrctUsernameInCrctPassword(String uname,String pword)
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
