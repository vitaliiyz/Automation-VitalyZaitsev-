package Lecture_13;

import BaseObjects.BaseTest;
import Herokuapp.Pages.JavascriptAlertsPage;
import org.testng.annotations.Test;

import static Herokuapp.Pages.JavascriptAlertsPage.Button.CONFIRM;
import static Herokuapp.Pages.JavascriptAlertsPage.Button.PROMPT;

public class JavascriptAlertsTest extends BaseTest {

    @Test
    public void JavascriptAlertsTest() {
        getPage(JavascriptAlertsPage.class)
                .checkTitle("JavaScript Alerts");

        getPage(JavascriptAlertsPage.class)
                .clickButton(CONFIRM)
                .checkAlertText("I am a JS Confirm")
                .confirmAlert()
                .clickButton(PROMPT)
                .checkAlertText("I am a JS prompt")
                .enterPromptText()
                .confirmAlert()
                .verifyPromptResult();
    }
}
