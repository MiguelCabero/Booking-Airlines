package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public static final WebDriverFactory instance = new WebDriverFactory();

	private WebDriverFactory() {

	}

	public static WebDriverFactory getInstance() {
		return instance;
	}

	private static ThreadLocal<WebDriver> provider = new ThreadLocal<WebDriver>();

	public WebDriver getDriver(SeleniumBrowserType type) {
		if (provider.get() == null) {
			switch (type) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				provider.set(new ChromeDriver());
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				provider.set(new FirefoxDriver());
				break;

			default:
				break;
			}
		}
		return provider.get();
	}

}
