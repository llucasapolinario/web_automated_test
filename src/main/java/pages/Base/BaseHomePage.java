package pages.Base;

import org.openqa.selenium.By;

public class BaseHomePage extends BaseElement {

    protected static final String MANTIS_BD_XPATH = "//div[@id='navbar-container']//a[@href='/my_view_page.php']/span[@class='smaller-75']";
    protected static final String MENU_OVERVIEW_XPATH = "//a[@href='/my_view_page.php']/i";
    protected static final String MENU_VIEW_ALL_TASK_XPATH = "//a[@href='/view_all_bug_page.php']/i";
    protected static final String MENU_CREATE_TASK_XPATH = "//a[@href='/bug_report_page.php']/i";
    protected static final String MENU_CHANGELOG_XPATH = "//a[@href='/changelog_page.php']";
    protected static final String MENU_PLANNING_XPATH = "//a[@href='/roadmap_page.php']";
    protected static final String MENU_SUMMARY_XPATH = "//a[@href='/summary_page.php']";
    protected static final String MENU_MANAGER_XPATH = "//a[@href='/manage_overview_page.php']/i";
    protected static final String HIDE_MENU_XPATH = "//div[@id='sidebar']//i[@class='ace-icon fa fa-angle-double-left']";
    protected static final String XPAND_MENU_XPATH = "//div[@id='sidebar']//i[@class='ace-icon fa fa-angle-double-right']";

    protected static final String INVITE_USER_LINK = "Convidar Usuários";
    protected static final String CREATE_TASK_LINK = "Criar Tarefa";
    protected static final String ALL_PROJECT_XPATH = "//li[@id='dropdown_projects_menu']/div";
    protected static final String USER_XPATH = "///span[@innertext='administrator']";

    protected static final String ERROR_CODE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";
    protected static final String ERROR_MESSAGE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[2]";

    // Registro de mudanças
    private static final String MAIN_CONTAINER = "//div[@id='main-container']/div[@class='main-content']/div[@class='page-content']//p[@class='lead']";
    private static final String NO_CHANGELOG = "Nenhum registro de mudança disponível. Apenas tarefas que indiquem a versão na qual foi resolvida aparecerão nos registros de mudança.";

    public boolean isHomeScreenVisible() {
        return waitForElement(By.xpath(MANTIS_BD_XPATH)).isDisplayed();
    }

    public void clickOverView(){
        click(By.xpath(MENU_OVERVIEW_XPATH));
    }

    public void clickTask(){
        click(By.xpath(MENU_VIEW_ALL_TASK_XPATH));
    }

    public void clickCreateTask(){
        click(By.xpath(MENU_CREATE_TASK_XPATH));
    }

    public void clickChangelogPage() {
        click(By.xpath(MENU_CHANGELOG_XPATH));
    }

    public void clickRoadMap() {
        click(By.xpath(MENU_PLANNING_XPATH));
    }

    public void clickSummary() {
        click(By.xpath(MENU_SUMMARY_XPATH));
    }

    public void clickManager(){
        click(By.xpath(MENU_MANAGER_XPATH));
    }

    public boolean isNoneChangelog() {
        return readText(By.xpath(MAIN_CONTAINER)).equals(NO_CHANGELOG);
    }

    public void clickInLinkCreateUser() {
        click(By.linkText(INVITE_USER_LINK));
    }

    public void clickInLinkCreateTask(){
        click(By.linkText(CREATE_TASK_LINK));
    }
}
