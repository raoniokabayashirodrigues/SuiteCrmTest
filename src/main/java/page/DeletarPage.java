package page;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;


public class DeletarPage extends NavegarPage{

	static WebDriver driver;
	
	@Rule
	public TestName test = new TestName();
	
	public DeletarPage(WebDriver driver) {
		super(driver);
		DeletarPage.driver = driver;
		//TODO Auto-generated constructor stub
	}
	
	public void deleteTask() {
		WebElement opcaoAction = driver.findElement(By.xpath("//ul[@id=\"actionLinkTop\"]/li/a/label[@class=\"selected-actions-label hidden-desktop\"]"));
		opcaoAction.click();
		WebElement opcaoDelete = driver.findElement(By.xpath("//li[3]/a[@id=\"delete_listview_top\"]"));
		opcaoDelete.click();

		driver.switchTo().alert().accept();
	}
	
	public String capturarMensagemNoResults() {
		WebElement noResults = driver.findElement(By.xpath("//p[contains(text(), 'No results found for')]"));
		return noResults.getText();
		
	}
	
	
}
