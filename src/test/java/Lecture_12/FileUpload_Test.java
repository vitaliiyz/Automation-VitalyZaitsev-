package Lecture_12;

import BaseObjects.BaseTest;
import Herokuapp.Pages.FileUploadPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload_Test extends BaseTest {

    FileUploadPage fileUploadPage;

    @BeforeTest
    public void preconditions() {
        fileUploadPage = new FileUploadPage();
    }

    @Test
    public void fileUpload_Test() {
        fileUploadPage
                .uploadFile()
                .clickUploadButton()
                .checkUploadedFile();
    }
}
