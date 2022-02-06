package Lecture_7;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lecture_7 extends BaseTest {

    @Test(priority = 1)
    public void dropdownTest() {
        //Go to the Dropdown page
        driver.get(context.getSuite().getParameter("url"));
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        dropdownLink.click();
        //Elements on the Dropdown page
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdownList);
        List<WebElement> options = driver.findElements(By.tagName("option"));
        //Actions
        for (int i = 0; i < options.size(); i++) {
            dropdownSelect.selectByIndex(i);
            Assert.assertTrue(options.get(i).isSelected());
            for (int j = 0; j < options.size(); j++) {
                if (j != i) {
                    Assert.assertFalse(options.get(j).isSelected());
                }
            }
        }
    }

    @Test(priority = 2)
    public void checkboxTest() {
        //Go to the checkboxes page
        driver.get(context.getSuite().getParameter("url"));
        WebElement checkboxesLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();
        //Elements on the checkboxes page
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input"));
        //Select checkboxes
        for (int i = 0; i < 2; i++) {
            checkboxes.forEach((checkbox) -> {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    Assert.assertTrue(checkbox.isSelected());
                } else {
                    checkbox.click();
                    Assert.assertFalse(checkbox.isSelected());
                }
            });
        }

    }
}
