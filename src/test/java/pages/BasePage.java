package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Classe criada para ser chamada em cada inicio das classes de Page
 */

public class BasePage {
	protected WebDriver navegador;

	public BasePage(WebDriver navegador) {
		this.navegador = navegador;
	}

	public String CapturaTextoToasted() {
		return navegador.findElement(By.id("toast-container")).getText();

	}
	
}
