package tests.ManagerTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Manager.ManagerGlobalCategoriesPage;
import pages.Manager.ManagerProjectPage;
import tests.Base.BaseTest;
import tests.Login.LoginTest;

public class ManagerGlobalCategoriesTest extends BaseTest {

    private ManagerGlobalCategoriesPage managerGlobalCategoriesPage;
    private String Category_bug = "Bug";
    private String Category_feature = "Feature";
    private String Category_improvement = "Melhoria";

    @Test
    public void createNewGlobalCategory() {
        setupManagerCategory();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
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
        setupCreateCategory();
        managerGlobalCategoriesPage.clickEdit(Category_bug);

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
    public void createNewGlobalCategory_Delete() {
        setupCreateCategory();

        managerGlobalCategoriesPage.clickDelete(Category_bug);
        managerGlobalCategoriesPage.clickConfirmDeleteCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.existCategory(Category_bug));
        deleteCategories();
    }

    private void setupCreateCategory() {
        setupManagerCategory();
        managerGlobalCategoriesPage.setCategoryName(Category_bug);
        managerGlobalCategoriesPage.clickAddCategory();

        Assert.assertFalse(managerGlobalCategoriesPage.isCategoryNameUsing());
    }

    private void setupManagerCategory() {
        managerGlobalCategoriesPage = new ManagerGlobalCategoriesPage();

        new LoginTest().validLoginTest();
        ManagerProjectPage managerProjectPage = new ManagerProjectPage();
        managerProjectPage.gotoManagerProjects();
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

        managerGlobalCategoriesPage.gotoManagerGlobalCategoriesPage();
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
