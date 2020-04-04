package Edit.EducacionIt;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.*;



	/* Laboratorio 1 - Ejercicio1:
		-Crear un proyecto de Tipo Maven en eclipse con los siguientes datos:
		Group Id: Edit
		Artifact Id: EducacionIt
		Version: Por defecto
		Packaging: Por defecto:
		
		-Configurar proyecto para utilización de librerías de selenium agregando dependencias a archivo pom.xml.
		-Verificar dependencia Junit en archivo pom.xml
		-Abrir la clase AppTest.java que se genera automáticamente en la ruta src/test/java/Edit.EducacionIt e imprimir un “Hola mundo”
		-Correr Test y verificar resultado en consola y en Junit
		-Crear una nueva clase estándar con nombre Laboratorio1 e importar librerías de selenium y junit manualmente
		import org.junit.*;
		import org.openqa.selenium.*;
		-En la raíz del proyecto crear un Source folder con nombre Drivers
		-Descargar Driver de selenium para navegador Chrome y para Firefox y ubicarlo en la carpeta creada en el paso anterior (La versión del driver a descargar debe ser compatible con la versión del navegador en cuestión).
		-Volver a la clase creada y crear un test ingresando el comando @Test debajo de esta crear un método llamado lab1_E1.
		-Importar librerías de controlador Chrome import org.openqa.selenium.chrome.ChromeDriver;
		-Codificar dentro del método e Instanciar chrome Driver
		-Codificar la configuración de propiedades de chrome driver
		-Codificar ingreso a de prueba: https://selenium.dev/
		-Codificar cierre de navegador
		-Correr Test con Junit
		-Verificar resultados
 	*/
public class Laboratorio1 {
	 
	@Test
	public void lab1_E1(){
		//Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		//instanciar Driver de Chrome + importar libreria org.openqa.selenium.chrome.ChromeDriver
		WebDriver d= new ChromeDriver();
		
		//Ir a url
		d.get("https://selenium.dev/");
		//Cerrar navegador
		d.quit();
	}
	
	/* Laboratorio 2 - Ejercicio2:
		-Volver a la clase creada en Ejercicio1 (Laboratorio1) y crear un nuevo test ingresando @Test y debajo de este un método publico llamado lab1_E2.
		-Importar librerías de controlador Firefox
		import org.openqa.selenium.firefox.*;
		-Codificar dentro del método e Instanciar Firefox
		-Codificar la configuración de propiedades de Firefox
		-Codificar ingreso a de prueba: https://selenium.dev/
		-Codificar cambio de tamaño del navegador para que maximice
		-Codificar cierre de navegador
		-Correr Test con Junit
		-Verificar resultados
	*/
	
	@Test
	public void lab1_E2(){
		//Propiedades para ejecutar el driver de Firefox	
		
		System.setProperty("webdriver.gecko.driver","..\\EducacionIt\\Drivers\\geckodriver.exe");
		//Instancias Driver de Firefox + importar libreria	
		
		WebDriver d= new FirefoxDriver();
		
		
			
		d.get("https://selenium.dev/");
		
		d.manage().window().maximize();
		//Localizando elementos
		d.findElement(By.id("gsc-i-id1")).sendKeys("maven");
		d.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
		
		
		//Cerrar el navegador
		d.quit();
	}

	/* Laboratorio 3 - Ejercicio 3:
		-Volver a la clase creada en Ejercicio1 (Laboratorio1) y crear un nuevo test ingresando @Test y debajo de este un método llamado lab1_E3.
		-Codificar dentro del método e Instanciar chrome Driver
		-Codificar la configuración de propiedades de chrome driver
		-Codificar ingreso a de prueba: https://selenium.dev/
		-Codificar localización de elemento por id y asignarlo a una variable de tipo WebElement
		-Codificar envío de datos a elemento input con texto
		-Codificar envío de datos a elemento input con tecla rápida ENTER
		-Codificar cierre de navegador
		-Correr Test con Junit
		-Verificar resultados.
	 */

	@Test
	public void lab1_E3(){

		
		//Propiedades para Ejecutar el driver de Chrome.
		System.setProperty("webdriver.chrome.driver","..\\EducacionIt\\Drivers\\chromedriver.exe");
		WebDriver d= new ChromeDriver();
		
		//Ir a url
		d.get("https://selenium.dev/");
		
		//Con asignacion de elemento a variable
		WebElement textBuscador = d.findElement(By.id("gsc-i-id1"));
		textBuscador.sendKeys("Maven");
		textBuscador.sendKeys(Keys.ENTER);
				
		//Cerrar navegador
		d.quit();
	}
		
}


