package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {
	
		public static WebDriver createChrome(){
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.get(
				"https://demo.suiteondemand.com/index.php?action=Login&module=Users");
		navegador.manage().window().maximize();
		return navegador;
		
	}
		public WebDriver createFirefox() {
			System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			WebDriver navegador = new FirefoxDriver();
			navegador.get(
					"https://demo.suiteondemand.com/index.php?action=Login&module=Users");
			navegador.manage().window().maximize();
			return navegador;
		}

}
