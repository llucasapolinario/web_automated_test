package pages.Task;

import org.openqa.selenium.By;
import pages.Base.BaseHomePage;

public class ViewTask extends BaseHomePage {

    private static final String SELECT_ALL_BUGS_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='dlogin'])[3]/following::span[1]";
    private static final String PRINT_TASK_LINK = "Imprimir Tarefas";
    private static final String EXPORT_CSV_LINK = "Exportar para Arquivo CSV";
    private static final String EXPORT_EXCEL_LINK = "Exportação para Excel";
    private static final String ACTION_NAME = "action";
    private static final String BTN_OK_XPATH = "//input[@value='OK']";
    private static final String BUG_NUM_LINK_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Tarefas Selecionadas'])[1]/following::a[1]";
    private static final String CONFIRM_DELETE_TASK_XPATH = "//input[@value='Apagar Tarefas']";

    private static final String NUM_BUG_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='Última Atualização'])[1]/following::td[1]";

    public void selectBug(int position) {
        if (position == 1) {
            click(By.xpath("//table[@id='buglist']/tbody/tr/td/div/label/span"));
        } else {
            click(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td/div/label/span"));
        }
    }

    public void unselectBug(int position) {
        unSelectCheckBox(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td/div/label/span"));
    }

    public boolean isCheckBoxSelected(int position) {
        if (position == 1) {
            return isCheckBoxSelected(By.xpath("//table[@id='buglist']/tbody/tr/td/div/label/span"));
        } else {
            return isCheckBoxSelected(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td/div/label/span"));
        }
    }

    public void editBug(int position) {
        click(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td[2]/a/i"));
    }

    public int getNumBug(int position) {
        return Integer.parseInt(readText(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td[4]/a")));
    }

    public void setSelectAllBugs() {
        scrollToElement(By.xpath(SELECT_ALL_BUGS_XPATH));
        click(By.xpath(SELECT_ALL_BUGS_XPATH));
    }

    public void gotoViewTaskPage() {
        clickTask();
    }

    public boolean isInViewTakPage() {
        return waitForElement(By.linkText(PRINT_TASK_LINK)).isDisplayed()
                && waitForElement(By.linkText(EXPORT_CSV_LINK)).isDisplayed()
                && waitForElement(By.linkText(EXPORT_EXCEL_LINK)).isDisplayed();
    }

    public void clickInLinkText(String text){
        click(By.linkText(text));
    }

    public String getBugNum() {
        return readText(By.xpath(NUM_BUG_XPATH));
    }

    public void action(String action) {
        scrollToElement(By.name(ACTION_NAME));
        selectSpinnerElement(By.name(ACTION_NAME), action);
    }

    public void clickOn(){
        click(By.xpath(BTN_OK_XPATH));
    }

    public String getBugLink() {
        return readText(By.xpath(BUG_NUM_LINK_XPATH));
    }

    public void clickConfirmDeleteTask() {
        click(By.xpath(CONFIRM_DELETE_TASK_XPATH));
    }

    public boolean isTaskShowing(String numBug) {
        return elementExists(By.linkText(numBug));
    }

}
