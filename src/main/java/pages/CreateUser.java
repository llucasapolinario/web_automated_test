package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUser extends BasePage {

    private static final String NAME = "/input[#'username']";
    private static final String EMAIL = "/input[#'email-field']";

    public void setUserName(String name) {
        writeText(By.xpath(NAME), name);
    }

    public void setUserEmail(String email) {
        writeText(By.xpath(EMAIL), email);
    }

}
