package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavegarPage {
	
static WebDriver driver;
	
	public NavegarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acessarTasks() {
		WebElement menuActivies = driver.findElement(By.id("grouptab_3"));
		menuActivies.click();
		WebElement opcaoActivies = driver.findElement(By.id("grouptab_3"));
		opcaoActivies.click();
		driver.findElement(By.linkText("Tasks")).click();
		
	}

	public void localizarTask(String Subject) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//thead/*[@id=\"pagination\"]/td/table/tbody/tr/td[1]/ul[3]/li/a"))));
		
		WebElement filtro = driver.findElement(By.xpath("//thead/*[@id=\"pagination\"]/td/table/tbody/tr/td[1]/ul[3]/li/a"));
		filtro.click();

		WebElement subject = driver.findElement(By.id("name_basic"));
		subject.sendKeys(Subject);
		
		WebElement btnSearch = driver.findElement(By.id("search_form_submit"));
		btnSearch.click();
		
		WebElement taskLocalizado = driver.findElements(By.xpath("//tbody/tr[@class=\"oddListRowS1\"]/td/input")).get(0);
		taskLocalizado.click();
	}
	
	public void limparFiltro() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@class=\"sugar_action_button desktopOnly\"]/a[2]"))));
		WebElement cleanFiltro = driver.findElement(By.xpath("//li[@class=\"sugar_action_button desktopOnly\"]/a[2]"));
		cleanFiltro.click();
	}
	
	public String capturarTituloTask() {
		WebElement tituloTask = driver.findElement(By.className("module-title-text"));
		
		return  tituloTask.getText();
	}
	
	public String capturarStatusTask() {
		WebElement statusEditado = driver.findElement(By.cssSelector("div[field='status']"));
		
		return  statusEditado.getText();
	}

}
