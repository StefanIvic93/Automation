package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingBetweenPages {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {

		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void test() throws InterruptedException {

		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL address is: " + currentUrl);

		String urlToNavigate = "https://letskodeit.teachable.com/courses";
		driver.navigate().to(urlToNavigate);
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL address is: " + currentUrl);

		driver.navigate().back();
		System.out.println("Navigating back");
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL address is: " + currentUrl);

		driver.navigate().forward();
		System.out.println("Navigating forward");
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL address is: " + currentUrl);

		driver.navigate().back();
		System.out.println("Navigating back");
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL address is: " + currentUrl);

		driver.navigate().refresh();
		System.out.println("Refreshing the page");
		Thread.sleep(2000);
		driver.get(currentUrl);
		System.out.println("Refreshing the page again");
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
