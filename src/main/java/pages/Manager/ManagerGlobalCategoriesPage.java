package pages.Manager;

import org.openqa.selenium.By;

public class ManagerGlobalCategoriesPage extends ManagerPage {

    private static final String ADD_CATEGORY_XPATH = "//input[@value='Adicionar Categoria']";
    private static final String CATEGORY_NAME = "name";
    private static final String Update_CATEGORY_NAME_ID = "proj-category-name";
    private static final String ASSIGNED_CATEGORY_ID = "proj-category-assigned-to";
    private static final String UPDATE_CATEGORY_XPATH = "//input[@value='Atualizar Categoria']";
    private static final String CONFIRM_DELETE_CATEGORY_XPATH = "//input[@value='Apagar Categoria']";
    private static final String GLOBAL_CATEGORY_PAGE_XPATH = "//div[@id='categories']/div/div/h4";
    private static final String EDIT_CATEGORY_PAGE_XPATH = "//form[@id='manage-proj-category-update-form']/div/div/h4";
    private static final String DELETE_CATEGORY_IN_EDIT_PAGE_XPATH = "//input[@value='Apagar Categoria']";

    private static final String ERROR_1500 = "APPLICATION ERROR #1500";
    private static final String ERROR_1504 = "APPLICATION ERROR #1504";
    private static final String ERROR_1500_MESSAGE = "Uma categoria com este nome já existe.";
    private static final String ERROR_1504_MESSAGE = "Esta Categoria não pode ser eliminada, pois é definida como \"Categoria Padrão para Movimentos\".";
    private static final String CONTINUE_CATEGORY_LINK = "Clique aqui para prosseguir";

    private static final String table = "(.//*[normalize-space(text()) and normalize-space(.)='";
    private static final String position = "'])[1]/following::button[1]";


    public void setCategoryName(String name) {
        writeText(By.name(CATEGORY_NAME), name);
    }

    public void clickAddCategory() {
        click(By.xpath(ADD_CATEGORY_XPATH));
    }

    public void clickConfirmDeleteCategory() {
        click(By.xpath(CONFIRM_DELETE_CATEGORY_XPATH));
    }

    public void clickEdit(String category) {
        click(By.xpath(table + category + position));
    }

    public boolean isCategoryExist(String category) {
        return elementExists(By.xpath(table + category + position));
    }

    public void updateCategoryName(String newName) {
        writeText(By.id(Update_CATEGORY_NAME_ID), newName);
    }

    public void clickDelete(String category) {
        click(By.xpath(table + category + position));
    }

    public void clickDeleteCategoryInEditPage() {
        click(By.xpath(DELETE_CATEGORY_IN_EDIT_PAGE_XPATH));
    }

    public void clickUpdateCategory() {
        click(By.xpath(UPDATE_CATEGORY_XPATH));
    }

    public void selectAssigned(String assigned) {
        selectSpinnerElement(By.id(ASSIGNED_CATEGORY_ID), assigned);
    }

    public boolean isCategoryNameUsing() {
        return elementExists(By.xpath(ERROR_CODE_XPATH));
    }

    public boolean errorCategoryNameUsing() {
        return ERROR_1500.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_1500_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

    public boolean existCategory(String category) {
        return elementExists(By.xpath(table + category + position));
    }

    public void clickToContinue() {
        click(By.linkText(CONTINUE_CATEGORY_LINK));
    }

    public boolean isManagerGlobalCategoryPage() {
        scrollToElement(By.xpath(GLOBAL_CATEGORY_PAGE_XPATH));
        return waitForElement(By.xpath(GLOBAL_CATEGORY_PAGE_XPATH)).isDisplayed();
    }

    public boolean isEditGlobalCategoryPage() {
        return waitForElement(By.xpath(EDIT_CATEGORY_PAGE_XPATH)).isDisplayed();
    }

    public boolean isDeleteCategory() {
        return waitForElement(By.xpath(CONFIRM_DELETE_CATEGORY_XPATH)).isDisplayed();
    }

    public void goBack() {
        goBackPage();
    }

    public boolean isNotDeletedGeneralCategory() {
        return ERROR_1504.equals(readText(By.xpath(ERROR_CODE_XPATH)))
                && ERROR_1504_MESSAGE.equals(readText(By.xpath(ERROR_MESSAGE_XPATH)));
    }

}
