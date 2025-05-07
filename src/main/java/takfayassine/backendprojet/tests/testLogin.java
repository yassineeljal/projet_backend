package takfayassine.backendprojet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class testLogin {

    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./data/chromedriver.exe");
    }

    //accede au profil mais dit "test failed"

    @Test
    public void testLoginForm() {
        driver.get("http://localhost/Login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("takfa10");
        password.sendKeys("1212");
        loginButton.click();

        String loginOk = "http://localhost/Profile";
        assertEquals(driver.getCurrentUrl(), loginOk);
    }
}
