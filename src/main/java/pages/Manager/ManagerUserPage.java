package pages.Manager;

import org.openqa.selenium.By;

public class ManagerUserPage extends ManagerPage {

    private static final String NEW_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='NOVO'])[1]/following::button[1]";
    private static final String USERNAME_ID = "user-username";
    private static final String REAL_NAME_ID = "user-realname";
    private static final String EMAIL_ID = "email-field";
    private static final String ACCESS_LEVEL_ID = "user-access-level";
    private static final String ABLE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Habilitado'])[1]/following::span[1]";
    private static final String PROTECTED_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Protegido'])[1]/following::span[1]";
    private static final String CREATE_USER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Protegido'])[1]/following::input[2]";
    private static final String CONFIRM_DELETE_USER = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/foll";

    private static final String ERROR_805 = "APPLICATION ERROR #805";
    private static final String ERROR_805_MESSAGE = "";
    private static final String ERROR_800 = "APPLICATION ERROR #800";
    private static final String ERROR_800_MESSAGE = "Este nome de usuário já está sendo usado. Por favor, volte e selecione um outro.";
    private static final String ERROR_1200 = "APPLICATION ERROR #1200";
    private static final String ERROR_1200_MESSAGE = "E-mail inválido.";

    public void clickNewUser() {
        click(By.xpath(NEW_USER_XPATH));
    }

    public void setUserName(String userName) {
        writeText(By.id(USERNAME_ID), userName);
    }

    public void setRealName(String realName) {
        writeText(By.id(REAL_NAME_ID), realName);
    }

    public void setUserEmail(String email) {
        writeText(By.id(EMAIL_ID), email);
    }

    public void setAccessLevel(String level) {
        selectSpinnerElement(By.id(ACCESS_LEVEL_ID), level);
    }

    public void setAble() {
        selectCheckBox(By.xpath(ABLE_XPATH));
    }

    public void setEnable() {
        unSelectCheckBox(By.xpath(ABLE_XPATH));
    }

    public void setProtected() {
        selectCheckBox(By.xpath(PROTECTED_XPATH));
    }

    public void setUnprotected() {
        unSelectCheckBox(By.xpath(PROTECTED_XPATH));
    }

    public void clickCreateUser() {
        click(By.xpath(CREATE_USER_XPATH));
    }

    public boolean isNameProjectUsing(){
        return ERROR_805.equals(readText(By.xpath(ERROR_CODE_XPATH)));
    }

    public void gotoManagerUser() {
        click(By.xpath(MANAGER_XPATH));
        gotoManagerUserPage();
    }

    public void gotoManagerUserPage(){
        click(By.linkText(MANEGER_USER_HREF));
    }

    public boolean isUserShowing(String userName){
        return userName.equals(readText(By.linkText(userName)));
    }

    public boolean isEmailWrong(){
        return ERROR_1200.equals(elementExists(By.linkText(ERROR_CODE_XPATH)));
    }

}
