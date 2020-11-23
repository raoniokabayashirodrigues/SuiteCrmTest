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
import page.EditarTaskPage;
import page.LoginPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\massaTests\\DadosParaEdicao.csv")

public class editarTaskTest {

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
		task.preencherCamposCreateTask("TESTE EDITAR");
		assertEquals("TESTE EDITAR", task.capturarTituloTask());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		navegador.quit();
	}

	//@Test
	public void editarTaskTest(@Param(name="subject")String Subject, @Param(name="newSubject")String newSubject) {
		EditarTaskPage editar = new EditarTaskPage(navegador);
		editar.acessarTasks();
		editar.localizarTask(Subject);
		editar.acessarEdicao();

		String screenshotArquivoAntes = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\screenshots" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivoAntes );

		editar.alterarSubjectTask(newSubject);
		assertEquals(newSubject.toUpperCase(), editar.capturarTituloTask());

		String screenshotArquivoDepois = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\screenshots" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivoDepois );

		editar.acessarTasks();
		editar.limparFiltro();
	}

	@Test
	public void editarCamposTodosTest(@Param(name="subject")String Subject,
									  @Param(name="newSubject")String newSubject,
									  @Param(name="status")String NewStatus,
									  @Param(name="newRelatedTo")String newRelatedTo,
									  @Param(name="newPriority")String newPriority) {
		
		EditarTaskPage editar = new EditarTaskPage(navegador);
		editar.acessarTasks();
		editar.localizarTask(Subject);
		editar.acessarEdicao();
		
		String screenshotArquivoAntes = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java" +
				"\\screenshots\\" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivoAntes );
		
		editar.alterarCamposTodos(newSubject,NewStatus,newRelatedTo,newPriority);
		
		assertEquals(newSubject.toUpperCase(), editar.capturarTituloTask());
		assertEquals(NewStatus, editar.capturarStatusTask());
		
		String screenshotArquivoDepois = "C:\\Users\\Administrador\\IdeaProjects\\EverisTest\\src\\main\\java\\screenshots" +Generator.dataHoraParaArquivo()
		+ test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivoDepois );
		
		editar.acessarTasks();
		editar.limparFiltro();
	}

}
