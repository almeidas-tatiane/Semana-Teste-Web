package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.FindBy;

public class Lista extends Base {
	//@FindBy(xpath = "//h3[contains(text(),'Coleira Petz Azul para Cães')]") //só funciona para texto fixo
	//private  WebElement produtoDesejado;
	
	//@FindBy(xpath = "/html[1]/body[1]/div[10]/div[2]/div[2]/div[2]/div[1]/h1[1]")
	//private WebElement cabecalhoResultado;
	
	
	public Lista(WebDriver driver) {
		super(driver);
		
	}
	
	public void clicarNoProduto(String produto) {
		//produtoDesejado.click();
		WebElement produtoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'" + produto + "')]"));
		produtoDesejado.click();
		
	}
	
	public String lerCabecalhoResultados() {
		WebElement cabecalhoResultado  = driver.findElement(By.cssSelector("h1.h2Categoria.nomeCategoria"));
		return cabecalhoResultado.getText();
		
		
	}
	
}
