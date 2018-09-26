package pages.Task;

import org.openqa.selenium.By;
import pages.Base.BaseHomePage;

public class CreateTaskPage extends BaseHomePage {

    private static final String CATEGORY_ID = "category_id";
    private static final String FREQUENCY_ID = "reproducibility";
    private static final String SEVERITY_ID = "severity";
    private static final String PRIORITY_ID = "priority";
    private static final String HANDLER_ID = "handler_id";
    private static final String SUMMARY_ID = "summary";
    private static final String DESCRIPTION_ID = "description";
    private static final String STEPS_TO_REPRODUCE_ID = "steps_to_reproduce";

    private static final String CREATE_TASK_SUCCESS_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";
    private static final String CREATE_TASK_SUCCESS = "Operação realizada com sucesso.";
    private static final String CREATE_TASK_XPATH = "//input[@value='Criar Nova Tarefa']";
    private static final String CREATE_TASK_PAGE_XPATH = "//form[@id='report_bug_form']/div/div/h4";


    public static final String[] FREQUENCY_LABEL = {"sempre", "às vezes", "aleatório", "não se tentou",
            "incapaz de reproduzir", "N/D"};
    public static final String[] SEVERITY_LABEL = {"recurso", "trivial", "texto", "mínimo",
            "pequeno", "grande", "travamento", "obstáculo"};
    public static final String[] PRIORITY_LABEL = {"nenhuma", "baixa", "normal", "alta", "urgente", "imediato"};

    private static final String ERROR_11_WITHOUT_CATEGORY_CODE = "APPLICATION ERROR #11";
    private static final String ERROR_11_WITHOUT_CATEGORY_MESSAGE = "Um campo necessário 'category' estava vazio. Por favor, verifique novamente suas entradas.";

    public void selectCategory(String label) {
        selectSpinnerElement(By.id(CATEGORY_ID), label);
    }

    public void selectFrequency(String label) {
        selectSpinnerElement(By.id(FREQUENCY_ID), label);
    }

    public void selectSeverity(String label) {
        selectSpinnerElement(By.id(SEVERITY_ID), label);
    }

    public void selectPriority(String label) {
        selectSpinnerElement(By.id(PRIORITY_ID), label);
    }

    public void setHandler(String handler){
        selectSpinnerElement(By.id(HANDLER_ID), handler);
    }

    public void setSummary(String summary){
        writeText(By.id(SUMMARY_ID), summary);
    }

    public void setDescription(String description){
        writeText((By.id(DESCRIPTION_ID)), description);
    }

    public void clickCreateTask(){
        click(By.xpath(BaseHomePage.MENU_CREATE_TASK_XPATH));
    }

    public void clickInNewTask(){
        scrollToElement(By.xpath(CREATE_TASK_XPATH));
        click(By.xpath(CREATE_TASK_XPATH));
    }

    public boolean isCategoryNotSet() {
        return ERROR_11_WITHOUT_CATEGORY_CODE.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_11_WITHOUT_CATEGORY_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

    public boolean isTaskCreated(){
        return CREATE_TASK_SUCCESS.equals(readText(By.xpath(CREATE_TASK_SUCCESS_XPATH)));
    }

    public boolean isCreateTaskPage() {
        return waitForElement(By.xpath(CREATE_TASK_PAGE_XPATH)).isDisplayed();
    }
}
