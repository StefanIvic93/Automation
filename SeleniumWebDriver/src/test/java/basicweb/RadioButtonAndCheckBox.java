package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonAndCheckBox {

	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		bmwRadioButton.click();
		Thread.sleep(3000);
		
		WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
		benzRadioButton.click();
		Thread.sleep(3000);
		
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		bmwCheckBox.click();
		Thread.sleep(3000);
		
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		benzCheckBox.click();
		Thread.sleep(3000);
		
		System.out.println("BMW Radio is selected: " + bmwRadioButton.isSelected());
		System.out.println("BMW Checkbox is selected: " + bmwCheckBox.isSelected());
		System.out.println("Benz Radio is selected: " + benzRadioButton.isSelected());
		System.out.println("Benz Checkbox is selected: " + benzRadioButton.isSelected());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		System.out.println("Closing the Chrome now...");
	}

}
