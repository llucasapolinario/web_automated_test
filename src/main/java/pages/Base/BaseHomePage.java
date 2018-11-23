package pages.Base;

import org.openqa.selenium.By;

public class BaseHomePage extends BaseElement {

    protected static final String ERROR_CODE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";
    protected static final String ERROR_MESSAGE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[2]";
    protected static final String MENU_CREATE_TASK_LINK = "Criar Tarefa";
    private static final String MANTIS_BD_XPATH = "//div[@id='navbar-container']//a[@href='/my_view_page.php']/span[@class='smaller-75']";
    private static final String MENU_VIEW_ALL_TASK_XPATH = "//a[@href='/view_all_bug_page.php']/i";
    private static final String MENU_MANAGER_XPATH = "//a[@href='/manage_overview_page.php']/i";
    private static final String INVITE_USER_LINK = "Convidar Usuários";
    private static final String CREATE_TASK_LINK = "Criar Tarefa";

    public boolean isHomeScreenVisible() {
        return waitForElement(By.xpath(MANTIS_BD_XPATH)).isDisplayed();
    }

    public void clickTask(){
        click(By.xpath(MENU_VIEW_ALL_TASK_XPATH));
    }

    public void clickCreateTask(){
        click(By.linkText(MENU_CREATE_TASK_LINK));
    }

    public void clickManager(){
        click(By.xpath(MENU_MANAGER_XPATH));
    }

    public void clickInLinkCreateUser() {
        click(By.linkText(INVITE_USER_LINK));
    }

    public void clickInLinkCreateTask(){
        click(By.linkText(CREATE_TASK_LINK));
    }

}
