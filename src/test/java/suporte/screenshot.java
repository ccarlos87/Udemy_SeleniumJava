package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenshot {
	public static void tiraSS(WebDriver navegador, String arquivo) {
		File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(arquivo));
		} catch (Exception e) {
			System.out.println("Houveram problemas ao copiar arquivo para a pasta: " + e.getMessage());
		}
	}

}
