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
//        DBFactory dbFactory = new DBFactory();
//
//        dbFactory.DBRunQuery("TRUNCATE TABLE mantis_bug_text_table");
//        dbFactory.DBRunQuery("TRUNCATE TABLE mantis_project_table");
//        dbFactory.DBRunQuery("TRUNCATE TABLE mantis_category_table");
//        dbFactory.DBRunQuery("INSERT INTO mantis_category_table (id, project_id, user_id, name, status) " +
//                "VALUES (1, 0, 0, \"General\", 0);");
        System.out.println("db");

    }

    @BeforeMethod
    public void setup() throws SQLException {
        System.out.println("setup");

        DBFactory dbFactory = new DBFactory();
        dbFactory.DBRunQuery("TRUNCATE TABLE mantis_bug_table");
        dbFactory.DBRunQuery("TRUNCATE TABLE mantis_bug_history_table");
        System.out.println("and setp");
        new BaseElement().goToPage(PropertyManager.getInstance().getURL());
    }


    @AfterMethod
    public void tearDown() {
        Driver.getDriverInstance().close();
        Driver.setDriverNull();
    }

}
