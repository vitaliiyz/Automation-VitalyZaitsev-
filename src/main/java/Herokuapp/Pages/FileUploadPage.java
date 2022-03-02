package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FileUploadPage extends BasePage {

    private final By uploadInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final String filesPath = "C:\\Users\\abookBY\\IdeaProjects\\AutomationVitalyZaitsev\\src\\main\\java\\UploadFiles\\";
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
//        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedFiles));
        Assert.assertEquals(findElement(uploadedFiles).getText(), fileName);
        return this;
    }

}
