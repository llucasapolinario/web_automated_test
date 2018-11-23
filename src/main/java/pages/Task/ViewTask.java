package pages.Task;

import org.openqa.selenium.By;
import pages.Base.BaseHomePage;

public class ViewTask extends BaseHomePage {

    private static final String SELECT_ALL_BUGS_XPATH = "//form[@id='bug_action']/div/div[2]/div[2]/div[2]/div/label/span";
    private static final String PRINT_TASK_LINK = "Imprimir Tarefas";
    private static final String EXPORT_CSV_LINK = "Exportar para Arquivo CSV";
    private static final String EXPORT_EXCEL_LINK = "Exportação para Excel";
    private static final String ACTION_NAME = "action";
    private static final String BTN_OK_XPATH = "//input[@value='OK']";
    private static final String CONFIRM_DELETE_TASK_XPATH = "//input[@value='Apagar Tarefas']";
    private static final String CONFIRM_DONE_TASK_XPATH = "//input[@value='Resolver Tarefas']";
    private static final String CONFIRM_CLOSE_TASK_XPATH = "//input[@value='Fechar Tarefas']";


    public void selectBug(int position) {

        if (position == 1) {
            click(By.xpath("//table[@id='buglist']/tbody/tr/td/div/label/span"));
        } else {
            click(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td/div/label/span"));
        }
    }

    public boolean isCheckBoxSelected(int position) {

        if (position == 1) {
            return isCheckBoxSelected(By.xpath("//table[@id='buglist']/tbody/tr/td/div/label/span"));
        } else {
            return isCheckBoxSelected(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td/div/label/span"));
        }
    }

    public int getNumBug(int position) {
        return Integer.parseInt(readText(By.xpath("//table[@id='buglist']/tbody/tr[" + position + "]/td[4]/a")));
    }

    public boolean isEmptyBug() {
        return !elementExists(By.xpath("//table[@id='buglist']/tbody/tr/td[4]/a"));
    }

    public boolean isBugDone(int position) {

        if (position == 1){
            return waitForElement(By.xpath("//table[@id='buglist']/tbody/tr/td[9]/div/span")).getText().equals("resolvido");
        }
        else{
            return waitForElement(By.xpath("//table[@id='buglist']/tbody/tr["+position+"]/td[9]/div/span")).getText().equals("resolvido");
        }
    }

    public void setSelectAllBugs() {
        scrollToElement(By.xpath(SELECT_ALL_BUGS_XPATH));
        click(By.xpath(SELECT_ALL_BUGS_XPATH));
    }

    public boolean isInViewTakPage() {
        return waitForElement(By.linkText(PRINT_TASK_LINK)).isDisplayed()
                && waitForElement(By.linkText(EXPORT_CSV_LINK)).isDisplayed()
                && waitForElement(By.linkText(EXPORT_EXCEL_LINK)).isDisplayed();
    }

    public void action(String action) {
        scrollToElement(By.name(ACTION_NAME));
        selectSpinnerElement(By.name(ACTION_NAME), action);
    }

    public void clickOnOK(){
        click(By.xpath(BTN_OK_XPATH));
    }

    public void clickConfirmDeleteTask() {
        click(By.xpath(CONFIRM_DELETE_TASK_XPATH));
    }

    public void clickConfirmDoneTask() {
        click(By.xpath(CONFIRM_DONE_TASK_XPATH));
    }

    public boolean isTaskShowing(String numBug) {
        return elementExists(By.linkText(numBug));
    }

    public void clickConfirmCloseTask() {
        click(By.xpath(CONFIRM_CLOSE_TASK_XPATH));
    }

}
