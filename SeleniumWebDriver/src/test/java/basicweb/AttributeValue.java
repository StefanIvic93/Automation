package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeValue {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {

		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}

	@Test
	public void test() {

		WebElement findValueElement = driver.findElement(By.id("name"));
		String att = findValueElement.getAttribute("type");
		System.out.println(att);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		System.out.println("The chrome has been closed.");

	}
}
