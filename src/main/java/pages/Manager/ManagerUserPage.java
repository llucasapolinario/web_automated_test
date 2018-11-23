package pages.Manager;

import org.openqa.selenium.By;

public class ManagerUserPage extends ManagerPage {

    private static final String BTN_NEW_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='NOVO'])[1]/following::button[1]";
    private static final String EDIT_TEXT_USERNAME_ID = "user-username";
    private static final String EDIT_TEXT_REAL_NAME_ID = "user-realname";
    private static final String EDIT_TEXT_EMAIL_ID = "email-field";
    private static final String EDIT_TEXT_EDIT_USERNAME_ID = "edit-username";

    private static final String SPINNER_ACCESS_LEVEL_ID = "user-access-level";
    private static final String CHECKBOX_ABLE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Habilitado'])[1]/following::span[1]";
    private static final String CHECKBOX_PROTECTED_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Protegido'])[1]/following::span[1]";
    private static final String CREATE_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Protegido'])[1]/following::input[2]";
    private static final String CONFIRM_DELETE_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::input[5]";
    private static final String DELETE_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Notificar o usuário dessa mudança'])[1]/following::input[6]";

    private static final String CREATE_USER_PAGE_XPATH = "//form[@id='manage-user-create-form']/div/div/h4";
    private static final String EDIT_USER_PAGE_XPATH = "//form[@id='edit-user-form']/div/div/h4";

    private static final String ERROR_800 = "APPLICATION ERROR #800";
    private static final String ERROR_800_MESSAGE = "Este nome de usuário já está sendo usado. Por favor, volte e selecione um outro.";
    private static final String ERROR_1200 = "APPLICATION ERROR #1200";
    private static final String ERROR_1200_MESSAGE = "E-mail inválido.";

    public void clickNewUser() {
        click(By.xpath(BTN_NEW_USER_XPATH));
    }

    public void clickInUser(String username) {
        click(By.linkText(username));
    }

    public void setUserName(String userName) {
        writeText(By.id(EDIT_TEXT_USERNAME_ID), userName);
    }

    public void editUsername(String userName) {
        writeText(By.id(EDIT_TEXT_EDIT_USERNAME_ID), userName);
    }

    public void setRealName(String realName) {
        writeText(By.id(EDIT_TEXT_REAL_NAME_ID), realName);
    }

    public void setUserEmail(String email) {
        writeText(By.id(EDIT_TEXT_EMAIL_ID), email);
    }

    public void setAccessLevel(String level) {
        selectSpinnerElement(By.id(SPINNER_ACCESS_LEVEL_ID), level);
    }

    public void setAble() {
        selectCheckBox(By.xpath(CHECKBOX_ABLE_XPATH));
    }

    public void setProtected() {
        selectCheckBox(By.xpath(CHECKBOX_PROTECTED_XPATH));
    }

    public void clickCreateUser() {
        click(By.xpath(CREATE_USER_XPATH));
    }

    public boolean isNameProjectUsing(){
        return ERROR_800.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_800_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

    public void clickManagerUserPage(){
        click(By.linkText(MANAGER_USER_HREF));
    }

    public boolean isUserShowing(String userName){
        return elementExists(By.linkText(userName));
    }

    public boolean isEmailWrong(){
        return ERROR_1200.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_1200_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

    public void clickDeleteUser() {
        click(By.xpath(DELETE_USER_XPATH));
    }

    public void clickConfirmDeleteUser() {
        click(By.xpath(CONFIRM_DELETE_USER_XPATH));
    }

    public boolean isManagerUserPage() {
        return waitForElement(By.xpath(BTN_NEW_USER_XPATH)).isDisplayed();
    }

    public boolean isCreateUserPage() {
        return waitForElement(By.xpath(CREATE_USER_PAGE_XPATH)).isDisplayed();
    }

    public boolean isEditUserPage() {
        return waitForElement(By.xpath(EDIT_USER_PAGE_XPATH)).isDisplayed();
    }

}
