package pages.Manager;

import org.openqa.selenium.By;

public class ManagerProjectPage extends ManagerPage {

    private static final String EDIT_TEXT_PROJECT_NAME_ID = "project-name";
    private static final String BTN_ADD_PROJECT_XPATH = "//input[@value='Adicionar projeto']";
    private static final String UPDATE_PROJECT_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='* requerido'])[1]/following::input[1]";
    private static final String DELETE_PROJECT_ID = "project-delete-form";
    private static final String CONFIRM_DELETE_PROJECT_ID = "main-container";
    private static final String STATE_ID = "project-status";
    private static final String VISIBILITY_ID = "project-view-state";
    private static final String EXTENDS_GLOBAL_CATEGORY_CSS = ".lbl";
    private static final String PROJECT_DESCRIPTION_ID = "project-description";

    private static final String BTN_NEW_PROJECT_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Gerenciar Configuração'])[1]/following::button[1]";
    private static final String EDIT_PROJECT_PAGE_XPATH = "//form[@id='manage-proj-update-form']/div/div/h4";

    private static final String ADD_PROJECT_TITLE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Gerenciar Configuração'])[1]/following::h4[1]";

    private static final String ERROR_701 = "APPLICATION ERROR #701";
    private static final String PRIVATE = "privado";
    private static final String PUBLIC = "público";
    private static final String RELEASE = "release";


    public void setProjectName(String projectName) {
        writeText(By.id(EDIT_TEXT_PROJECT_NAME_ID), projectName);
    }

    public void clickAddProject() {
        click(By.xpath(BTN_ADD_PROJECT_XPATH));
    }

    public void setExtendsGlobalCategory() {
        selectCheckBox(By.cssSelector(EXTENDS_GLOBAL_CATEGORY_CSS));
    }

    public void doNotSetExtendsGlobalCategory() {
        unSelectCheckBox(By.cssSelector(EXTENDS_GLOBAL_CATEGORY_CSS));
    }

    public void setStateRelease() {
        selectSpinnerElement(By.id(STATE_ID), RELEASE);
    }

    public void setProjectPrivate() {
        selectSpinnerElement(By.id(VISIBILITY_ID), PRIVATE);
    }

    public void setProjectPublic() {
        selectSpinnerElement(By.id(VISIBILITY_ID), PUBLIC);
    }

    public void setProjectDescription(String description) {
        writeText(By.id(PROJECT_DESCRIPTION_ID), description);
    }

    public boolean isNewProjectShowing(String projectName) {
        return elementExists(By.linkText(projectName));
    }

    public void clickManagerProjectsPage() {
        click(By.linkText(MANAGER_PROJECTS_HREF));
    }

    public void clickNewProject() {
        click(By.xpath(BTN_NEW_PROJECT_XPATH));
    }

    public void clickInProject(String projectNam) {
        click(By.linkText(projectNam));
    }

    public void clickUpdateProject() {
        click(By.xpath(UPDATE_PROJECT_XPATH));
    }

    public void clickDeleteProject() {
        click(By.id(DELETE_PROJECT_ID));
    }

    public void clickConfirmDeleteProject() {
        click(By.id(CONFIRM_DELETE_PROJECT_ID));
    }

    public boolean isNameProjectUsing() {
        return ERROR_701.equals(readText(By.xpath(ERROR_CODE_XPATH)));
    }

    public boolean isCreateProjectPage() {
        return waitForElement(By.xpath(ADD_PROJECT_TITLE_XPATH)).isDisplayed()
                && waitForElement(By.xpath(BTN_ADD_PROJECT_XPATH)).isDisplayed();
    }

    public boolean isManagerProjectPage(){
        return waitForElement(By.xpath(BTN_NEW_PROJECT_XPATH)).isDisplayed();
    }

    public boolean isEditProjectPage() {
        return waitForElement(By.xpath(EDIT_PROJECT_PAGE_XPATH)).isDisplayed();
    }

}