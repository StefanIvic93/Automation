package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EONUserLogin {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {

		baseUrl = "https://eon.tv/";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(baseUrl);

	}

	@Test
	public void test() throws Exception {

		Thread.sleep(1000);
		WebElement findValueElement = driver
				.findElement(By.xpath("//*[@id=\"mainHeader\"]/div/section/div/nav[2]/a[2]"));
		findValueElement.click();
		
		Thread.sleep(1000);

		WebElement clickOnDropdownLanguage = driver
				.findElement(By.xpath("//div[@class='dropdown is-selected']//p[@class='selected']"));
		clickOnDropdownLanguage.click();

		Thread.sleep(1000);
		
		WebElement forSelectLanguage = driver.findElement(By.xpath("//span[contains(text(),'English')]"));
		forSelectLanguage.click();

		Thread.sleep(1000);

		WebElement clickOnDropdown = driver
				.findElement(By.xpath("//div[@class='dropdown placeholder']//p[@class='selected']"));
		clickOnDropdown.click();

		Thread.sleep(1000);
		
		WebElement forSelectProvider = driver.findElement(By.xpath("//span[contains(text(),'SBB')]"));
		forSelectProvider.click();

		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("user_name"));
		username.clear();

		Thread.sleep(1000);

		WebElement password = driver.findElement(By.id("user_password"));
		password.clear();
		password.sendKeys("SBBMoj321123");

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@class='btn-1']")).click();

		Thread.sleep(1000);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		System.out.println("The chrome has been closed.");

	}
}
