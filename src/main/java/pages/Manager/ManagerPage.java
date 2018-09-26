package pages.Manager;

import org.openqa.selenium.By;
import pages.Base.BaseHomePage;

public class ManagerPage extends BaseHomePage {

    static final String MANAGER_USER_HREF = "Gerenciar Usuários";
    static final String MANAGER_PROJECTS_HREF = "Gerenciar Projetos";
    private static final String MANAGER_TAGS_HREF = "Gerenciar Marcadores";
    private static final String MANAGER_CUSTOM_FIELD_HREF = "Gerenciar Campos Personalizados";
    private static final String MANAGER_PROF_MENU_HREF = "Gerenciar Perfís Globais";
    private static final String MANAGER_PLUGIN_HREF = "Gerenciar Plugins";
    private static final String MANAGER_PERMISSIONS_HREF = "Gerenciar Configuração";

    public boolean isManagerPage() {
        return waitForElement(By.linkText(MANAGER_USER_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_PROJECTS_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_TAGS_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_CUSTOM_FIELD_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_PROF_MENU_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_PLUGIN_HREF)).isDisplayed()
                && waitForElement(By.linkText(MANAGER_PERMISSIONS_HREF)).isDisplayed();
    }

}
