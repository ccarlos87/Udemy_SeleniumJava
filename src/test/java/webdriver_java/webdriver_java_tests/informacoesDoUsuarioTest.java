package webdriver_java.webdriver_java_tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.generator;
import suporte.screenshot;

//apontar a classe/biblioteca de testes do easy test
@RunWith(DataDrivenTestRunner.class) // não esquecer de colocar sempre o .class no final

//filePaths = são os arquivos que armazenaram os dados para os testes
//esse arquivo é gerado no diretório test
@DataLoader(filePaths = "testAdicionarUmaInformacaoDoUsuario.csv")

public class informacoesDoUsuarioTest {
	private WebDriver navegador;

	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp() {
		// Setando as configurações para abrir o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		navegador = new ChromeDriver();
		// Setando o tempo de aguardo para as ações que possam ter timeout
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// abrindo o site
		navegador.get("http://www.juliodelima.com.br/taskit/");

		// clicando no botão de SignIn
		navegador.findElement(By.linkText("Sign in")).click();
		// Identificando o formulário de SignIn como um Elemento na tela
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		// Digitar no campo login
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		// Digitar no campo senha
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		// Clicar no Login
		formularioSignInBox.findElement(By.linkText("SIGN IN")).click();
		// Clicar no link que possue a class me
		navegador.findElement(By.className("me")).click();
		// Clicar no link que possue o texto "More data about you"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	@Test
	public void testAdicionarUmaInformacaoDoUsuario(@Param(name = "tipo") String tipo,	@Param(name = "contato") String contato, @Param(name = "mensagem") String mensagemEsperada) {

		// Clicar no botão através do seu xpath
		navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();
		// Identificar a popup do formulário de addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		// Na combo de name "type" escolher a opção "phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		// No campo de name "contact" digitar um numero qualquer
		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
		// Clicar link de text "Save" que está na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		// Validar mensagem de de "adicionado"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals(mensagemEsperada, mensagem);

	}

//	@Test
	public void testRemoverUmContatoDeUsuario() {
		// Clicar no elemento pelo xpath:
//		navegador.findElement(By.xpath("//span[text()='11234566566']/following-sibling::a")).click();
		navegador.findElement(By.xpath("//div[@id='moredata']//ul/li[1]//following-sibling::a")).click();
		// Confirmar na janela javascript
		navegador.switchTo().alert().accept(); // confirmar o OK numa janela de confirmação
		// Validar mensagem apresentada
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);

//		//tirando screenshot de evideoncia para a linha de código acima
		String screenshotArquivo = "C:/Users/calfredo/Desktop/Teste_SS/" + generator.dataHoraParaArquivo()
				+ test.getMethodName() + ".png";
		screenshot.tiraSS(navegador, screenshotArquivo);

		// Aguardar até 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		// Clicar no link de texto "Logout"
		navegador.findElement(By.linkText("Logout")).click();

	}

	@After
	public void tearDown() {
		// Fechar o navegador
//		navegador.quit();

	}

}
