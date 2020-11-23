package page;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditarTaskPage extends NavegarPage {
	static WebDriver driver;
	
	public EditarTaskPage(WebDriver driver) {
		super(driver);
		EditarTaskPage.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void acessarEdicao() {
		WebElement taskEdit = driver.findElement(By.cssSelector("span[class='suitepicon suitepicon-action-edit']"));
		taskEdit.click();
	}
	
	public void alterarSubjectTask(String newSubject) {
		WebElement taskSubject = driver.findElement(By.id("name"));
		taskSubject.clear();
		taskSubject.sendKeys(newSubject);
		
		WebElement btnSave = driver.findElement(By.xpath("//*[@class=\"buttons\"]/div/input[@id=\"SAVE\"]"));
		btnSave.click();
	}
	
	public void alterarCamposTodos(String newSubject, String newStatus, String newRelatedTo, String newPriority ) {
		WebElement taskSubject = driver.findElement(By.id("name"));
		taskSubject.clear();
		taskSubject.sendKeys(newSubject);
		
		Select status = new Select(driver.findElement(By.id("status")));
		status.selectByValue(newStatus);
		
		Select relatedTo = new Select(driver.findElement(By.id("parent_type")));
		relatedTo.selectByValue(newRelatedTo);
		
		Select priority = new Select(driver.findElement(By.id("priority")));
		priority.selectByValue(newPriority);
		
		WebElement btnSave = driver.findElement(By.xpath("//*[@class=\"buttons\"]/div/input[@id=\"SAVE\"]"));
		btnSave.click();
	}

}
