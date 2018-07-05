package test;
import functions.Config;
import functions.Functions;
import data.DataTest;
import pages.Registro;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class tst_001 {
	WebDriver driver;
	Config Config = new Config();
	Functions Selenium = new Functions();
	DataTest DataTest = new DataTest();
	Registro Registro = new Registro();	
	String TestCaptura = this.getClass().getName();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = Selenium.AbrirNavegador();
		driver.get(Config.UrlRegistroGmail);	
		
	}
	
	@Test
	 public void Test_001() throws InterruptedException, IOException{
		 
		String[] Datos = DataTest.test_001_Data();
		System.out.println(Datos);
		
		Selenium.Xpath_Elements(driver, Registro.txt_Nombre_xpath).sendKeys(Datos[0]);
		Selenium.Xpath_Elements(driver, Registro.txt_Apellido_xpath).sendKeys(Datos[1]);
		Selenium.Xpath_Elements(driver, Registro.txt_Usuario_xpath).sendKeys(Datos[2]);
		
		
		
		Selenium.ScreenShot(driver, TestCaptura);
		
		

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		Selenium.EscribirExcel(3, 0, "Finalizo OK");
		driver.quit();
	}

}
