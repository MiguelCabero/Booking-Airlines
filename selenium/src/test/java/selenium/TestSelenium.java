package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelenium {

	public ChromeDriver driver;

	@BeforeClass
	void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(2));
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	/*
	 * @BeforeMethod void open() {
	 * 
	 * }
	 */

	@Test(priority = 0)
	void selectCities() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/div/div/div[3]/button"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[1]/div/div[6]/button"))
				.click();

		final String originCity = driver
				.findElement(By.xpath("//*[@id=\"trip-origin\"]"))
				.getDomAttribute("value");
		final String destinationCity = driver
				.findElement(
						By.xpath("//*[@id=\"trip-destination\"]"))
				.getDomAttribute("value");

		Thread.sleep(3000);

		AssertJUnit.assertEquals(originCity, "Seville");
		AssertJUnit.assertEquals(destinationCity, "Rome");
	}

	@Test(priority = 1)
	void selectBadDate() throws InterruptedException {

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[1]/div[4]/label"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.id("trip-date")).sendKeys("01/11/2022");

		final String errorMessage = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[1]/div[2]/span"))
				.getText();

		Thread.sleep(3000);

		AssertJUnit.assertEquals(errorMessage,
				"La fecha no puede ser nula ni anterior a la actual");
	}

	@Test(priority = 2)
	void selectDate() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.id("trip-date")).clear();
		driver.findElement(By.id("trip-date")).sendKeys("14/11/2022");

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[2]/input"))
				.click();

		final String companyName = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div/div[1]/input"))
				.getDomAttribute("value");

		Thread.sleep(3000);

		AssertJUnit.assertEquals(companyName, "Iberia");
	}

	@Test(priority = 3)
	void filterFligth() throws InterruptedException {

		final Select airlineSelect = new Select(driver.findElement(
				By.xpath("//*[@id=\"company-filter\"]")));

		final Select dateSelect = new Select(driver
				.findElement(By.xpath("//*[@id=\"date-filter\"]")));

		airlineSelect.selectByVisibleText("Iberia");

		dateSelect.selectByVisibleText("2022-11-11");

		Thread.sleep(3000);
		final WebElement results = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/div[2]/form"));

		final List<WebElement> childs = results
				.findElements(By.xpath("./child::*"));

		AssertJUnit.assertEquals(childs.size(), 2);

		Thread.sleep(3000);

	}

	@Test(priority = 4)
	void selectFlight() throws InterruptedException {

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/div[2]/form/input"))
				.click();

		Thread.sleep(3000);
		final String price = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[2]/div[2]/p/b"))
				.getText();

		AssertJUnit.assertTrue(price.contains("306"));

	}

	@Test(priority = 5)
	void changePassengersPriceUpdate() throws InterruptedException {

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[2]/div[1]/button"))
				.click();

		Thread.sleep(3000);
		final String price = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[3]/div[2]/p/b"))
				.getText();

		AssertJUnit.assertTrue(price.contains("612"));

	}

	@Test(priority = 6)
	void clickInfoshowsInfo() throws InterruptedException {

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a"))
				.click();

		Thread.sleep(3000);
		final String title = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div/h1"))
				.getText();

		AssertJUnit.assertEquals(title, "About Solera flights™");

	}

	@Test(priority = 7)
	void windowReloadKeepsState() throws InterruptedException {

		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a"))
				.click();

		driver.navigate().refresh();
		Thread.sleep(3000);
		final String price = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[1]/form/div[3]/div[2]/p/b"))
				.getText();

		AssertJUnit.assertTrue(price.contains("612"));

	}

	/*
	 * @Test(priority = 1) void lambdaError() throws InterruptedException {
	 * driver.findElement(By.xpath("//*[@id=\"email\"]"))
	 * .sendKeys("User@hola.com");
	 * driver.findElement(By.xpath("//*[@id=\"password\"]"))
	 * .sendKeys("rpigjeioj5565");
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"login-button\"]")) .click();
	 * 
	 * Thread.sleep(10000);
	 * 
	 * Assert.assertEquals(driver.findElement(By.xpath(
	 * "/html/body/div[1]/div[1]/div/div/div/div[1]/div/form/div[1]/p")) .getText(),
	 * "Please enter a correct username and password. Note that the password is case-sensitive"
	 * ); }
	 * 
	 * @Test(priority = 2) void loginSuccess() throws InterruptedException {
	 * driver.findElement(By.xpath("//*[@id=\"email\"]"))
	 * .sendKeys("leonangelitg@gmail.com");
	 * driver.findElement(By.xpath("//*[@id=\"password\"]"))
	 * .sendKeys("BananaPrueba!123");
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"login-button\"]")) .click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"profile__dropdown\"]")) .click();
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"profile__dropdown__parent\"]/div/a[2]")) .click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"profile-panel\"]/div[2]/div[1]/div/form/div[2]/input"))
	 * .sendKeys(" GUAPO // HANDSOME"); Thread.sleep(8000);
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"profile-panel\"]/div[2]/div[1]/div/form/div[4]/button")) .click();
	 * 
	 * driver.findElement( By.xpath("//*[@id=\"left_sidebar_header\"]/div[1]/a"))
	 * .click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * Assert.assertEquals( driver.findElement(By.xpath("//*[@id=\"user-name\"]"))
	 * .getText(), "Leonardo GUAPO // HANDSOME");
	 * 
	 * }
	 */

}
