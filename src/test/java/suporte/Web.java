package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * Todas as configurações do broswer e navegador são listadas nesta classe
 */
public class Web {

	public static WebDriver createChrome() {
		// Setando as configurações para abrir o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		// Setando o tempo de aguardo para as ações que possam ter timeout
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// abrindo o site
		navegador.get("http://www.juliodelima.com.br/taskit/");

		return navegador;
	}

}
