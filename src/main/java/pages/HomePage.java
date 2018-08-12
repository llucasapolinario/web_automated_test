package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String MANTIS_BD = "//div[@id='navbar-container']//a[@href='/my_view_page.php']/span[@class='smaller-75']";
    private static final String PROJECT_NAME = "/html//input[@id='project-name']";
    private static final String ADD_PROJECT_BT = "//form[@id='manage-project-create-form']/div[@class='widget-box widget-color-blue2']//input[@value='Adicionar projeto']";

    public boolean isHomeScreenVisible(){
        return waitForElement(By.xpath(MANTIS_BD)).isDisplayed();
    }

    private void setProjectName(String projectName) {
        writeText(By.id(PROJECT_NAME), projectName);
    }

    public void click() {
        click(By.xpath(ADD_PROJECT_BT));
    }
}
