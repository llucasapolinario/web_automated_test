package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerGlobalCategoriesPage;
import pages.Manager.ManagerProjectPage;
import tests.Base.BaseTest;

public class ManagerGlobalCategoriesTest extends BaseTest {

    private ManagerGlobalCategoriesPage managerGlobalCategoriesPage;
    private String Category_bug = "Bug";
    private String Category_feature = "Feature";
    private String Category_improvement = "Melhoria";
    private String Category_general = "General";

    @Test
    public void createNewGlobalCategory() {
        setupManagerCategory();

        managerGlobalCategoriesPage.setCategoryName(Category_feature);
        managerGlobalCategoriesPage.clickAddCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.isCategoryNameUsing());
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_NameUsing() {
        setupCreateCategory();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
        managerGlobalCategoriesPage.clickAddCategory();

        Assert.assertTrue(managerGlobalCategoriesPage.errorCategoryNameUsing());
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_Edit() {
        validate_EditCategory();

        managerGlobalCategoriesPage.updateCategoryName(Category_feature);
        managerGlobalCategoriesPage.selectAssigned("administrator");
        managerGlobalCategoriesPage.clickUpdateCategory();
        managerGlobalCategoriesPage.clickToContinue();

        Assert.assertFalse(managerGlobalCategoriesPage.isCategoryNameUsing());
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_EditUseAUsingName() {
        setupCreateCategory();

        managerGlobalCategoriesPage.setCategoryName(Category_improvement);
        managerGlobalCategoriesPage.clickAddCategory();
        Assert.assertFalse(managerGlobalCategoriesPage.isCategoryNameUsing());

        managerGlobalCategoriesPage.clickEdit(Category_bug);
        managerGlobalCategoriesPage.updateCategoryName(Category_improvement);
        managerGlobalCategoriesPage.selectAssigned("administrator");
        managerGlobalCategoriesPage.clickUpdateCategory();

        Assert.assertTrue(managerGlobalCategoriesPage.errorCategoryNameUsing());
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_DeleteInGlobalCategoryPage() {
        setupCreateCategory();

        managerGlobalCategoriesPage.clickDelete(Category_bug);
        managerGlobalCategoriesPage.clickConfirmDeleteCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_bug));
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_DeleteInEditCategoryPage() {
        validate_EditCategory();

        managerGlobalCategoriesPage.clickDeleteCategoryInEditPage();
        managerGlobalCategoriesPage.clickConfirmDeleteCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_bug));
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_validateDeletePage() {
        validate_EditCategory();

        managerGlobalCategoriesPage.clickDeleteCategoryInEditPage();

        Assert.assertTrue(managerGlobalCategoriesPage.isDeleteCategory());
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_DeleteGeneralCategoryInGlobalCategoryPage() {
        validate_ManagerGlobalCategoryPage();

        managerGlobalCategoriesPage.clickDelete(Category_general);

        Assert.assertTrue(managerGlobalCategoriesPage.isNotDeletedGeneralCategory());
    }

    @Test
    public void createNewGlobalCategory_DeleteGeneralCategoryInEditPage() {
        validate_ManagerGlobalCategoryPage();
        managerGlobalCategoriesPage.clickEdit(Category_general);
        managerGlobalCategoriesPage.clickDeleteCategoryInEditPage();

        Assert.assertTrue(managerGlobalCategoriesPage.isNotDeletedGeneralCategory());
    }

    @Test
    public void createNewGlobalCategory_CancelDeleteInEditPage() {
        validate_EditCategory();

        managerGlobalCategoriesPage.clickDeleteCategoryInEditPage();

        Assert.assertTrue(managerGlobalCategoriesPage.isDeleteCategory());

        managerGlobalCategoriesPage.goBack();
        managerGlobalCategoriesPage.goBack();

        Assert.assertTrue(managerGlobalCategoriesPage.isCategoryExist(Category_bug));
        deleteCategories();
    }

    @Test
    public void createNewGlobalCategory_CancelDeleteInGlobalCategoryPage() {
        setupCreateCategory();

        managerGlobalCategoriesPage.clickDelete(Category_bug);

        Assert.assertTrue(managerGlobalCategoriesPage.isDeleteCategory());

        managerGlobalCategoriesPage.goBack();

        Assert.assertTrue(managerGlobalCategoriesPage.isCategoryExist(Category_bug));
        deleteCategories();
    }

    @Test
    public void validate_EditCategory(){
        setupCreateCategory();
        managerGlobalCategoriesPage.clickEdit(Category_bug);

        Assert.assertTrue(managerGlobalCategoriesPage.isEditGlobalCategoryPage());
    }

    @Test
    public void validate_ManagerGlobalCategoryPage(){
        new ManagerProjectTest().validateAccess_ManagerProjectPage();
        managerGlobalCategoriesPage = new ManagerGlobalCategoriesPage();

        Assert.assertTrue(managerGlobalCategoriesPage.isManagerGlobalCategoryPage());
    }

    private void setupCreateCategory() {
        setupManagerCategory();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
        managerGlobalCategoriesPage.clickAddCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.isCategoryNameUsing());
    }

    private void setupManagerCategory() {
        validate_ManagerGlobalCategoryPage();
        ManagerProjectPage managerProjectPage = new ManagerProjectPage();
        managerProjectPage.clickManagerProjectsPage();
        String projectName1 = "Automação parte 1";

        if (!managerProjectPage.isNewProjectShowing(projectName1)) {
            managerProjectPage.clickNewProject();
            managerProjectPage.setProjectName(projectName1);
            managerProjectPage.setStateRelease();
            managerProjectPage.setExtendsGlobalCategory();
            managerProjectPage.setProjectPrivate();
            managerProjectPage.setProjectDescription("testind description");
            managerProjectPage.clickAddProject();
            Assert.assertTrue(managerProjectPage.isNewProjectShowing(projectName1));
        }
        deleteCategories();
    }

    private void deleteCategories() {

        if (managerGlobalCategoriesPage.existCategory(Category_bug)) {
            managerGlobalCategoriesPage.clickDelete(Category_bug);
            managerGlobalCategoriesPage.clickConfirmDeleteCategory();
            Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_bug));
        }

        if (managerGlobalCategoriesPage.existCategory(Category_feature)) {
            managerGlobalCategoriesPage.clickDelete(Category_feature);
            managerGlobalCategoriesPage.clickConfirmDeleteCategory();
            Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_feature));
        }

        if (managerGlobalCategoriesPage.existCategory(Category_improvement)) {
            managerGlobalCategoriesPage.clickDelete(Category_improvement);
            managerGlobalCategoriesPage.clickConfirmDeleteCategory();
            Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_improvement));
        }
    }

}
