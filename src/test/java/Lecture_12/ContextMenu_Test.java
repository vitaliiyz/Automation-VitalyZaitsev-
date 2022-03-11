package Lecture_12;

import BaseObjects.BaseTest;
import Herokuapp.Pages.ContextMenuPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu_Test extends BaseTest {
    ContextMenuPage contextMenuPage;

    @BeforeTest
    public void preconditions() {
        contextMenuPage = new ContextMenuPage();
    }

    @Test
    public void contextMenu_Test() {
        contextMenuPage
                .rightClickOnBox()
                .checkAlertText()
                .closeAlert();
    }
}
