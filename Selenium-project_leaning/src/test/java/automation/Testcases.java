package automation;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Testcases {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver(); 
	driver.get("https://demoqa.com/webtables");
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    
	}
	
	@Test(priority=1)
	 public void automateWebTable() {
        // Capture all rows of the table
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
        
        // Loop through each row and print the cell data
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println(); // Print a new line for each row
        }	}

	
	
	

	@AfterTest
	public void teardown() {
		
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	
	
}
