package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;

public class FileUploadPage extends BasePage {

    private final By uploadInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final String filesPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "UploadFiles" + File.separator;
    private final String fileName = "image.jpg";
    private final By uploadedFiles = By.id("uploaded-files");


    public FileUploadPage uploadFile() {
        findElement(uploadInput).sendKeys(filesPath + fileName);
        return this;
    }

    public FileUploadPage clickUploadButton() {
        findElement(uploadButton).click();
        return this;
    }

    public FileUploadPage checkUploadedFile() {
        Assert.assertEquals(findElement(uploadedFiles).getText(), fileName);
        return this;
    }

}
