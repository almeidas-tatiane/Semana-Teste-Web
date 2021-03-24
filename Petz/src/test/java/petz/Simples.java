// 1. Nome do pacote
package petz;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
//2. Bibliotecas importadas
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



// 3. Classe
public class Simples {
	// 3.1 Atributos
	String url;       // endereço do site alvo
	WebDriver driver; // objeto do Selenium WebDriver
	
	
	
	
	// 3.2 Métodos ou Funções
	
	@Before // Antes do teste
	public void iniciar() {
		url = "https://www.petz.com.br"; // endereço da Petz
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\ChromeDriver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximizar a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // espera implicita de 30 segundos
	}
	
	@After // Depois do teste
	public void finalizar() {
		driver.quit();
	}
	
	@Test // O teste
	public void abrirPagina() {
		driver.get(url); // abrir a pagina inicial do site Petz
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle()); // validou o texto da guia da pagina
	}
	

}
