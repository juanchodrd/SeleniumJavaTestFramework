package test;
import functions.Functions;
import pages.Migraciones;
import functions.Config;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class tst_003{
	Config Config = new Config();
	Functions Selenium = new Functions();
	WebDriver driver;
	Migraciones Migraciones = new Migraciones();	
	String TestCaptura = this.getClass().getName();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = Selenium.AbrirNavegador();
		driver.get(Config.UrlMigraciones);
		
	}
	
	@Test
	 public void Test_003() throws InterruptedException{
		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.Select_Elements_Xpath(driver, Migraciones.dpd_Provincia_xpath).selectByVisibleText("BUENOS AIRES");

		Selenium.ScreenShot(driver, TestCaptura);
		
		Selenium.Esperar_Xpath(driver, Migraciones.dpd_MunicipioOpcion_xpath);
		
		Selenium.Select_Elements_Xpath(driver, Migraciones.dpd_Municipio_xpath).selectByIndex(5);
		
		Selenium.ScreenShot(driver, TestCaptura);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
