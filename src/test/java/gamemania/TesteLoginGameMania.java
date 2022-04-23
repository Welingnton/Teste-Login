package gamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginGameMania {
    private WebDriver driver;
    
    @Before
    public void abrirNavegador() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @Test
    public void testeNavegador() {
    	driver.get("http://localhost:4200/login");
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	WebElement inputEmail = driver.findElement(By.id("exampleInputEmail1"));
    	WebElement inputPassword = driver.findElement(By.id("exampleInputPassword1"));
    	WebElement buttonLogin = driver.findElement(By.className("btn-primary"));
    	
    	/*inputEmail.sendKeys("welingnton@gmail.com");
    	inputPassword.sendKeys("12345");
    	buttonLogin.click();*/
    	
    	
    	String[] listaSenhas = {"01234", "6789", "2468", "12345"};
    	
    	for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
    		
    		try {
    		inputEmail.clear();
    		inputPassword.clear();
    		
    		inputEmail.sendKeys("welingnton@gmail.com");
    		inputPassword.sendKeys(listaSenhas[tentativas]);
    		buttonLogin.click();
    		
    		Thread.sleep(3000);
    	
    		}catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
}
