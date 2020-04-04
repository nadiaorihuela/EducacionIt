package Edit.EducacionIt;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	@Test
	public void lab2_E1(){
		WebDriver driver= new ChromeDriver();
		//Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver","..\\Drivers\\chromedriver.exe");
		//Ir a url
		driver.get("https://www.facebook.com/");
		
		//Defino variable para espera explicita antes de asignar Elemento
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		
		//Nombre de usuario
		WebElement txtNombre=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("firstname"))));
				txtNombre.sendKeys("Moni");
		//Apellido de usuario
		WebElement txtApe=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='u_0_o']"))));
		txtApe.sendKeys("Argento");
		
		//Email o telefono
		WebElement txtMailTel=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("reg_email__"))));
		txtMailTel.sendKeys("dasdasdasd");
		
		//Contraseña
		WebElement txtContrasena=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("u_0_w"))));
		txtContrasena.sendKeys("12345678");
		
		//Desplegable Mes
		Select dropMes=new Select(myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("month")))));
		dropMes.selectByValue("5");
		
		//Radio Sexo
		WebElement radSex=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@type,'radio') and @value=1 ]"))));
		radSex.click();
		
		//Boton Registrar
		WebElement btnRegistrar=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[text()='Registrarte'])[1]"))));
		btnRegistrar.click();
		
	}

		
}
