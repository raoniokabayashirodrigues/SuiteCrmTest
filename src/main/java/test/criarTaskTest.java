package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

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
import page.LoginPage;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\massaTests" +
		"\\DadosParaCadastro.csv")

public class criarTaskTest {
	
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
	public void createTasksTest(@Param(name="subject")String Subject) {
		CriarTaskPage task = new CriarTaskPage(navegador);

		navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

				task.acessarCreateTask();
				task.preencherCamposCreateTask(Subject);

				assertEquals(Subject.toUpperCase(), task.capturarTituloTask());
		
		String screenshotArquivo = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\screenshots" +
				"\\" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo );
		
	
	}

}
