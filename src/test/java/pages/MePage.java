package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

	public MePage(WebDriver navegador) {
		super(navegador);

	}

	public MePage clicarMe() {
		navegador.findElement(By.className("me")).click();

		return this;

	}

	public MePage clicarNaAbaMoreDataAboutYou() {
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		return this;
	}

	public AddContatoPage clicarNoBotaoAddMoreDataAboutYou() {
		navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

		return new AddContatoPage(navegador);

	}

}
