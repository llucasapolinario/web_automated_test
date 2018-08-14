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
    private static final String REGISTRO_DE_MUDANCAS =
            "//a[@href='/changelog_page.php']";
    private static final String PLANNING =
            "//a[@href='/roadmap_page.php']";
    private static final String MAIN_CONTAINER =
            "//div[@id='main-container']/div[@class='main-content']/div[@class='page-content']//p[@class='lead']";

    ///span[@innertext=' Registro de Mudanças ']
    //div[@id='sidebar']/ul[@class='nav nav-list']//a[@href='/changelog_page.php']/span[@class='menu-text']
    public boolean isHomeScreenVisible(){
        return waitForElement(By.xpath(MANTIS_BD)).isDisplayed();
    }

    private void setProjectName(String projectName) {
        writeText(By.id(PROJECT_NAME), projectName);
    }

    public void clickAddProject() {
        click(By.xpath(ADD_PROJECT_BT));
    }

    public void clickRegistroDeMudanca() {
        click(By.xpath(REGISTRO_DE_MUDANCAS));
    }

    public void clickRoadMap() {
        click(By.xpath(PLANNING));
    }

    public boolean isNoneRegistro(){
        return readText(By.xpath(MAIN_CONTAINER)).equals("Nenhum registro de mudança disponível. Apenas tarefas que indiquem a versão na qual foi resolvida aparecerão nos registros de mudança.");
    }
}
