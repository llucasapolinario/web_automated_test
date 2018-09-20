package pages.Manager;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;

public class NewProjectPage extends ManegerPage {

    private static final String PROJECT_NAME_ID = "project-name";
    private static final String ADD_PROJECT_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='* requerido'])[1]/following::input[1]";
    private static final String STATE_ID = "project-status";
    private static final String VISIBILITY_ID = "project-view-state";
    private static final String EXTENDS_GLOBAL_CATEGORY_CSS = ".lbl";
    private static final String PROJECT_DESCRIPTION_ID = "project-description";
//    private static final String FILL_THIS_FIELD_ID = "(.//*[normalize-space(text()) and normalize-space(.)='Estado'])[1]/following::td[1]";
//    private static final String SUCCESS_OPERATION_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";
    private static final String CLICK_TO_MANAGE_PROJECT_ID = "manage-project-create-form";
    private static final String NEW_PROJECT_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Gerenciar Configuração'])[1]/following::button[1]";
    private static final String ERROR_701_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";


    private static final String FIRST_PROJECT_TABLE = "(.//*[normalize-space(text()) and normalize-space(.)='Descrição'])[1]/following::a[1]";


    private static final String ERROR_701 = "APPLICATION ERROR #701";
    private static final String PRIVATE = "privado";
    private static final String PUBLIC = "público";
    private static final String DEVELOPMENT = "desenvolvimento";
    private static final String RELEASE = "release";
    private static final String STABLE = "estável";
    private static final String OBSOLETE = "obsoleto";
    private static final String SUCCESS_OPERATION = "Operação realizada com sucesso.";

    public void setProjectName(String projectName) {
        writeText(By.id(PROJECT_NAME_ID), projectName);
    }

    public void clickAddProject() {
        click(By.xpath(ADD_PROJECT_XPATH));
    }

    public void setExtendsGlobalCategory() {
        selectCheckBox(By.cssSelector(EXTENDS_GLOBAL_CATEGORY_CSS));
    }

    public void doNotSetExtendsGlobalCategory() {
        unSelectCheckBox(By.cssSelector(EXTENDS_GLOBAL_CATEGORY_CSS));
    }

    public void setStateDevelopment() {
        selectSpinnerElement(By.id(STATE_ID), DEVELOPMENT);
    }

    public void setStateRelease() {
        selectSpinnerElement(By.id(STATE_ID), RELEASE);
    }

    public void setStateStable() {
        selectSpinnerElement(By.id(STATE_ID), STABLE);
    }

    public void setStateObsolete() {
        selectSpinnerElement(By.id(STATE_ID), OBSOLETE);
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

//    public boolean isNoneProjectName() {
//        return waitForElement(By.xpath(FILL_THIS_FIELD_ID)) == null;
//    }
//    public boolean isProjectCreate(){
//
//        return waitForElement(By.xpath(SUCCESS_OPERATION_XPATH)) == null;
//    }

    public boolean isNewProjectShowing(String projectName){
        return projectName.equals(readText(By.xpath(FIRST_PROJECT_TABLE)));
    }

    public void gotoManagerProjects() {
        click(By.xpath(MANAGER_XPATH));
        click(By.linkText(MANEGER_PROJECTS_HREF));
    }

    public void clickNewProject() {
        click(By.xpath(NEW_PROJECT_XPATH));
    }

    public boolean isNameProjectUsing(){
        return ERROR_701.equals(readText(By.xpath(ERROR_701_XPATH)));
    }

}