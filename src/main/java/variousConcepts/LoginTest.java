package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	public class Logintest4 {
		String browser= "CHROME";
		WebDriver driver;
		By USERNAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGNIN_FIELD = By.xpath("/html/body/div[1]/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(),' Dashboard') ]");

		@BeforeMethod
		public void init() {
			if (browser.equalsIgnoreCase("chrome")) {
					
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else {
				System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}


			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@Test
		public void loginTest() {
			driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
			driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
			driver.findElement(SIGNIN_FIELD).click();
			Assert.assertEquals(driver.findElement(DASHBOARD_HEADER_FIELD).getText(), "Dashboard",
					"Dashboard page not found");
		}

		@AfterMethod
		public void teardown() {
			driver.close();
			driver.quit();
		}

	}
}
