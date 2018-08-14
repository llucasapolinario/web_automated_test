package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final String MANTIS_BD_XPATH = "//div[@id='navbar-container']//a[@href='/my_view_page.php']/span[@class='smaller-75']";
    private static final String OVERVIEW_XPATH = "//a[@href='/my_view_page.php']/i";
    private static final String TASK_XPATH = "//a[@href='/view_all_bug_page.php']/i";
    private static final String CHANGELOG_XPATH = "//a[@href='/changelog_page.php']";
    private static final String PLANNING_XPATH = "//a[@href='/roadmap_page.php']";
    private static final String SUMMARY_XPATH = "//a[@href='/summary_page.php']";
    private static final String MANAGER_XPATH = "//a[@href='/manage_overview_page.php']/i";
    private static final String HIDE_MENU_XPATH = "//div[@id='sidebar']//i[@class='ace-icon fa fa-angle-double-left']";
    private static final String XPAND_MENU_XPATH = "//div[@id='sidebar']//i[@class='ace-icon fa fa-angle-double-right']";
    private static final String INVITE_USER_LINK = "Convidar Usuários";
    private static final String ALL_PROJECT_LINK = "Todos os Projetos";
    private static final String USER_XPATH =  "///span[@innertext='administrator']";


    // 1 projeto
    private static final String PROJECT_NAME = "/html//input[@id='project-name']";
    private static final String ADD_PROJECT_BT = "//form[@id='manage-project-create-form']/div[@class='widget-box widget-color-blue2']//input[@value='Adicionar projeto']";

    // Registro de mudanças
    private static final String MAIN_CONTAINER = "//div[@id='main-container']/div[@class='main-content']/div[@class='page-content']//p[@class='lead']";
    private static final String NO_CHANGELOG = "Nenhum registro de mudança disponível. Apenas tarefas que indiquem a versão na qual foi resolvida aparecerão nos registros de mudança.";


    public boolean isHomeScreenVisible() {
        return waitForElement(By.xpath(MANTIS_BD_XPATH)).isDisplayed();
    }

    public void clickOverView(){
        click(By.xpath(OVERVIEW_XPATH));
    }

    public void clickTask(){
        click(By.xpath(TASK_XPATH));
    }

    public void clickChangelogPage() {
        click(By.xpath(CHANGELOG_XPATH));
    }

    public void clickRoadMap() {
        click(By.xpath(PLANNING_XPATH));
    }

    public void clickSummary() {
        click(By.xpath(SUMMARY_XPATH));
    }

    public void clickManager(){
        click(By.xpath(MANAGER_XPATH));
    }

    public boolean isNoneChangelog() {
        return readText(By.xpath(MAIN_CONTAINER)).equals(NO_CHANGELOG);
    }

    //    private void setProjectName(String projectName) {
//        writeText(By.id(PROJECT_NAME), projectName);
//    }
//
//    public void clickAddProject() {
//        click(By.xpath(ADD_PROJECT_BT));
//    }
}
