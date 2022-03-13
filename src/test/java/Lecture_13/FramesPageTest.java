package Lecture_13;

import BaseObjects.BaseTest;
import Herokuapp.Pages.FramesPage;
import org.testng.annotations.Test;

public class FramesPageTest extends BaseTest {

    @Test
    public void iFramePageTest() {
        getPage(FramesPage.class)
                .checkTitle("Frames")
                .clickLinkByText("iFrame")
                .checkTitle("An iFrame containing the TinyMCE WYSIWYG Editor");

        getPage(FramesPage.class)
                .switchToFrame()
                .checkFrameContent();
    }
}
