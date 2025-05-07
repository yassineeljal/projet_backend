package takfayassine.backendprojet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class testRegisterUser {

    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./data/chromedriver.exe");
    }

    //ajoute le client a la BD mais dit "test failed"
    @Test
    public void testRegisterForm() {
        driver.get("http://localhost/Inscription");

        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname  = driver.findElement(By.name("lastname"));
        WebElement username  = driver.findElement(By.name("username"));
        WebElement email     = driver.findElement(By.name("email"));
        WebElement password  = driver.findElement(By.name("password"));
        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));

        firstname.sendKeys("takfa");
        lastname.sendKeys("djerroud");
        username.sendKeys("takfa10");
        email.sendKeys("takfa@selenium.com");
        password.sendKeys("1212");
        registerButton.click();

        String registerOk = "http://localhost/";
        assertEquals(driver.getCurrentUrl(), registerOk);
    }
}
