package basicweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfElements {

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
	public void test() throws Exception {

		boolean isSelected = false;
		List<WebElement> element = driver
				.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));

		System.out.println("Size of the list is: " + element.size());
		for (int i = 0; i < element.size(); i++) {
			isSelected = element.get(i).isSelected();

			if (!isSelected) {
				element.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	@Test
	public void test2() throws Exception {
		boolean isChecked = false;
		List<WebElement> radioButton = driver
				.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));

		for (int i = 0; i < radioButton.size(); i++) {
			isChecked = radioButton.get(i).isSelected();

			if (!isChecked) {
				radioButton.get(i).click();
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("The chrome has been closed.");
	}
}
