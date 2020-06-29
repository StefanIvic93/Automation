package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementState {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {

		driver = new ChromeDriver();
		baseUrl = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void test() {

		driver.get(baseUrl);

		WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
		System.out.println("The element is enabled: " + element.isEnabled());

		element.sendKeys("lets kode it");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		Thread.sleep(3000);
	}
}
