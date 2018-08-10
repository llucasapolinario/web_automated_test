package utils;

import java.io.File;

public abstract class Constants {

    public static final String BASE_URL = "http://mantis.fernando.base2.com.br/";

    // LOGIN
    public static final String USERNAME_ID = "username";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_XPATH = "//input[@value='Entrar']";

    public static final String errorMessagePasswordXpath = "//div[@id='main-container']/div/div/div/div/div[4]/p";
    public static final String MESSAGE_FAILURE_LOGIN = "Sua conta pode estar desativada ou bloqueada ou " +
            "o nome de usuário e a senha que você digitou não estão corretos.";

    // FOLDER
    static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + File.separator +
            "ScreenShots" + File.separator;

}
