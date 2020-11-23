package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	static WebDriver navegador;

	public LoginPage(WebDriver navegador){
		this.navegador = navegador;
	}
	
	public void fazerLogin() {
		
		WebElement username = navegador.findElement(By.id("user_name"));
		username.sendKeys("will");
		
		WebElement password = navegador.findElement(By.id("username_password"));
		password.sendKeys("will");
		
		WebElement login = navegador.findElement(By.id("bigbutton"));
		login.click();
	}
	
}
