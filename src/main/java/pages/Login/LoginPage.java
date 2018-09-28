package pages.Login;

import org.openqa.selenium.By;
import pages.Base.BaseElement;


public class LoginPage extends BaseElement {

    private static final String EDIT_TEXT_USERNAME_ID = "username";
    private static final String LOGIN_BOX_XPATH = "//div[@id='login-box']/div/div/h4";
    private static final String EMAIL_ID = "email-field";
    private static final String BTN_SEND_RECOVER_XPATH = "//input[@value='Enviar']";
    private static final String EDIT_TEXT_PASSWORD_ID = "password";
    private static final String BTN_LOGIN_XPATH = "//input[@value='Entrar']";
    private static final String ERROR_MESSAGE_PASSWORD_XPATH = "//div[@id='main-container']/div/div/div/div/div[4]/p";
    private static final String LINK_CREATE_NEW_USER = "criar uma nova conta";
    private static final String LINK_RECOVER_PASSWORD_USER = "Perdeu a sua senha?";
    private static final String ERROR_CODE_RECOVER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Toggle user menu'])[1]/following::p[1]";
    private static final String ERROR_MESSAGE_RECOVER_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Toggle user menu'])[1]/following::p[2]";
//
//    private static final String LOGIN_BOX_TEXT = "Entrar";
    private static final String RECOVER_PASSWORD_TEXT_XPATH = "//form[@id='lost-password-form']/fieldset";
    private static final String CREATE_ACCOUNT_BTN_XPATH = "//input[@value='Criar Conta']";
    private static final String ERROR_1903_CODE = "APPLICATION ERROR #1903";
    private static final String ERROR_1200_CODE = "APPLICATION ERROR #1200";
    private static final String ERROR_1903_MESSAGE = "A informação fornecida não combina com nenhuma conta registrada!";
    private static final String ERROR_1200_MESSAGE = "E-mail inválido.";
    private static final String FAILURE_LOGIN_MESSAGE = "Sua conta pode estar desativada ou bloqueada ou " +
            "o nome de usuário e a senha que você digitou não estão corretos.";

    public boolean isLoginPage() {
        return waitForElement(By.xpath(BTN_LOGIN_XPATH)).isDisplayed();
//                && LOGIN_BOX_TEXT.equals(readText(By.xpath(LOGIN_BOX_XPATH)));
    }

    public void login(String username, String password) {
        setLoginUsername(username);
        setLoginPassword(password);
    }

    private void setLoginUsername(String username) {
        writeText(By.id(EDIT_TEXT_USERNAME_ID), username);
        clickLogin();
    }

    private void setLoginPassword(String password) {
        writeText(By.id(EDIT_TEXT_PASSWORD_ID), password);
        clickLogin();
    }

    public void clickLogin() {
        click(By.xpath(BTN_LOGIN_XPATH));
    }

    public boolean isLoginFail() {
        return readText(By.xpath(ERROR_MESSAGE_PASSWORD_XPATH)).equals(FAILURE_LOGIN_MESSAGE);
    }

    public void clickCreateUser() {
        click(By.linkText(LINK_CREATE_NEW_USER));
    }

    public boolean isCreateAccountPage() {
        scrollToElement(By.xpath(CREATE_ACCOUNT_BTN_XPATH));
        return waitForElement(By.xpath(CREATE_ACCOUNT_BTN_XPATH)).isDisplayed();
    }

    public void clickRecoverPassword() {
        scrollToElement(By.linkText(LINK_RECOVER_PASSWORD_USER));
        click(By.linkText(LINK_RECOVER_PASSWORD_USER));
    }

    public boolean isRecoverPasswordPage() {
        return waitForElement(By.xpath(RECOVER_PASSWORD_TEXT_XPATH)).isDisplayed();
    }

    public void setLoginUsernameToRecover(String username) {
        writeText(By.id(EDIT_TEXT_USERNAME_ID), username);
    }

    public void setEmail(String email){
        writeText(By.id(EMAIL_ID), email);
    }

    public void clickSendRecover(){
        click(By.xpath(BTN_SEND_RECOVER_XPATH));
    }

    public boolean isNoneInformationSet() {
        return ERROR_1903_CODE.equals(readText(By.xpath(ERROR_CODE_RECOVER_XPATH)))
                && ERROR_1903_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_RECOVER_XPATH)));
    }

    public boolean isEmailInvalid() {
        return ERROR_1200_CODE.equals(readText(By.xpath(ERROR_CODE_RECOVER_XPATH)))
                && ERROR_1200_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_RECOVER_XPATH)));
    }

}
