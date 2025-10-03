package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home_page {
	WebDriver driver;
	
	
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.headshotphoto.io/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void check() throws InterruptedException {
		driver.findElement(By.linkText("Generate Headshots")).click();	
		Thread.sleep(3000);
	}
	
	
	
	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
		
	}

}
