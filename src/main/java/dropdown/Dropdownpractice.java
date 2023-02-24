package dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownpractice {

	public static void main(String[]srgs) {
		
		      System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver();
		 driver.get("http:facebook.com");
	}
	
	
	
}
