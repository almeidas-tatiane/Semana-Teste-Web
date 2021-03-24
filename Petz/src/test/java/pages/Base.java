package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
	
	protected WebDriver driver;
	
	public Base (WebDriver driver) { // construtor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
