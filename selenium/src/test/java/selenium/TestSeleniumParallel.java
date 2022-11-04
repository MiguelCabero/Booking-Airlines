package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSeleniumParallel {

	// public ChromeDriver driver;
	// public FirefoxDriver firefoxDriver;

	/*
	 * @BeforeClass void open() {
	 * 
	 * driver = WebDriverFactory.getInstance().getDriver(); // driver =
	 * WebDriverFactory.getInstance().getDriver();
	 * driver.get("https://www.google.com"); final WebElement element = driver
	 * .findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")); element.click();
	 * 
	 * }
	 * 
	 * @AfterMethod void back() { driver.navigate().back(); }
	 */

	/*
	 * @AfterMethod
	 * 
	 * void close() { firefoxDriver.close(); }
	 */

	// (dataProvider = "calc-data", dataProviderClass = TestData.class)

	@Test

	void calcTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		final WebDriver driver = new ChromeDriver();
		/*
		 * final WebDriver driver = WebDriverFactory.getInstance()
		 * .getDriver(SeleniumBrowserType.CHROME); // driver =
		 * WebDriverFactory.getInstance().getDriver();
		 */
		driver.get("https://www.google.com");
		final WebElement element = driver
				.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
		element.click();

		final WebElement input = driver.findElement(By.xpath(
				"html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		input.sendKeys("2+3");
		input.submit();

		final WebElement result = driver
				.findElement(By.xpath("//*[@id=\"cwos\"]"));

		Assert.assertEquals(result.getText(), "5");

		Thread.sleep(2000);
		driver.close();

	}

	@Test

	void sqrtTest() throws InterruptedException {

		String result = "";
		/*
		 * final WebDriver driver = WebDriverFactory.getInstance()
		 * .getDriver(SeleniumBrowserType.FIREFOX);
		 */
		WebDriverManager.firefoxdriver().setup();
		final WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(3));
		// driver = WebDriverFactory.getInstance().getDriver();
		driver.get("https://www.google.com");
		final WebElement element = driver
				.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
		element.click();

		final WebElement input = driver.findElement(By.xpath(
				"html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		input.sendKeys("sqrt 16");
		input.submit();

		final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@id=\"cwos\"]")));

		result = driver.findElement(By.xpath("//*[@id=\"cwos\"]"))
				.getText();

		Assert.assertEquals(result, "4");

		Thread.sleep(2000);

		driver.close();

	}

}
