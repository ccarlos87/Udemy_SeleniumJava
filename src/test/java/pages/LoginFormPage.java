package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//montagem de maneira estrutural

public class LoginFormPage extends BasePage {

	public LoginFormPage(WebDriver navegador) {
		super(navegador);

	}

	public LoginFormPage digitaLogin(String login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		return this;
	}

	public LoginFormPage password(String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");
		return this;
	}

	public SecretaPage clicarNoSignIn() {
		navegador.findElement(By.linkText("SIGN IN")).click();

		return new SecretaPage(navegador);
	}

//montagem de maneira funcional
	/*public SecretaPage fazerLogin(String login, String senha) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);
		navegador.findElement(By.linkText("SIGN IN")).click();

		return new SecretaPage(navegador);
	}*/
	
	
//montagem de maneira mesclada entre estruturada e funcional
	public SecretaPage fazerLogin(String login, String senha) {
		digitaLogin(login);
		password(senha);
		clicarNoSignIn();
		
		return new SecretaPage(navegador);
	}
}
