package pages;

import org.openqa.selenium.By;


public class LoginPage extends BaseElement {

    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_ID = "password";
    private static final String LOGIN_XPATH = "//input[@value='Entrar']";
    private static final String ERROR_MESSAGE_PASSWORD_XPATH = "//div[@id='main-container']/div/div/div/div/div[4]/p";
    private static final String CREATE_NEW_USER_LINK = "criar uma nova conta";
    private static final String FAILURE_LOGIN_MESSAGE = "Sua conta pode estar desativada ou bloqueada ou " +
            "o nome de usuário e a senha que você digitou não estão corretos.";

    public void login(String username, String password) {
        setLoginUsername(username);
        setLoginPassword(password);
    }

    private void setLoginUsername(String username) {
        writeText(By.id(USERNAME_ID), username);
        clickLogin();
    }

    private void setLoginPassword(String password) {
        writeText(By.id(PASSWORD_ID), password);
        clickLogin();
    }

    public void clickLogin() {
        click(By.xpath(LOGIN_XPATH));
    }

    public void clickCreateUser() {
        click(By.linkText(CREATE_NEW_USER_LINK));
    }

    public boolean isLoginFail() {
        return readText(By.xpath(ERROR_MESSAGE_PASSWORD_XPATH)).equals(FAILURE_LOGIN_MESSAGE);
    }

}
