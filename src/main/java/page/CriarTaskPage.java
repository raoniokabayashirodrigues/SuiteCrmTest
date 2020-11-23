package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CriarTaskPage extends NavegarPage{
	static WebDriver driver;

	public CriarTaskPage(WebDriver driver) {
		super(driver);
		CriarTaskPage.driver = driver;
	}
	
	public void acessarCreateTask() {
		
		
		WebElement menuCreate = driver.findElement(By.xpath("//*[@class=\"desktop-bar\"]/ul/li/a"));
		menuCreate.click();
		
		WebElement opcaoCreate = driver.findElement(By.xpath("//*[@class=\"desktop-bar\"]/ul/li/ul/li[7]/a"));
		opcaoCreate.click();
	}
	
	public void preencherCamposCreateTask(String Subject) {
		
		WebElement campoSubject = driver.findElement(By.id("name"));
		campoSubject.sendKeys(Subject);

		Select StatusSelect = new Select(driver.findElement(By.name("status")));
		StatusSelect.selectByVisibleText("Pending Input");

		WebElement btnSave = driver.findElement(By.xpath("//*[@class=\"buttons\"]/div/input[@id=\"SAVE\"]"));
		btnSave.click();
		
	}
		
}
