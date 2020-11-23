package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import page.CriarTaskPage;
import page.DeletarPage;
import page.LoginPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\massaTests" +
		"\\DadosParaDelete.csv")

public class deletarTaskTest {
	
	static WebDriver navegador;
	static LoginPage loginPage;
	
	@Rule
	public TestName test = new TestName();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		navegador = Web.createChrome();
		loginPage = new LoginPage(navegador);
		loginPage.fazerLogin();		
	}
	@BeforeClass
	public static void createTasksTest() {
		CriarTaskPage task = new CriarTaskPage(navegador);
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		task.acessarCreateTask();
		task.preencherCamposCreateTask("TESTE DELETE");
		assertEquals("TESTE DELETE", task.capturarTituloTask());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		navegador.quit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deleteTaskTest(@Param(name="subject")String Subject) {
		DeletarPage deletarTask = new DeletarPage(navegador);
		navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		deletarTask.acessarTasks();
		deletarTask.localizarTask(Subject);
		deletarTask.deleteTask();
		//deletarTask.localizarTask();
		deletarTask.capturarMensagemNoResults();
		
		String screenshotArquivo = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\screenshots" +
				"\\" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo);
		
		deletarTask.limparFiltro();
	}

}
