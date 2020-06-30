package basicweb;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GenericTest {

	WebDriver driver;
	String baseUrl;
	GenericMethods gm;

	@Before
	public void setUp() throws Exception {

		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() {

		boolean result = gm.isElementPresent("name", "id");
		System.out.println("Is element present: " + result);
		
		boolean result2 = gm.isElementPresent("Something", "id");
		System.out.println("Is element present: " + result);
		
		boolean result3 = gm.isElementPresent("Somethingelse", "id");
		System.out.println("Is element present: " + result);
		
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("test");

		List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");

		int size = elementList.size();

		System.out.println("The size of the element list is: " + size);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
