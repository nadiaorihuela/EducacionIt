package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory; 

public class paginaInicio {
	
    WebDriver driver;
  //Todos los elementos se identifican con la anotación @FindBy
    @FindBy(xpath="//*[@class='login']")
    WebElement btnLogin;

    
    
    public paginaInicio(WebDriver driver){
       this.driver = driver;
       //Inicializa los elementos con una espera implicita
       PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
    }

    public void clickLogin(){
            btnLogin.click();
    }  


    public String getLoginText(){
    	return btnLogin.getText();
    }

} 
