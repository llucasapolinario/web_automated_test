package pages.CreateTask;

import org.openqa.selenium.By;
import pages.Base.BaseHomePage;

public class CreateTaskPage extends BaseHomePage {

    private static final String CATEGOY_ID = "category_id";
    private static final String FREQUENCY_ID = "reproducibility";
    private static final String SEVERITY_ID = "severity";
    private static final String PRIORITY_ID = "priority";
    private static final String HANDLER_ID = "handler_id";
    private static final String SUMMARY_ID = "summary";
    private static final String DESCRIPTION_ID = "description";
    private static final String STEPS_TO_REPRODUCE_ID = "steps_to_reproduce";

    private static final String CREATE_NEW_TASK_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::div[6]";


    public static final String[] FREQUENCY_LABEL = {"sempre", "às vezes", "aleatório", "não se tentou",
            "incapaz de reproduzir", "N/D"};
    public static final String[] SEVERITY_LABEL = {"recurso", "trivial", "texto", "mínimo",
            "pequeno", "grande", "travamento", "obstáculo"};
    public static final String[] PRIORITY_LABEL = {"nenhuma", "baixa", "normal", "alta", "urgente", "imediato"};

    private static final String ERROR_11_WITHOUT_CATEGOTY_CODE = "APPLICATION ERROR #11";
    private static final String ERROR_11_WITHOUT_CATEGOTY_MESSAGE = "Um campo necessário 'category' estava vazio. Por favor, verifique novamente suas entradas.";

    public void selectyCategory(String label) {
        selectSpinnerElement(By.id(CATEGOY_ID), label);
    }

    public void selectyFrequency(String label) {
        selectSpinnerElement(By.id(FREQUENCY_ID), label);
    }

    public void selectySeverity(String label) {
        selectSpinnerElement(By.id(SEVERITY_ID), label);
    }

    public void selectyPriority(String label) {
        selectSpinnerElement(By.id(PRIORITY_ID), label);
    }

}
