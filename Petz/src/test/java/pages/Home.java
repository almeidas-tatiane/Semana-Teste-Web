package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Base {
	
	// Atributos
	// Caixa de Pesquisa
	@FindBy(id = "search")
	private WebElement busca;

	// Construtor
	public Home (WebDriver driver) {
		super(driver);
	}
	
	
	// Metodos ou Funçoes
	
	public void buscarProdutoComEnter(String produto) {
		busca.clear();
		busca.sendKeys(produto + Keys.ENTER);
	}

}
