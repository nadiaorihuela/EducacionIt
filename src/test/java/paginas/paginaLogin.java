package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory; 

public class paginaLogin {

	/* Todos los elementos se identifican con la anotación @FindBy  */

    WebDriver driver;

    @FindBy(id="email_create")
    WebElement txtUser;

    @FindBy(id="SubmitCreate")
    WebElement btnCreate;
    
    @FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
    WebElement titleForm;
    
    public paginaLogin(WebDriver driver){

        this.driver = driver;

        //Inicializa los elementos con una espera implicita

        PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);

    }
    
    public void sendKeysEmail(String user){
    	txtUser.clear();
    	txtUser.sendKeys(user);
    }
    
    public void clickCreate(){
    	btnCreate.click();
    }
    
    public String getTextTitleForm() {
    	return titleForm.getText();
    }
}