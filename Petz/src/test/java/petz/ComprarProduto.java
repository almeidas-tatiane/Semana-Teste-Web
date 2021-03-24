package petz;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;

public class ComprarProduto {
	
	String url;       // endereço do site alvo
	WebDriver driver; // objeto do Selenium WebDriver
	
	Home home; // objeto home herdando a classe Home
	Lista lista;
	
	
	@Before // Antes do teste
	public void iniciar() {
		url = "https://www.petz.com.br"; // endereço da Petz
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\ChromeDriver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximizar a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // espera implicita de 30 segundos
		
		home = new Home(driver); // Instanciar a classe Home
		lista = new Lista(driver);
	}
	
	@After // Depois do teste
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que acesso o site Petz$")
	public void que_acesso_o_site_Petz() {
		driver.get(url); // abrir a pagina inicial do site Petz
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle()); // validou o texto da guia da pagina
		System.out.print("Passo 1");
	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto) {
	    home.buscarProdutoComEnter(produto);
	    System.out.print("Passo 2");
	}

	@Entao("^exibe uma lista de produtos relacionados com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"",lista.lerCabecalhoResultados());
	    System.out.print("Passo 3");
	    
	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto) {
		lista.clicarNoProduto(produto);
		System.out.print("Passo 4");
	}

	@Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
	public void exibe_para_o_o_preco_de(String arg1, String arg2) {
		System.out.print("Passo 5");
	}

}
