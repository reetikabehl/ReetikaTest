package SeleniumReetikaTest.ReetikaTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebDriver driver;
//		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","/home/edureka/chromedriver");
		
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--headless"); // headless mode for jenkins
		driver = new ChromeDriver(chromeoptions);
		driver.manage().window().maximize();
		driver.get("http://localhost:3001/");

		String str;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("login")).sendKeys("devops");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.name("click")).click();
		str = driver.findElement(By.name("test")).getText();
//		System.out.println(str);
		assertEquals(str,"Login Succeeded");
		
		driver.close();
   }
}
