package login;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class test1 {

    @Test
    void testLogin(){

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com.br");

        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Rafael Costa Cavalcante");
        campoDeTexto.submit();
        driver.close();
    }

}

