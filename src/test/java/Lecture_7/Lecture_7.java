package Lecture_7;

import org.testng.annotations.Test;
import static BaseObjects.DriverCreation.*;

public class Lecture_7 {

    @Test
    public void test() {
        getDriver().get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/994-raschet-indeksa-massy-tela");
        closeDriver();
    }

}
