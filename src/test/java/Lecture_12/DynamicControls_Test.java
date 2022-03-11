package Lecture_12;

import BaseObjects.BaseTest;
import Herokuapp.Pages.DynamicControlsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControls_Test extends BaseTest {

    DynamicControlsPage dynamicControlsPage;

    @BeforeTest
    public void preconditions() {
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void checkbox_Test() {
        dynamicControlsPage
                .checkCheckbox(true)
                .clickButton("Remove")
                .checkMessageAfterClicking("It's gone!")
                .checkCheckbox(false);
    }

    @Test
    public void input_Text() {
        dynamicControlsPage
                .checkInput(false)
                .clickButton("Enable")
                .checkMessageAfterClicking("It's enabled!")
                .checkInput(true);
    }
}
