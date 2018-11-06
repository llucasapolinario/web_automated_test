package tests.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.Base.BaseElement;
import utils.DBFactory;
import utils.Driver;
import utils.PropertyManager;

import java.sql.SQLException;

@Listeners(extentReport.TestListener.class)

public class BaseTest {

    @BeforeSuite
    public void cleanDB() throws SQLException {
        DBFactory dbFactory = new DBFactory();

        String returnSql;
        returnSql = dbFactory.DBRunQuery("TRUNCATE TABLE mantis_bug_tag_table");
        System.out.println(returnSql);
        returnSql = dbFactory.DBRunQuery("TRUNCATE TABLE mantis_project_table");
        System.out.println(returnSql);

    }

    @BeforeMethod
    public void setup() {
        new BaseElement().goToPage(PropertyManager.getInstance().getURL());
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriverInstance().close();
        Driver.setDriverNull();
    }

}
