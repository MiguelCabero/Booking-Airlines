package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelenium {

	public ChromeDriver driver;

	@BeforeClass
	void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	void open() {
		driver.get("https://accounts.lambdatest.com");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@Test(priority = 0)
	void signUpFilling() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div/div/div/div[1]/div/div[3]/p/span/span[2]/a"))
				.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"name\"]"))
				.sendKeys("Leonardo Angelit Gálvez");
		driver.findElement(By.xpath("//*[@id=\"email\"]"))
				.sendKeys("leo63582@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userpassword\"]"))
				.sendKeys("PassPrueba2022!!");
		driver.findElement(By.xpath("//*[@id=\"phone\"]"))
				.sendKeys("611438270");

		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/samp"))
				.click();

		driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/button"))
				.click();

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	void lambdaError() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"email\"]"))
				.sendKeys("User@hola.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
				.sendKeys("rpigjeioj5565");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]"))
				.click();

		Thread.sleep(10000);

		Assert.assertEquals(driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div/div/div[1]/div/form/div[1]/p"))
				.getText(),
				"Please enter a correct username and password. Note that the password is case-sensitive");
	}

	@Test(priority = 2)
	void loginSuccess() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"email\"]"))
				.sendKeys("leonangelitg@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
				.sendKeys("BananaPrueba!123");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]"))
				.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"profile__dropdown\"]"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"profile__dropdown__parent\"]/div/a[2]"))
				.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//*[@id=\"profile-panel\"]/div[2]/div[1]/div/form/div[2]/input"))
				.sendKeys(" GUAPO // HANDSOME");
		Thread.sleep(8000);

		driver.findElement(By.xpath(
				"//*[@id=\"profile-panel\"]/div[2]/div[1]/div/form/div[4]/button"))
				.click();

		driver.findElement(
				By.xpath("//*[@id=\"left_sidebar_header\"]/div[1]/a"))
				.click();

		Thread.sleep(5000);

		Assert.assertEquals(
				driver.findElement(By.xpath("//*[@id=\"user-name\"]"))
						.getText(),
				"Leonardo GUAPO // HANDSOME");

	}

}
