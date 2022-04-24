package Lecture_19;

import MySQL.SelectHelper;
import MySQL.UpdateHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class MySQL_Test {

    SelectHelper selectHelper;
    UpdateHelper updateHelper;

    @BeforeMethod
    public void precondition() {
        selectHelper = new SelectHelper();
        updateHelper = new UpdateHelper();
    }

    @Test(priority = 1)
    public void select_test() throws SQLException {
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").get(0).size(), 3);
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").get(0).get(1), "London");
    }

    @Test(priority = 2)
    public void update_test() throws SQLException {
        Assert.assertEquals(updateHelper.update("update VITALY_LOCATION set code = '123' where id = 1"), 1);
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").get(0).get(2), "123");

        Assert.assertEquals(updateHelper.update("update VITALY_LOCATION set code = 'LON' where id = 1"), 1);
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").get(0).get(2), "LON");
    }

    @Test(priority = 3)
    public void insert_test() throws SQLException {
        Assert.assertEquals(updateHelper.update("insert into VITALY_LOCATION (id, name, code) values (2, 'Paris', 'PAR')"), 1);
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").get(1).get(1), "Paris");
    }

    @Test(priority = 4)
    public void delete_test() throws SQLException {
        Assert.assertEquals(updateHelper.update("delete from VITALY_LOCATION where id = 2"), 1);
        Assert.assertEquals(selectHelper.select("select * from VITALY_LOCATION").size(), 1);
    }

    @AfterMethod
    public void tearDown() {
        selectHelper.closeConnect();
    }
}
