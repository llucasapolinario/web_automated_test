package pages.Login;

import org.openqa.selenium.By;
import pages.Base.BaseElement;


public class LoginPage extends BaseElement {

    private static final String EDIT_TEXT_USERNAME_ID = "username";
    private static final String LOGIN_BOX_XPATH = "//div[@id='login-box']/div/div/h4";
    private static final String EDIT_TEXT_PASSWORD_ID = "password";
    private static final String BTN_LOGIN_XPATH = "//input[@value='Entrar']";
    private static final String ERROR_MESSAGE_PASSWORD_XPATH = "//div[@id='main-container']/div/div/div/div/div[4]/p";
    private static final String LINK_CREATE_NEW_USER = "criar uma nova conta";
    private static final String LINK_RECOVER_PASSWORD_USER = "Perdeu a sua senha?";

    private static final String LOGIN_BOX_TEXT = "Entrar";
    private static final String RECOVER_PASSWORD_BOX_TEXT = "Reajuste de Senha";
    private static final String CREATE_ACCOUNT_BOX_TEXT = "Criar Conta";
    private static final String FAILURE_LOGIN_MESSAGE = "Sua conta pode estar desativada ou bloqueada ou " +
            "o nome de usuário e a senha que você digitou não estão corretos.";

    public boolean isLoginPage() {
        return waitForElement(By.xpath(BTN_LOGIN_XPATH)).isDisplayed()
                && LOGIN_BOX_TEXT.equals(readText(By.xpath(LOGIN_BOX_XPATH)));
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
        return CREATE_ACCOUNT_BOX_TEXT.equals(readText(By.xpath(LOGIN_BOX_XPATH)));
    }

    public void clickRecoverPassword() {
        scrollTolement(By.linkText(LINK_RECOVER_PASSWORD_USER));
        click(By.linkText(LINK_RECOVER_PASSWORD_USER));
    }

    public boolean isRecoverPasswordPage() {
        return RECOVER_PASSWORD_BOX_TEXT.equals(readText(By.xpath(LOGIN_BOX_XPATH)));
    }
}
