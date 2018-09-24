package pages.Manager;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class ManagerGlobalCategoriesPage extends ManagerPage {

    private static final String ADD_CATEGORY_XPATH = "//input[@value='Adicionar Categoria']";
    private static final String CATEGORY_NAME = "name";
    private static final String Update_CATEGORY_NAME_ID = "proj-category-name";
    private static final String ASSIGNED_CATEGORY_ID = "proj-category-assigned-to";
    private static final String UPDATE_CATEGORY_XPATH  = "//input[@value='Atualizar Categoria']";
    private static final String ERROR_1500  = "APPLICATION ERROR #1500";
    private static final String ERROR_1500_MESSAGE  = "Uma categoria com este nome já existe.";
    private static final String CONFIRM_DELETE_CATEGORY_XPATH  = "//input[@value='Apagar Categoria']";
    private static final String CONTINUE_CATEGORY_LINK  = "Clique aqui para prosseguir";


    public void setCategoryName(String name){
        writeText(By.name(CATEGORY_NAME), name);
    }

    public void clickAddCategory(){
        click(By.xpath(ADD_CATEGORY_XPATH));
    }
    public void clickConfirmDeleteCategory(){
        click(By.xpath(CONFIRM_DELETE_CATEGORY_XPATH));
    }

    public void clickEdit(String category){
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+category+"'])[1]/following::button[1]"));
    }


    public void updateCategoryName(String newName){
        writeText(By.id(Update_CATEGORY_NAME_ID), newName);
    }

    public void clickDelete(String category){
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+category+"'])[1]/following::button[2]"));
    }

    public void clickUpdateCategory(){
        click(By.xpath(UPDATE_CATEGORY_XPATH));
    }

    public void selectAssigned(String assigned){
        selectSpinnerElement(By.id(ASSIGNED_CATEGORY_ID), assigned);
    }

    public void gotoManagerGlobalCategoriesPage() {
        click(By.xpath(MANAGER_XPATH));
        click(By.linkText(MANEGER_PROJECTS_HREF));
    }

    public boolean isCategoryNameUsing(){
        return elementExists(By.xpath(ERROR_CODE_XPATH));
    }

    public boolean errorCategoryNameUsing(){
        return ERROR_1500.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_1500_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

    public boolean existCategory(String category) {
        return elementExists(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+category+"'])[1]/following::button[1]"));
    }

    public void clickToContinue() {
        click(By.linkText(CONTINUE_CATEGORY_LINK));
    }
}
